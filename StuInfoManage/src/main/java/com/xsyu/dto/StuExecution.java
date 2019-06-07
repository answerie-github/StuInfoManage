package com.xsyu.dto;

import com.xsyu.entity.StuInfo;
import com.xsyu.enums.StuStateEnums;

import java.util.List;

public class StuExecution {
    //存储学生的信息和学生的状态值
    private int state;

    //解释state
    private String stateInfo;

    private int count;

    private StuInfo stu;

    private List<StuInfo> stuList;

    public StuExecution(){}

    //操作失败
    public StuExecution(StuStateEnums stuStateEnums){
        this.state = stuStateEnums.getState();
        this.stateInfo = stuStateEnums.getStateInfo();
    }

    //success
    public StuExecution(StuStateEnums stuStateEnums, StuInfo stu){
        this.state = stuStateEnums.getState();
        this.stateInfo = stuStateEnums.getStateInfo();
        this.stu = stu;
    }

    //success
    public StuExecution(List<StuInfo> stuList, StuStateEnums stuStateEnums) {
        this.stuList = stuList;
        this.state = stuStateEnums.getState();
        this.stateInfo = stuStateEnums.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StuInfo getStu() {
        return stu;
    }

    public void setStu(StuInfo stu) {
        this.stu = stu;
    }

    public List<StuInfo> getStuList() {
        return stuList;
    }

    public void setStuList(List<StuInfo> stuList) {
        this.stuList = stuList;
    }
}
