package org.example.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SoldierServiceimpl")
public class SoldierServiceimpl implements soldierService {
    @Autowired

    private SoldierDao soldierDao;

    public void getMessage() {
        soldierDao.getMessage();
    }
}