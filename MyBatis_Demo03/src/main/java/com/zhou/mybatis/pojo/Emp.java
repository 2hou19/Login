package com.zhou.mybatis.pojo;


import java.io.Serializable;

public class Emp implements Serializable {

   private Integer id;

   private String empName;

   private Integer jobId;

   private Integer mgr;

   private String joinDate;

   private Integer salary;

   private Integer bonus;

   private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", jobId=" + jobId +
                ", mgr=" + mgr +
                ", joinData='" + joinDate + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept=" + dept +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp(Integer id, String empName, Integer jobId, Integer mgr, String joinDate, Integer salary, Integer bonus, Dept dept) {
        this.id = id;
        this.empName = empName;
        this.jobId = jobId;
        this.mgr = mgr;
        this.joinDate = joinDate;
        this.salary = salary;
        this.bonus = bonus;
        this.dept = dept;
    }

    public Emp() {
    }
}
