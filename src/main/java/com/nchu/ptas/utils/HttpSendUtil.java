package com.nchu.ptas.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author Ginger
 * @date 2022-08-31
 */

public class HttpSendUtil {
    private HttpSendUtil() {
    }

    private static class HttpSendUtilInstance {
        private static final HttpSendUtil INSTANCE = new HttpSendUtil();
    }

    public static HttpSendUtil instance() {
        return HttpSendUtilInstance.INSTANCE;
    }


    public String sendPost(String sendUrl, String params, String encodType) {
        StringBuffer receive = new StringBuffer();

        HttpURLConnection URLConn = null;
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            URL url = new URL(sendUrl);
            URLConn = (HttpURLConnection) url.openConnection();
            URLConn.setRequestMethod("POST");
            URLConn.setDoOutput(true);
            URLConn.setDoInput(true);
            URLConn.setUseCaches(false);
            URLConn.setAllowUserInteraction(true);
            HttpURLConnection.setFollowRedirects(true);
            URLConn.setInstanceFollowRedirects(true);

            URLConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            URLConn.setRequestProperty("Content-Length", String.valueOf(params.getBytes().length));

            DataOutputStream dos = new DataOutputStream(URLConn.getOutputStream());
            dos.writeBytes(params);

            br = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), encodType));

            String line;
            while ((line = br.readLine()) != null) {
                receive.append(line).append("\r\n");
            }

            br.close();

        } catch (IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    bw = null;
                    ex.printStackTrace();
                } finally {
                    if (URLConn != null) {
                        URLConn.disconnect();
                        URLConn = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (URLConn != null) {
                        URLConn.disconnect();
                        URLConn = null;
                    }
                }
            }
        }

        return receive.toString();
    }

    public String sendGet(String sendUrl, String encodType) {
        StringBuffer receive = new StringBuffer();
        BufferedReader br = null;
        HttpURLConnection URLConn = null;
        try {
            URL url = new URL(sendUrl);
            URLConn = (HttpURLConnection) url.openConnection();

            URLConn.setDoInput(true);
            URLConn.setDoOutput(true);
            URLConn.connect();
            URLConn.getOutputStream().flush();
            br = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), encodType));

            String line;
            while ((line = br.readLine()) != null) {
                receive.append(line).append("\r\n");
            }

        } catch (IOException e) {
            receive.append("访问产生了异常-->").append(e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    br = null;
                    ex.printStackTrace();
                } finally {
                    if (URLConn != null) {
                        URLConn.disconnect();
                        URLConn = null;
                    }
                }
            }
        }

        return receive.toString();
    }
}
