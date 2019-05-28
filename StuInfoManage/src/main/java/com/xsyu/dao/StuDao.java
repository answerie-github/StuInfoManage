package com.xsyu.dao;

import com.xsyu.entity.StuInfo;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StuDao {
    /**
     * 列出学生列表
     * @return
     */
    List<StuInfo> queryStu();

    /**
     * 增加学生
     * @param stuInfo
     * @return
     */
    int insertStu(StuInfo stuInfo);

    /**
     * 更新学生信息
     * @param stuInfo
     * @return
     */
    int updateStu(StuInfo stuInfo);

    /**
     * 删除学生信息
     * @param stuInfo
     * @return
     */
    int deleteStu(StuInfo stuInfo);
}
