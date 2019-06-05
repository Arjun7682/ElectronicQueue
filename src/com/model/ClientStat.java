package com.model;

import java.sql.Timestamp;

public class ClientStat {
    private final String phone;
    private final String ticket;
    private final Timestamp standTime;
    private final Timestamp startTime;
    private final Timestamp finishTime;
    private final String serviceMan;
    private final String service;

    public ClientStat(String phone, String ticket, Timestamp standTime, Timestamp startTime, Timestamp finishTime, String serviceMan, String service) {
        this.phone = phone;
        this.ticket = ticket;
        this.standTime = standTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.serviceMan = serviceMan;
        this.service = service;
    }

    public String getPhone() {
        return phone;
    }

    public String getTicket() {
        return ticket;
    }

    public Timestamp getStandTime() {
        return standTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public String getServiceMan() {
        return serviceMan;
    }

    public String getService() {
        return service;
    }
}
