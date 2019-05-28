package com.xsyu.entity;

import java.util.ArrayList;
import java.util.List;

public class StuInfo {
    private int stuId;
    private String stuName;
    private String stuGender;

    public StuInfo(int stuId, String stuName, String stuGender) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
    }

    public StuInfo(String stuName, String stuGender) {
        this.stuName = stuName;
        this.stuGender = stuGender;
    }

    public StuInfo(){}

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                '}';
    }
}
