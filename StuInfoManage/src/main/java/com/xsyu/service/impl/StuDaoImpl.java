package com.xsyu.service.impl;

import com.xsyu.dao.StuDao;
import com.xsyu.entity.StuInfo;
import com.xsyu.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuDaoImpl implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    public List<StuInfo> getStuList() {
        List<StuInfo> stuList = stuDao.queryStu();
        return stuList;
    }
}
