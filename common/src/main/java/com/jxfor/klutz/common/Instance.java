package com.jxfor.klutz.common;

import java.util.Objects;

public class Instance {

    private String ip;

    private int port;

    private volatile long lastBeat = System.currentTimeMillis();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getLastBeat() {
        return lastBeat;
    }

    public void setLastBeat(long lastBeat) {
        this.lastBeat = lastBeat;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Instance instance = (Instance) object;
        return port == instance.port &&
                Objects.equals(ip, instance.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    public String getDefaultKey() {
        return getIp() + ":" + getPort();
    }
}
