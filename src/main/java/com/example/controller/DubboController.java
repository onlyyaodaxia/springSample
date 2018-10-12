package com.example.controller;

import com.example.model.DubboRequest;
import com.example.service.InvokerPoolImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dubbo")
@ResponseBody

public class DubboController {
    @RequestMapping("/send")
    public  String sendDubbo(@RequestBody DubboRequest dubboRequest){
        System.out.println("into dubbo send........");
        dubboRequest.setApplicationName("wyytest");
        InvokerPoolImpl dubbo = new InvokerPoolImpl();
        System.out.println(dubboRequest.toString());

        String result=dubbo.genericInvoke(dubboRequest,dubboRequest.getInterfaceName(),dubboRequest.getMethodName(),dubboRequest.getMethodParams()).toString();
        return result;
    }

    @RequestMapping("/index")
    public  String sendDubbo( ){
        return  "dubbo";
    }
    public static void main(String[] args) {
        DubboRequest dubboRequest = new DubboRequest();
        dubboRequest.setInterfaceName("com.example.api.DemoService");
        dubboRequest.setMethodName("callPerson");
        dubboRequest.setApplicationName("wyytest");
        dubboRequest.setDubboUrl("dubbo://127.0.0.1:20880");  //直连
//        dubboRequest.setDubboVersion("1.0.0test");
//        dubboRequest.setZkUrl("dubbo://127.0.0.1:2181");

        List<Map<String, Object>> params = new ArrayList();
        Map param = new HashMap();
        param.put("ParamType", "com.example.model.Person");  //后端接口参数类型
        Map map = new HashMap();
        map.put("name","wyy");
        param.put("Object", map);  //用以调用后端接口的实参
        params.add(param);

        dubboRequest.setMethodParams(params);
        ObjectMapper mapper = new ObjectMapper();

        InvokerPoolImpl dubbo = new InvokerPoolImpl();
        String result=dubbo.genericInvoke(dubboRequest,dubboRequest.getInterfaceName(),dubboRequest.getMethodName(),dubboRequest.getMethodParams()).toString();
        System.out.println("invoke result: "+result);

    }
}
