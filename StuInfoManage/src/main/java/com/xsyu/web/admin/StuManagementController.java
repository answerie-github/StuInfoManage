package com.xsyu.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsyu.dto.StuExecution;
import com.xsyu.entity.StuInfo;
import com.xsyu.enums.StuStateEnums;
import com.xsyu.service.StuService;
import com.xsyu.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stuadmin")
public class StuManagementController {
    Logger logger = LoggerFactory.getLogger(StuManagementController.class);

    @Autowired
    private StuService stuService;

    @RequestMapping(value = "/stuList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listStu() {
        logger.info("=====start======");
        long starTime = System.currentTimeMillis();

        Map<String, Object> modelMap = new HashMap<>();
        List<StuInfo> stuList = new ArrayList<>();
        try {
            stuList = stuService.getStuList();
            modelMap.put("rows", stuList);
            modelMap.put("total", stuList.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }

        logger.error("test error!");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]", endTime - starTime);
        logger.info("=====end====");


        return modelMap;
    }

    @RequestMapping(value = "/registerStu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerStu(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();

        //获取前端传来的信息 并转换成实体类
        String stuStr = HttpServletRequestUtil.getString(request, "stuStr");
        ObjectMapper mapper = new ObjectMapper();
        StuInfo stu = null;
        try {
            stu = mapper.readValue(stuStr, StuInfo.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        //接收图片文件流
        CommonsMultipartFile stuImg = null;
        //解析request中的信息
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        //判断是否有上传的文件流
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest =
                    (MultipartHttpServletRequest) request;
            stuImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("stuImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }

        //注册学生
        if (stu != null && stuImg != null) {
            StuExecution stuExecution = null;
            try {
                stuExecution = stuService.addStu(stu, stuImg.getInputStream(), stuImg.getOriginalFilename());
                if (stuExecution.getState() == StuStateEnums.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", stuExecution.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入学生信息");
            return modelMap;
        }

    }
}
