package com.xsyu.entity;

import java.util.ArrayList;
import java.util.List;

public class StuInfo {
    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuImg;
    private int stuState;

    public StuInfo(int stuId, String stuName, String stuGender, String stuImg, int stuState) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuImg = stuImg;
        this.stuState = stuState;
    }

    public int getStuState() {
        return stuState;
    }

    public void setStuState(int stuState) {
        this.stuState = stuState;
    }

    public StuInfo(String stuName, String stuGender, String stuImg) {
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuImg = stuImg;
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

    public String getStuImg() {
        return stuImg;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuImg='" + stuImg + '\'' +
                ", stuState='" + stuState + '\'' +
                '}';
    }
}
