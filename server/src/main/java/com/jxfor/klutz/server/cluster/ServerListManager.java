package com.jxfor.klutz.server.cluster;

import com.jxfor.klutz.server.config.RunningConfig;
import com.jxfor.klutz.server.core.ServerNode;
import com.jxfor.klutz.server.net.InetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jxfor
 * @date 2020/9/24 17:43
 */
@Component
public class ServerListManager {

    private List<ServerNode> servers = new ArrayList<>();

    @Value("${klutz.serverList:}")
    private String serverList;

    @PostConstruct
    public void init() {
        if( StringUtils.isEmpty(serverList) ){
            //localhost
            ServerNode serverNode = new ServerNode();
            serverNode.setIp(InetUtils.getSelfIp());
            serverNode.setServePort(RunningConfig.getServerPort());
            servers.add(serverNode);
            return;
        }

        Stream.of(serverList.split(","))
                .forEach( str -> {
                    String[] arr = str.split(":");
                    if( arr.length!=2){
                        return;
                    }
                    ServerNode serverNode = new ServerNode();
                    serverNode.setIp(arr[0]);
                    serverNode.setServePort(Integer.valueOf(arr[1]));
                    servers.add(serverNode);
                });
    }

}
