package com.jxufe.cgg.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.cgg.utils.RequestUtils;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-14 10:47:58
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class AccessToken {
//    private static String appid = "wxa68e3f7bef9236dd";
//    private static String appsecret = "de0ea8af899e4faed57eada8274b127c";

    private String accessToken;
    private long expreeTime;

    private long createTime;

//    private static AccessToken inst;

    public AccessToken() {
    }

//    public static AccessToken getInstance() {
//        if (!check()) createObject();
//        return inst;
//    }

//    private static boolean check() {
//        if (inst == null || System.currentTimeMillis() >= (inst.expreeTime + inst.createTime - 1000)) {
//            return false;
//        }
//        return true;
//    }
//
//    private static void createObject() {
//        inst = new AccessToken();
//        String rs = RequestUtils.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret);
//        JSONObject jsonObject = JSON.parseObject(rs);
//        inst.setCreateTime(System.currentTimeMillis());
//        inst.setExpreeTime(jsonObject.getLong("expires_in") * 1000);
//        inst.setAccessToken(jsonObject.getString("access_token"));
//    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpreeTime() {
        return expreeTime;
    }

    public void setExpreeTime(long expreeTime) {
        this.expreeTime = expreeTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expreeTime=" + expreeTime +
                ", createTime=" + createTime +
                '}';
    }
}
