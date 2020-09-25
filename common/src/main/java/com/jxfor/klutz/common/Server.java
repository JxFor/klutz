package com.jxfor.klutz.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jxfor
 */
public class Server {

    private String serverName;

    protected Map<String,Instance> instances = new ConcurrentHashMap<>();

    private Long lastModifyTime ;

    public Server() {
    }

    public Server(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Map<String, Instance> getInstances() {
        return instances;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
