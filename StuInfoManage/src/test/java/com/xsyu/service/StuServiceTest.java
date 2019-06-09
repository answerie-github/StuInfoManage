package com.xsyu.service;

import com.xsyu.BaseTest;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;
import com.xsyu.enums.StuStateEnums;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class StuServiceTest extends BaseTest {
    @Autowired
    private StuService stuService;
    @Test
    public void test() throws FileNotFoundException {
        StuInfo stuInfo = new StuInfo();
        stuInfo.setStuId(10013);
        stuInfo.setStuName("别府");
        stuInfo.setStuGender("男");
        stuInfo.setStuState(StuStateEnums.SUCCESS.getState());
        File img = new File("image/松田龙平.jpg");

        InputStream inputStream = new FileInputStream(img);

        StuExecution stuExecution = stuService.addStu(stuInfo,inputStream,img.getName());
        System.out.println(stuExecution.getState());
    }
}
