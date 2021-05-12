/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emweb2021.websocketproject2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author enio1
 */
@Named(value = "helloBean")
@ApplicationScoped
public class HelloBean {

    private static final Logger LOG = Logger.getLogger(HelloBean.class.getName());
    
    @Inject
    @Push
    PushContext helloChannel;
    
    String message;
    
    public void sendMessage() {
        LOG.log(Level.INFO, "send push message");
        this.sendPushMessage("hello");
    }
    
    private void sendPushMessage(Object message) {
        LOG.log(Level.INFO, helloChannel.toString() );
        helloChannel.send("" + message + " at " + LocalDateTime.now());
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void sendMessage2() {
       // log.log(Level.INFO, "send push message from input box::" + this.message);
        this.sendPushMessage(this.message);
    }
    
}
