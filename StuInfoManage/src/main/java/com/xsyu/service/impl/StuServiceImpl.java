package com.xsyu.service.impl;

import com.xsyu.dao.StuDao;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;
import com.xsyu.enums.StuStateEnums;
import com.xsyu.exceptions.StuOperationException;
import com.xsyu.service.StuService;
import com.xsyu.util.ImageUtil;
import com.xsyu.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    @Transactional
    public StuExecution addStu(StuInfo stu, InputStream stuImgInputStream, String fileName) {
        if (stu == null){
            return new StuExecution(StuStateEnums.NULL_STU);
        }
        try {
            //默认在校
            stu.setStuState(1);
            int effectedNum = stuDao.insertStu(stu);
            if(effectedNum <= 0){
                throw new StuOperationException("学生信息创建失败");
            }else {
                if (stuImgInputStream != null){
                    //添加照片
                    try {
                        addStuImg(stu, stuImgInputStream, fileName);
                    } catch (Exception e){
                        throw new StuOperationException("addStuImg失败:" + e.getMessage());
                    }
                    effectedNum = stuDao.updateStu(stu);
                    if (effectedNum <= 0){
                        throw new StuOperationException("更新图片失败");
                    }
                }
            }

        }catch (Exception e){
            throw new RuntimeException("addStu error:" + e.getMessage());
        }
        return new StuExecution(StuStateEnums.SUCCESS, stu);
    }

    private void addStuImg(StuInfo stu, InputStream stuImgInputStream, String fileName) {
        String dest = PathUtil.getStuImgPath(stu.getStuId());
        String stuImgAddr = ImageUtil.generateThumbnail(stuImgInputStream,fileName,dest);
        stu.setStuImg(stuImgAddr);
    }

    @Override
    public List<StuInfo> getStuList() {
        List<StuInfo> stuList = stuDao.queryStu();
        return stuList;
    }
}
