package com.nchu.ptas.controller.websocket;



import org.yeauty.pojo.Session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Ginger
 * @date 2022-05-15
 */
public class WebSockets {
    public static final ConcurrentMap<String, Session> MAP = new ConcurrentHashMap<>();
}
