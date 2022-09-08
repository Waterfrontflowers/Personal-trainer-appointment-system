package com.nchu.ptas.utils;

import java.util.Random;

/**
 * @author Ginger
 * @date 2022-09-02
 */
public class CardNumber {
    public static String get(){
        int count=0;
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<12;i++){
            int number=random.nextInt(62);
            count += i*number*10000;
            sb.append(str.charAt(number));
        }

        StringBuilder check= new StringBuilder();
        for(int i = 0;i<4;i++){
            check.append(str.charAt(count % 62));
            count /=62;
        }
        String cardNumber =sb.toString();
        sb =new StringBuilder();
        for(int i = 0 ; i < 4;i++){
            sb.append(cardNumber, i*3, (i+1)*3);
            sb.append(check.charAt(i));
        }
        return sb.toString();
    }

    public static boolean check(String cardNumber){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int count=0;
        StringBuilder checkReceive = new StringBuilder();
        for(int i=0;i<16;i++){
            if(i % 4 != 3){
                int number = str.lastIndexOf(cardNumber.charAt(i));
                count += (i-i/4)*number*10000;
            }
            else{
                checkReceive.append(cardNumber.charAt(i));
            }
        }
        StringBuilder check = new StringBuilder();
        for(int i = 0;i < 4;i++){
            check.append(str.charAt(count % 62));
            count /=62;
        }
        return checkReceive.toString().equals(check.toString());
    }
}
