package com.xsyu.web.admin;

import com.xsyu.entity.StuInfo;
import com.xsyu.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stuadmin")
public class StuController {
    Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuService stuService;

    @RequestMapping(value = "/liststu", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listStu(){
        logger.info("=====start======");
        long starTime = System.currentTimeMillis();

        Map<String, Object> modelMap = new HashMap<>();
        List<StuInfo> stuList = new ArrayList<>();
        try {
            stuList = stuService.getStuList();
            modelMap.put("rows", stuList);
            modelMap.put("total", stuList.size());
        } catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg", e.toString());
        }

        logger.error("test error!");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]", endTime - starTime);
        logger.info("=====end====");


        return modelMap;
    }
}
