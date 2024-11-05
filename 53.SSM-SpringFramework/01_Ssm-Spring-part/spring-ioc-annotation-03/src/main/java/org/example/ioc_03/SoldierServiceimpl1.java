package org.example.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SoldierServiceimpl1")
public class SoldierServiceimpl1 implements soldierService {
    @Autowired

    private SoldierDao soldierDao;

    public void getMessage() {
        System.out.println("SoldierService1: ");
        soldierDao.getMessage();
    }
}