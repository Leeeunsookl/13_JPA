package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager manager;

    public EntityManager getManagerInstance() {

        return manager;
    }

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();

        return manager.find(Menu.class, menuCode);

    }
}
