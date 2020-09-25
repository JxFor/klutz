package com.jxfor.klutz.server.core;

/**
 * 注册中心服务节点
 *
 * @author jxfor
 * @date 2020/9/24 17:45
 */
public class ServerNode {

    private String ip;

    private int servePort;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getServePort() {
        return servePort;
    }

    public void setServePort(int servePort) {
        this.servePort = servePort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServerNode server = (ServerNode) o;
        return servePort == server.servePort && ip.equals(server.ip);
    }

    @Override
    public int hashCode() {
        int result = ip.hashCode();
        result = 31 * result + servePort;
        return result;
    }

    public String getKey() {
        return ip + ":" + servePort;
    }
}
