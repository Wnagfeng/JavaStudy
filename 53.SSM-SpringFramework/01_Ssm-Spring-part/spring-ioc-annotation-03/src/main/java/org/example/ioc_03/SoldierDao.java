package org.example.ioc_03;

import org.springframework.stereotype.Repository;

@Repository
public class SoldierDao {

    public void getMessage() {
        System.out.print("I am a soldier[soldierDao]");
    }

}