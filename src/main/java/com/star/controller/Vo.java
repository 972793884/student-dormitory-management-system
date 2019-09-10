package com.star.controller;


import com.star.vo.User;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vo {
    public List<String> tab =new ArrayList<>();

    public Integer save(){
        /*是否启用null值更新*/
        return save(false);
    }
    public Integer save(boolean state) {
        tab.forEach(x-> System.out.println(x));
        System.out.println(this.getClass().getSimpleName());
        String table =getColumnName(getTableName(this.getClass().getSimpleName()));
        Class clz = this.getClass();
        Field[] fields = clz.getDeclaredFields();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer columns = new StringBuffer();
        StringBuffer values = new StringBuffer();
        StringBuffer where = new StringBuffer();
        List<Object> list = new ArrayList<>();
        String sql;
        boolean type = true;/*true表示插入false表示更新*/
        for (Field field : fields) {
            try {
                if ("serialVersionUID".equals(field.getName()))
                    continue;
                Method method = clz.getMethod("get" + getMethodName(field.getName()));
                Object value = method.invoke(this);
                String column = getColumnName(field.getName());
                if ("id".equals(column)) {
                    /*id不是null则为更新*/
                    if (value != null) {
                        stringBuffer.append("update "+ table +" set ");
                        type = false;
                        where.append(" where id=" + value);
                        continue;
                    } else {
                        stringBuffer.append("insert into " + table + "(");
                    }
                }
                if (value != null || (state&&tab.contains(field.getName().toLowerCase()))) {
                    if (type) {
                        columns.append(column + ",");
                        values.append("?,");
                        list.add(value);
                    } else {
                        stringBuffer.append(column + "=?,");
                        list.add(value);
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (list==null||list.size()<1){
            return 1;
        }
        /*-1是去掉最后一个逗号*/
        if (type) {
            stringBuffer.append(columns.substring(0, columns.length() - 1));
            stringBuffer.append(") values (");
            stringBuffer.append(values.substring(0, values.length() - 1));
            stringBuffer.append(")");
            sql = stringBuffer.toString();
        } else {
            sql = stringBuffer.substring(0, stringBuffer.length() - 1);
            sql += where.toString();
        }


        try {
            return getPreparedStatement(sql,list).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public <T> T findById(Integer id){
        T t =(T)this;
        String table =getColumnName(getTableName(this.getClass().getSimpleName()));
        List<Object> list =new ArrayList<>();
        list.add(id);
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("select * from "+table+" where id=?");
        try {
            ResultSet resultSet = getPreparedStatement(stringBuffer.toString(),list).executeQuery();
            Class clz = this.getClass();
            Field[] fields = clz.getDeclaredFields();
            while (resultSet.next()){
                for (Field field:fields){
                    if ("serialVersionUID".equals(field.getName()))
                        continue;
                    Method method = clz.getMethod("set" + getMethodName(field.getName()),field.getType());
                    method.invoke(t,resultSet.getObject(getColumnName(field.getName())));
                }
            }
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    private PreparedStatement getPreparedStatement(String sql,List<Object> param){
        tab.clear();
        System.out.println(sql);
        Connection connection = getConn();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < param.size(); i++) {
                if (param.get(i) instanceof Integer) {
                    statement.setInt(i + 1, (int) param.get(i));
                } else if (param.get(i) instanceof Date) {
                    statement.setTimestamp(i + 1, new Timestamp(((Date) param.get(i)).getTime()));
                } else if (param.get(i) instanceof Double) {
                    statement.setDouble(i + 1, (double) param.get(i));
                } else if (param.get(i) instanceof Float) {
                    statement.setFloat(i + 1, (float) param.get(i));
                } else if (param.get(i) instanceof BigDecimal) {
                    statement.setBigDecimal(i + 1, (BigDecimal) param.get(i));
                }/*else if (param.get(i) ==null){
                    statement.setNull(i+1,);
                }*/
                else {
                    statement.setString(i + 1, (String) param.get(i));
                }
            }
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.logMsg(1,"获取statement失败!sql预编译失败");
        return null;
    }
    public Integer delete(Integer id){
       return delete(id,false);
    }
    public Integer delete(Integer id,boolean rel){
        String table =getColumnName(getTableName(this.getClass().getSimpleName()));
        List<Object> list =new ArrayList<>();
        list.add(id);
        /*Logger.logMsg(2,"0.0.0.0.0.0.0.0.0.0.");*/
        StringBuffer stringBuffer =new StringBuffer();
        if (rel)
            stringBuffer.append("delete from "+table+" where id=?");
        else
            stringBuffer.append("update "+table+" set is_delete=1 where id=?");
        try {
            return getPreparedStatement(stringBuffer.toString(),list).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    static Connection conn;

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/springBoot";
        String username = "root";
        String password = "root";
        if (conn != null)
            return conn;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);

    }

    private static String getTableName(String ClassName) {
        byte[] items = ClassName.getBytes();
        items[0] = (byte) ((char) items[0] + 32);
        return new String(items);

    }

    private static String getColumnName(String fildeName) {
        byte[] items = fildeName.getBytes();
        String[] str = fildeName.split("");
        for (int i = 0; i < str.length; i++) {
            if ((char) (str[i].getBytes()[0]) < 90) {
                str[i] = "_" + (char) (str[i].getBytes()[0] + 32);
            }
        }
        StringBuffer column = new StringBuffer();

        for (int i = 0; i < str.length; ++i) {
            column.append(str[i]);
        }
        return column.toString();

    }

    @RequestMapping("vo")
    public void bb(User user) {
        /*User user = new User();
        user.setName("ls");
        user.setPassword("666");
        user.setSignInTime(null);
        user.setId(7);*/
        user.setSignInTime(null);
        user.save(true);
        /*UserRole userRole =new UserRole();
        userRole.setIsLocked(1);
        userRole.setIsDelete(0);
        userRole.delete(6,true);*/
    }
}
