package com.online.taix.smsservice;

import java.io.Serializable;
import java.util.ArrayList;

public class AliNote implements Serializable {

    private ArrayList receivers;
    private MessageData messageData;

    public ArrayList getReceivers() {
        return receivers;
    }

    public void setReceivers(ArrayList receivers) {
        this.receivers = receivers;
    }

    public MessageData getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    @Override
    public String toString() {
        return "AliNote{" +
                "receivers=" + receivers +
                ", messageData=" + messageData +
                '}';
    }
}
