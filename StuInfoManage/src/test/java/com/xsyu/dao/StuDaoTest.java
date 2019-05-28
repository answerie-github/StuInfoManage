package com.xsyu.dao;

import com.xsyu.BaseTest;
import com.xsyu.entity.StuInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StuDaoTest extends BaseTest {
    @Autowired
    private StuDao stuDao;

    @Test
    public void testQueryStu(){
        List<StuInfo> stuList = stuDao.queryStu();
        for (StuInfo stu :
                stuList) {
            System.out.println(stu);
        }
    }

    @Test
    public void TestInsertStu(){
        StuInfo stuInfo = new StuInfo("任涛","男");
        System.out.println(stuDao.insertStu(stuInfo));
    }

    @Test
    public void testUpdateStu(){
        StuInfo stuInfo = new StuInfo(10001,"新垣结衣","女");
        System.out.println(stuDao.updateStu(stuInfo));
    }

    @Test
    public void testDeleteStu(){
        StuInfo stuInfo = new StuInfo();
        stuInfo.setStuName("任涛");
        System.out.println(stuDao.deleteStu(stuInfo));
    }
}
