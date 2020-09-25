package com.jxfor.klutz.server.core;

import com.jxfor.klutz.common.Instance;
import com.jxfor.klutz.common.exception.KlutzException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务 管理
 *
 * @author jxfor
 */
@Component
public class ServerManager {

    private Map<String,KlutzServer> services = new ConcurrentHashMap<>();

    private final Object putServiceLock = new Object();

    public void registerInstance(String serverName, String ip, Integer port) {

        if( StringUtils.isEmpty(serverName) || StringUtils.isEmpty(ip) || null == port ){
            throw new KlutzException("param is null");
        }

        if( !services.containsKey(serverName)){
            synchronized (putServiceLock){
                if( !services.containsKey(serverName)){
                    KlutzServer server = services.get(serverName);
                    services.put(serverName,server);
                }
            }
        }

        KlutzServer server = services.get(serverName);
        server.setLastModifyTime(System.currentTimeMillis());

        Instance instance = new Instance();
        instance.setIp(ip);
        instance.setPort(port);

        server.addOrUpdateInstance(instance.getDefaultKey(),instance);
    }


}
