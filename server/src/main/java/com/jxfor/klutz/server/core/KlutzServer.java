package com.jxfor.klutz.server.core;


import com.jxfor.klutz.common.Instance;
import com.jxfor.klutz.common.Server;

import java.util.Map;

public class KlutzServer extends Server {

    private final Object instanceLock = new Object();

    public KlutzServer( String serverName) {
        super(serverName);
    }


    public void addOrUpdateInstance(String key,Instance instance) {

        synchronized (instanceLock){
            Map<String, Instance> instances = this.getInstances();
            if( instances.containsKey(key)){
                //需要更新
                instance.setLastBeat(System.currentTimeMillis());
            }else {
                instances.put(key, instance);
            }
        }
    }
}
