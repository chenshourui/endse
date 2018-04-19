package com.endse.common.controller;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by chensr on 2018/4/18.
 */
public abstract class BasicContorller {
    /**
     * 日志
     */
    protected static Logger log = Logger.getLogger("LogFile");

    /**
     * 获取请求中的查询参数（如果是数组转换成为List）
     */
    protected Map<String, Object> getParameterMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] value = parameterMap.get(key);
            if (value == null || value.length == 0) {
                continue;
            }
            key = key.replace("[]", "");
            if (value.length > 1) {
                List<String> list = new ArrayList<String>();
                Collections.addAll(list, value);
                map.put(key, list);
            } else {

                if (!StringUtils.isEmpty(value[0])) {
                    try {
                        // 对于采用URL传递的参数进行解码，避免出现问题
                        map.put(key, URLDecoder.decode(value[0], "utf-8"));
                    } catch (UnsupportedEncodingException e) {

                    }
                }
            }
        }
        return map;
    }

}
