package com.jxufe.cgg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.cgg.bean.AccessToken;
import com.jxufe.cgg.service.WxBaseService;
import com.jxufe.cgg.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-08-14 11:08:19
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */

@Controller
@RequestMapping(value = "accesstoken")
public class AccessTokenController {
    @Autowired
    private WxBaseService wxBaseService;
    private AccessToken accessToken;//控制器单例


    @RequestMapping(value = "get")
    @ResponseBody
    public Object getAccessToken() {
        if (accessToken == null) accessToken = new AccessToken();
        wxBaseService.getAccessToken(accessToken);
        return accessToken;
    }
}
