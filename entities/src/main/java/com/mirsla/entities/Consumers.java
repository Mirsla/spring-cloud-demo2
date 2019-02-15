package com.mirsla.entities;

import java.io.Serializable;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  10:49 2019/1/21
 * @modified By:
 */
public class Consumers implements Serializable {
    private Integer consumerId;

    private String nick;

    private String cellPhoneNo;

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCellPhoneNo() {
        return cellPhoneNo;
    }

    public void setCellPhoneNo(String cellPhoneNo) {
        this.cellPhoneNo = cellPhoneNo;
    }

    public Consumers(Integer consumerId, String nick, String cellPhoneNo) {
        this.consumerId = consumerId;
        this.nick = nick;
        this.cellPhoneNo = cellPhoneNo;
    }

    public Consumers() {
    }
}
