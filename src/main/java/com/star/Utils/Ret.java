package com.star.Utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.HashMap;
import java.util.Map;

public class Ret extends HashMap {
    private static final String STATE = "state";
    private static final String STATE_OK = "ok";
    private static final String STATE_FAIL = "fail";
    private static final String OLD_STATE_OK = "isOk";
    private static final String OLD_STATE_FAIL = "isFail";
    private static boolean newWorkMode = true;

    public static void setToOldWorkMode() {
        newWorkMode = false;
    }

    public Ret() {
    }

    public static Ret by(Object key, Object value) {
        return (new Ret()).set(key, value);
    }

    public static Ret create(Object key, Object value) {
        return (new Ret()).set(key, value);
    }

    public static Ret create() {
        return new Ret();
    }

    public static Ret ok() {
        return (new Ret()).setOk();
    }

    public static Ret ok(Object key, Object value) {
        return ok().set(key, value);
    }

    public static Ret fail() {
        return (new Ret()).setFail();
    }

    public static Ret fail(Object key, Object value) {
        return fail().set(key, value);
    }

    public Ret setOk() {
        if (newWorkMode) {
            super.put("state", "ok");
        } else {
            super.put("isOk", Boolean.TRUE);
            super.put("isFail", Boolean.FALSE);
        }

        return this;
    }

    public Ret setFail() {
        if (newWorkMode) {
            super.put("state", "fail");
        } else {
            super.put("isFail", Boolean.TRUE);
            super.put("isOk", Boolean.FALSE);
        }

        return this;
    }

    public boolean isOk() {
        if (newWorkMode) {
            Object state = this.get("state");
            if ("ok".equals(state)) {
                return true;
            }

            if ("fail".equals(state)) {
                return false;
            }
        } else {
            Boolean isOk = (Boolean)this.get("isOk");
            if (isOk != null) {
                return isOk;
            }

            Boolean isFail = (Boolean)this.get("isFail");
            if (isFail != null) {
                return !isFail;
            }
        }

        throw new IllegalStateException("调用 isOk() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
    }

    public boolean isFail() {
        if (newWorkMode) {
            Object state = this.get("state");
            if ("fail".equals(state)) {
                return true;
            }

            if ("ok".equals(state)) {
                return false;
            }
        } else {
            Boolean isFail = (Boolean)this.get("isFail");
            if (isFail != null) {
                return isFail;
            }

            Boolean isOk = (Boolean)this.get("isOk");
            if (isOk != null) {
                return !isOk;
            }
        }

        throw new IllegalStateException("调用 isFail() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
    }

    public Ret set(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    public Ret set(Map map) {
        super.putAll(map);
        return this;
    }

    public Ret set(Ret ret) {
        super.putAll(ret);
        return this;
    }

    public Ret delete(Object key) {
        super.remove(key);
        return this;
    }

    /*public <T> T getAs(Object key) {
        return this.get(key);
    }*/

    public String getStr(Object key) {
        Object s = this.get(key);
        return s != null ? s.toString() : null;
    }

    public Integer getInt(Object key) {
        Number n = (Number)this.get(key);
        return n != null ? n.intValue() : null;
    }

    public Long getLong(Object key) {
        Number n = (Number)this.get(key);
        return n != null ? n.longValue() : null;
    }

    public Number getNumber(Object key) {
        return (Number)this.get(key);
    }

    public Boolean getBoolean(Object key) {
        return (Boolean)this.get(key);
    }

    public boolean notNull(Object key) {
        return this.get(key) != null;
    }

    public boolean isNull(Object key) {
        return this.get(key) == null;
    }

    public boolean isTrue(Object key) {
        Object value = this.get(key);
        return value instanceof Boolean && (Boolean)value;
    }

    public boolean isFalse(Object key) {
        Object value = this.get(key);
        return value instanceof Boolean && !(Boolean)value;
    }

 /*   public String toJson() {
        return Json.getJson().toJson(this);
    }*/

    public boolean equals(Object ret) {
        return ret instanceof Ret && super.equals(ret);
    }
}
