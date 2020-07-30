package com.kohyoung.spc.mng.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class FreemarkerController {

    @Autowired
    CodeService codeService;

    @GetMapping("/hello")
    public String hello(ModelMap model){
        model.put("message", "hello freemarker!");

        Code param = new Code();
        HashMap map = new HashMap();
        List<Code> codeList = codeService.searchList(map); // selectList(param);

        model.put("codeList", codeList);

        return "hello";
    }
}