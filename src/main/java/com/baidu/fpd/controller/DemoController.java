package com.baidu.fpd.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by zhaoxianghui on 2017/8/24.
 */
@Controller
@RequestMapping("demo")
public class DemoController {

    //返回成功信息
    public String success(String info) throws Exception {
        JSONObject result = new JSONObject();
        result.put("status", 1);
        if (info == null) {
            result.put("info", "");
        } else {
            result.put("info", info);
        }
        result.put("result", "");
        return result.toString();
    }

    //返回失败信息
    public String failure(String info) throws Exception {
        JSONObject result = new JSONObject();
        result.put("status", 0);
        if (info == null) {
            result.put("info", "");
        } else {
            result.put("info", info);
        }
        result.put("result", "");
        return result.toString();
    }

    //返回供前端使用的result-成功
    public String resultSuccess(String info, String resultStr) throws Exception {
        JSONObject result = new JSONObject();
        result.put("status", 1);
        if (info == null) {
            result.put("info", "");
        } else {
            result.put("info", info);
        }
        if (resultStr == null) {
            result.put("result", "");
        } else {
            result.put("result", resultStr);
        }
        return result.toString();
    }

    //返回供前端使用的result-失败
    public String resultFailure(String info, String resultStr) throws Exception {
        JSONObject result = new JSONObject();
        result.put("status", 0);
        if (info == null) {
            result.put("info", "");
        } else {
            result.put("info", info);
        }
        if (resultStr == null) {
            result.put("result", "");
        } else {
            result.put("result", resultStr);
        }
        return result.toString();
    }
}
