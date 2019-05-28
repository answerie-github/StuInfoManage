package com.xsyu.service;

import com.xsyu.BaseTest;
import com.xsyu.entity.StuInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StuServiceTest extends BaseTest {
    @Autowired
    private StuService stuService;
    @Test
    public void test(){
        List<StuInfo> stuList = stuService.getStuList();
        System.out.println(stuList.get(0).getStuName());
    }
}
