package com.szhengzhu.util;

import cn.hutool.crypto.digest.DigestUtil;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.util.MapUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class WechatSign {

    private static String characterEncoding = "UTF-8";

    /**
     * 
     * @date 2019年5月10日 下午4:47:44
     * @param parameters
     * @param key
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(Map<String, String> parameters, String key) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        System.out.println(sb.toString());
        String sign = DigestUtil.md5Hex(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    @SuppressWarnings("rawtypes")
    public static String createSign(Unifiedorder unifiedorder, String key) {
        StringBuffer sb = new StringBuffer();
        Map<String, String> parameters = MapUtil.objectToMap(unifiedorder, "detail");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        System.out.println(sb.toString());
        String sign = DigestUtil.md5Hex(sb.toString(), characterEncoding)
                .toUpperCase();
        return sign;
    }

    public static String getNonceStr() {
        Random random = new Random();
        return DigestUtil.md5Hex(String.valueOf(random.nextInt(10000)),
                characterEncoding);
    }

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
