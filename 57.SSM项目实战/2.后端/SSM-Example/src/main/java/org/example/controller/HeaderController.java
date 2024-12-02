package org.example.controller;

import org.example.pojo.Headline;
import org.example.pojo.vo.Header;
import org.example.service.HeadlineService;
import org.example.service.TypeService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/header")
@CrossOrigin
public class HeaderController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    @RequestMapping("/getCategoryList")
    public Result getCategoryList() {
        Result result = typeService.getCategoryList();
        return result;
    }

    @PostMapping("/findNewPage")
    public Result findNewPage(@RequestBody Header header) {
        Result result = headlineService.findNewPage(header);
        return result;
    }

    @PostMapping("/DetailHeader")
    public Result DetailHeader(Integer id) {
        System.out.println(id);
        Result result = headlineService.DetailHeader(id);
        return result;
    }


}
