
package com.jxfor.klutz.server.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component("runningConfig")
public class RunningConfig implements ApplicationListener<WebServerInitializedEvent> {

    private static int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort();
    }

    public static int getServerPort() {
        return serverPort;
    }


}
