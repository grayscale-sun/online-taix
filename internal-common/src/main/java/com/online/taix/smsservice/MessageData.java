package com.online.taix.smsservice;

import java.io.Serializable;
import java.util.HashMap;

public class MessageData implements Serializable {

    private Integer templateid;

    public MessageData() {
    }

    private HashMap<String,Object> templatemap;

    public MessageData(Integer templateid, HashMap<String, Object> templatemap) {
        this.templateid = templateid;
        this.templatemap = templatemap;
    }

    public MessageData(Integer templateid) {
        this.templateid = templateid;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "templateid=" + templateid +
                ", templatemap=" + templatemap +
                '}';
    }

    public MessageData(HashMap<String, Object> templatemap) {
        this.templatemap = templatemap;
    }

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public HashMap<String, Object> getTemplatemap() {
        return templatemap;
    }

    public void setTemplatemap(HashMap<String, Object> templatemap) {
        this.templatemap = templatemap;
    }
}
