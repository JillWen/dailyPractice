package com.wj.po;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wj on 2018/1/14.
 */
public class Student {
    private String id;
    private String name;
    private List<ClassPO> classes = new ArrayList<ClassPO>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassPO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassPO> classes) {
        this.classes = classes;
    }
}
