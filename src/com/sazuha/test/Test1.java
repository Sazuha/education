package com.sazuha.test;

/**
 * @author ASUS
 */
public class Test1 {
 private int DEPTNO;
 private String DNAME;
 private String LOC;

    public Test1() {
    }

    public Test1(int DEPTNO, String DNAME, String LOC) {
        this.DEPTNO = DEPTNO;
        this.DNAME = DNAME;
        this.LOC = LOC;
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    public String getLOC() {
        return LOC;
    }

    public void setLOC(String LOC) {
        this.LOC = LOC;
    }

    @Override
    public String toString() {
        return "\nTest1{" +
                "DEPTNO=" + DEPTNO +
                ", DNAME='" + DNAME + '\'' +
                ", LOC='" + LOC + '\'' +
                '}';
    }
}
