package com.ioc_01;
//基于静态工厂方法
public class ClientService {
    private static ClientService clientService = new ClientService();

    public ClientService() {
    }

    public static ClientService createInstance() {

        return clientService;
    }
}