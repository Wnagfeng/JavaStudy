package com.ioc_01;
//基于实例工厂方法实例化
public class DefaultServiceLocator {

    private static ClientServiceImpl clientService = new ClientServiceImpl();

    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}
