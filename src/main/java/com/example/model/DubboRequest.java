package com.example.model;

import java.util.List;
import java.util.Map;

public class DubboRequest {
    private String dubboUrl;
    private String zkUrl;
    private String applicationName;
    private String dubboVersion;
    private String dubboGroup;
    private String interfaceName;
    private String methodName;
    private List<Map<String, Object>> methodParams;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Map<String, Object>> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(List<Map<String, Object>> methodParams) {
        this.methodParams = methodParams;
    }

    public String getDubboUrl() {
        return dubboUrl;
    }

    public void setDubboUrl(String dubboUrl) {
        this.dubboUrl = dubboUrl;
    }

    public String getZkUrl() {
        return zkUrl;
    }

    public void setZkUrl(String zkUrl) {
        this.zkUrl = zkUrl;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDubboVersion() {
        return dubboVersion;
    }

    public void setDubboVersion(String dubboVersion) {
        this.dubboVersion = dubboVersion;
    }

    public String getDubboGroup() {
        return dubboGroup;
    }

    public void setDubboGroup(String dubboGroup) {
        this.dubboGroup = dubboGroup;
    }

    @Override
    public String toString() {
        return "DubboRequest{" +
                "dubboUrl='" + dubboUrl + '\'' +
                ", zkUrl='" + zkUrl + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", dubboVersion='" + dubboVersion + '\'' +
                ", dubboGroup='" + dubboGroup + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodParams=" + methodParams +
                '}';
    }
}
