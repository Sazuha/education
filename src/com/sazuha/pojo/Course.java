package com.sazuha.pojo;

/**
 * @author Sazuha
 */
public class Course {
    private Integer id;
    private String cname;
    private Integer time;
    private Integer stunum;
    private Integer maxnum;
    private String teacher;
    private String classroom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getStunum() {
        return stunum;
    }

    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Course() {
    }

    public Course(Integer id, String cname, Integer time, Integer stunum, Integer maxnum, String teacher, String classroom) {
        this.id = id;
        this.cname = cname;
        this.time = time;
        this.stunum = stunum;
        this.maxnum = maxnum;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", time=" + time +
                ", stunum=" + stunum +
                ", maxnum=" + maxnum +
                ", teacher='" + teacher + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
