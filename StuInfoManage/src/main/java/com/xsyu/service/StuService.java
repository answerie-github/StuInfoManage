package com.xsyu.service;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;

import java.io.File;
import java.util.List;

public interface StuService {
    StuExecution addStu(StuInfo stu, File stuImg);

    List<StuInfo> getStuList();
}
