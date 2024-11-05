package org.example.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller(value = "tianDog")
public class SoldierController {
    @Autowired
    @Resource(name = "SoldierServiceimpl1")
    private soldierService soldierService;

    public void getMessage() {
        soldierService.getMessage();
    }

}