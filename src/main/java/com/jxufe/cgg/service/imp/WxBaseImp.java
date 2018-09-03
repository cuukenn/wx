package com.jxufe.cgg.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.cgg.bean.AccessToken;
import com.jxufe.cgg.service.WxBaseService;
import com.jxufe.cgg.utils.RequestUtils;
import org.springframework.stereotype.Service;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-15 09:15:54
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
@Service
public class WxBaseImp implements WxBaseService {
    private static String appid = "wxa68e3f7bef9236dd";
    private static String appsecret = "de0ea8af899e4faed57eada8274b127c";

    @Override
    public void getAccessToken(AccessToken accessToken) {
        //是否过期
        if (System.currentTimeMillis() >= (accessToken.getExpreeTime() + accessToken.getCreateTime() - 1000)) {
            String rs = RequestUtils.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret);
            JSONObject jsonObject = JSON.parseObject(rs);
            if (jsonObject.containsKey("access_token")) {
                accessToken.setCreateTime(System.currentTimeMillis());
                accessToken.setExpreeTime(jsonObject.getLong("expires_in") * 1000);
                accessToken.setAccessToken(jsonObject.getString("access_token"));
            }
        }
    }
}
