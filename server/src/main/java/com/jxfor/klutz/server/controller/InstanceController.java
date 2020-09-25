package com.jxfor.klutz.server.controller;

import com.jxfor.klutz.server.core.ServerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/instances")
public class InstanceController {

    @Autowired
    private ServerManager serverManager;

    @PostMapping(value = "/register")
    public String register( @RequestParam String serverName,
                            @RequestParam String ip,
                            @RequestParam Integer port){

        serverManager.registerInstance(serverName,ip,port);

        return "ok";
    }

    @PostMapping(value = "/list")
    public String list( @RequestParam(required = false) String serverName){


        return "ok";
    }


}
