package com.nchu.ptas.controller;


import com.nchu.ptas.controller.websocket.WebSockets;
import com.nchu.ptas.service.CardService;
import com.nchu.ptas.utils.CardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ginger
 * @date 2022-09-02
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping("/id")
    public Integer card(Integer id) {
        return 0;
    }

    @GetMapping("/pay")
    public String pay(HttpServletRequest request) {
        String key = request.getParameter("key");
        Integer price = Integer.parseInt(request.getParameter("price"));
        String cardNumber = CardNumber.get();
        WebSockets.MAP.get(key).sendText("{\"code\":1,\"key\":\""+cardNumber+"\"}");
        return "卡号："+cardNumber + "面值："+ price;
    }

}
