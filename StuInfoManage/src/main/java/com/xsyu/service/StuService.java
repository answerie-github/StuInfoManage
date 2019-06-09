package com.xsyu.service;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface StuService {
    StuExecution addStu(StuInfo stu, InputStream stuImgInputStream, String fileName);

    List<StuInfo> getStuList();
}
