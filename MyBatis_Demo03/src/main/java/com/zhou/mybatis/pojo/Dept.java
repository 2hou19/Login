package com.zhou.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

    private Integer id;

    private String deptName;

    private String loc;

    private List<Emp> emps;

    public Dept(Integer id, String deptName, String loc, List<Emp> emps) {
        this.id = id;
        this.deptName = deptName;
        this.loc = loc;
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", loc='" + loc + '\'' +
                ", emps=" + emps +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept() {
    }
}
