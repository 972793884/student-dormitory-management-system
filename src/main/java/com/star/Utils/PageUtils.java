package com.star.Utils;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Component
public  class PageUtils implements Serializable {
    //当前页
    private  Integer page;
    //最大页数
    private  Integer maxPage;
    //开始下标
    private  Integer star;
    //结束下标
    private  Integer end;
    //总数据条数
    private  Integer max;
    //每页条数
    private  Integer pageSize;

    private  List<Object> list =new ArrayList<>();

    public PageUtils(){

    }

    public Integer getPage() {
        return page;
    }
    public  PageUtils setPageList(List<? extends Object> myList, Integer myPage, Integer MyPageSize){
        pageSize = MyPageSize;
        max = myList.size();
        maxPage = (int)(Math.ceil((double) max/pageSize));
        page =Math.min(myPage,maxPage);
        page = Math.max(1,page);
        star =(page-1)*pageSize;
        end = (star+pageSize)>max?max:(star+pageSize);
        if(page==0){
            list=null;
            return null;
        }
        list.clear();
        list.addAll(myList.subList(star, end));
        return this;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }





}
