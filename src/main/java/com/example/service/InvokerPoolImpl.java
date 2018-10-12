package com.example.service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.example.model.DubboRequest;

import java.util.List;
import java.util.Map;

public class InvokerPoolImpl {



    public Object genericInvoke(DubboRequest dubboRequest,String interfaceClass, String methodName, List<Map<String, Object>> parameters){

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(new ApplicationConfig(dubboRequest.getApplicationName()));
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboRequest.getZkUrl());
//        reference.setRegistry(registryConfig);
        reference.setInterface(interfaceClass); // 接口名
        reference.setUrl(dubboRequest.getDubboUrl());
        reference.setVersion(dubboRequest.getDubboVersion());
        reference.setGroup(dubboRequest.getDubboGroup());
        reference.setGeneric(true); // 声明为泛化接口

        //ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
        //需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
        //API方式编程时，容易忽略此问题。
        //这里使用dubbo内置的简单缓存工具类进行缓存

        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);

        int len = parameters.size();
        String[] invokeParamTyeps = new String[len];
        Object[] invokeParams = new Object[len];
        for(int i = 0; i < len; i++){
            invokeParamTyeps[i] = parameters.get(i).get("ParamType") + "";
            invokeParams[i] = parameters.get(i).get("Object");
        }
        return genericService.$invoke(methodName, invokeParamTyeps, invokeParams);
    }

}
