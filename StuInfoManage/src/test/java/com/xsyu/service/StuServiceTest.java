package com.xsyu.service;

import com.xsyu.BaseTest;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;
import com.xsyu.enums.StuStateEnums;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class StuServiceTest extends BaseTest {
    @Autowired
    private StuService stuService;
    @Test
    public void test(){
        StuInfo stuInfo = new StuInfo();
        stuInfo.setStuId(10012);
        stuInfo.setStuName("小雀");
        stuInfo.setStuGender("女");
        stuInfo.setStuState(StuStateEnums.SUCCESS.getState());
        File img = new File("image/满岛光.jpg");

        StuExecution stuExecution = stuService.addStu(stuInfo,img);
        System.out.println(stuExecution.getState());
    }
}
