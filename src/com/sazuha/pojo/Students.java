package com.sazuha.pojo;

/**
 * @author Sazuha
 */
public class Students {
    private Integer id;
    private String username;
    private String password;
    private int cou1;
    private int cou2;

    public Students(Integer id, String username, String password, int cou1, int cou2) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cou1 = cou1;
        this.cou2 = cou2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cou1=" + cou1 +
                ", cou2=" + cou2 +
                '}';
    }

    public Students() {
    }

    public int getCou1() {
        return cou1;
    }

    public void setCou1(int cou1) {
        this.cou1 = cou1;
    }

    public int getCou2() {
        return cou2;
    }

    public void setCou2(int cou2) {
        this.cou2 = cou2;
    }
}

