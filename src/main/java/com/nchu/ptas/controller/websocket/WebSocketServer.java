package com.nchu.ptas.controller.websocket;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.nchu.ptas.utils.CardNumber;
import io.netty.handler.codec.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author Ginger
 * @date 2022-05-15
 */
@ServerEndpoint(port=25555)
@Component
@RestController
public class WebSocketServer {


    @OnOpen
    public void onOpen(Session session, HttpHeaders headers) throws IOException {
        System.out.println("new connection");
        String key = CardNumber.get();
        WebSockets.MAP.put(key,session);
        key = "{\"code\":0,\"key\":\""+key+"\"}";
        session.sendText(key);
        System.out.println(WebSockets.MAP);



        /*String token = cookie.substring(cookie.indexOf("=")+1,cookie.indexOf(";"));
        Long id = Long.parseLong(token);
        WebSockets.MAP.put(id,session);
        System.out.println(WebSockets.MAP);*/

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("one connection closed");
        Iterator<Session> it = WebSockets.MAP.values().iterator();
        while(it.hasNext()){
            if(it.next() == session){
                it.remove();
            }
        }
        System.out.println(WebSockets.MAP);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void OnMessage(Session session, String message) {
        System.out.println(message);

        ObjectMapper objectMapper = new ObjectMapper();

        /*User user = null;
        try {
            user = objectMapper.readValue(message, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(user);*/
        session.sendText(message);

        //WebSockets.MAP.get(user.getId()).sendText(user.getMsg());
        //session.sendText("Hello Netty!");
    }
}