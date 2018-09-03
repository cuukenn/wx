package com.jxufe.cgg;

import com.jxufe.cgg.utils.RequestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-14 09:04:27
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class TestMain {

    @Test
    public void testGet() {
        String appid = "wxa68e3f7bef9236dd";
        String appsecret = "de0ea8af899e4faed57eada8274b127c";
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret);
        HttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String access_token = "12_WtSNR30Fef0ppaIdH4_a35NU_-wgzo4TdMrf79Qb4IKbiW6jJJiLQRZQF8nYR1xNfMraZADe8Gr_MxY-oyLuBViqvc9dfPYFOduJ2DXuLJ6LL86Lu3PJ8dOx4_VNCG634DTgVpnIRiIZ3LuFJUKaAFAOZP";
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + access_token);
        httpPost.setHeader("Content-type", "chaset=utf-8;application/json");
        httpPost.setEntity(new StringEntity("{\"touser\":\"oLYkK6MO3iI22cYraeePENHebLTE\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}", "utf-8"));
        HttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTools() {
        String access_token = "12_WtSNR30Fef0ppaIdH4_a35NU_-wgzo4TdMrf79Qb4IKbiW6jJJiLQRZQF8nYR1xNfMraZADe8Gr_MxY-oyLuBViqvc9dfPYFOduJ2DXuLJ6LL86Lu3PJ8dOx4_VNCG634DTgVpnIRiIZ3LuFJUKaAFAOZP";
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + access_token;
        String jsonstr = "{\"touser\":\"oLYkK6MO3iI22cYraeePENHebLTE\",\"msgtype\":\"text\",\"text\":{\"content\":\"Hello World\"}}";
        System.out.println(RequestUtils.post(url, jsonstr));
    }

    @Test
    public void testTools2() {
        String appid = "wxa68e3f7bef9236dd";
        String appsecret = "de0ea8af899e4faed57eada8274b127c";
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
        System.out.println(RequestUtils.get(url));

    }
}
