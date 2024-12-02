package org.example.controller;

import org.example.pojo.Headline;
import org.example.service.HeadlineService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Headerline")
@CrossOrigin
public class HeaderLineController {
    @Autowired
    private HeadlineService headlineService;

    @PostMapping("/publishHeader")
    public Result publishHeader(@RequestBody Headline headline, @RequestHeader String token) {
        Result result = headlineService.publishHeader(headline, token);
        return result;
    }

    //    根据id获取头条
    @PostMapping("/getHeaderById")
    public Result getHeaderById(Integer id) {
        System.out.println("id:" + id);
        Map<String, Object> byId = (Map<String, Object>) headlineService.getById(id);
        System.out.println("headline:" + byId);

        //System.out.println("headline:" + byId);
        Map data = new HashMap();
        data.put("header", byId);
        return Result.ok(data);

    }

    @PostMapping("/ChangeHeader")
    public Result ChangeHeader(@RequestBody Headline headline) {
        Result result = headlineService.ChangeHeader(headline);
        return result;
    }

    @DeleteMapping("/deleteHeader")
    public Result deleteHeader(Integer id) {
        Result result = headlineService.deleteHeader(id);
        return result;
    }
}
