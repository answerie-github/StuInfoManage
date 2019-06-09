package com.xsyu.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "stuadmin",method = RequestMethod.GET)
public class StuAdminController {
    @RequestMapping("/stuoperation")
    public String stuOperation(){
        return "register";
    }

    @RequestMapping("/stulist")
    public String stuList(){
        return "homepage";
    }
}
