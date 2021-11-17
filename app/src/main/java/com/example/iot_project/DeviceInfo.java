package com.example.iot_project;

public class DeviceInfo {
    String username;
    String deviceName;
    String ipAddress;
    String area;
    String status;

    public DeviceInfo(String username, String deviceName, String ipAddress, String area, String status) {
        this.username = username;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
        this.area = area;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
