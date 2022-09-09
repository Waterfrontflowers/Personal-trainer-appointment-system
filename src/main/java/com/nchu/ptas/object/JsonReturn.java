package com.nchu.ptas.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author Ginger
 * @date 2022-09-09
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonReturn {
    private int code;
    private String msg;
    private String data;

    @Override
    public String toString() {
        if(this.data != null && this.data.charAt(0) == '{') {
            return "{" +
                    "\"code\":" + code +
                    ", \"msg\":\"" + msg + '"' +
                    ", \"data\":" + data +
                    '}';
        }
        else {
            return "{" +
                    "\"code\":" + code +
                    ", \"msg\":\"" + msg + '"' +
                    '}';
        }
    }
}
