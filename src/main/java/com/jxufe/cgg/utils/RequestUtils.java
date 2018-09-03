package com.jxufe.cgg.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-14 09:35:15
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class RequestUtils {
    private static HttpEntity entity;
    private static HttpClient httpClient;
    private static HttpPost post;
    private static HttpGet get;
    private static HttpResponse response;

    public static String get(String url) {
        httpClient = HttpClients.createDefault();
        get = new HttpGet(url);
        return returnString(get);
    }

    public static String post(String url, String jsonSt) {
        httpClient = HttpClients.createDefault();
        post = new HttpPost(url);
        post.setHeader("Content-type", "chaset=utf-8;application/json");
        post.setEntity(new StringEntity(jsonSt, "utf-8"));
        return returnString(post);
    }

    private static String returnString(HttpRequestBase base) {
        try {
            long start = System.currentTimeMillis();
            response = httpClient.execute(base);
            long end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start) + "ms");
            entity = response.getEntity();
            return EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            base.releaseConnection();
        }
    }
}
