package com.sazuha.pojo;

/**
 * @author ASUS
 */
public class Class_ {
    private Integer id;
    private String className;

    public Class_() {

    }

    public Class_(Integer id, String className) {
        this.id = id;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class_{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
