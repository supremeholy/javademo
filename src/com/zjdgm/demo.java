package com.zjdgm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //String str_source = "{\"body\":{\"sfz\":\"330322197911110810\"},\"method\":\"gr_gjjzl_yh\"}";
        String str_source = "{\"body\":{\"sfz\":\"330322197911110810\"},\"method\":\"gr_mxz_yh\"}";
        //String str_source = "{\"body\":{\"sfz\":\"330322197911110810\",\"hth\":\"012012000144\"},\"method\":\"gr_htxx_yh\"}";
        //String str_source = "{\"body\":{\"sfz\":\"330322197911110810\",\"hth\":\"012012000144\"},\"method\":\"gr_hkmx_yh\"}";
        String app_id = "0201";
        String app_key = "0201key";
        encrypt(str_source, app_id, app_key);

        System.out.println("========================");

        String str = "fcwkG97IeOrRgUS0ik2KYQ==";
        String sign = "3365F9753F4A9DAD89086062BA339C36";
        String ts = "D3213B979FB5956C3B6925FC6336BACD";
        decrypt(str, ts , sign);
    }

    /*
     * 加密
     * */
    public static String encrypt(String strJSON, String app_id, String app_key) {

        SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
        String ts = sFormat.format(new Date()); //"20170901144312000773"; //
        System.out.println("ts:"+ts);
        String ts_enc = MD5.getMD532(app_key + ts);
        System.out.println(app_key + ts);
        System.out.println("ts_enc:"+ts_enc);
        String str_DESKey = ts_enc.substring(0,8);
        String str_MD5Key = ts_enc.substring(16);
        System.out.println("deskey:"+str_DESKey);
        System.out.println("md5key:"+str_MD5Key);
        String sign_enc = MD5.getMD532(strJSON + app_key + str_MD5Key);
        System.out.println("sign_enc:"+sign_enc);
        String str_response = DES.getEncString(strJSON, str_DESKey);
		/*System.out.println("str_response:"+str_response);
		System.out.println("ts:"+ts_enc);
		System.out.println("sign:"+sign_enc);*/
        return str_response;
    }

    public static String decrypt(String str, String ts, String sign)
    {
        System.out.println("要解密的字符串:"+ str);
        System.out.println("ts:"+ts);
        System.out.println("sign:"+sign);
        String str_DESKey = ts.substring(0, 8);
        String str_MD5Key = ts.substring(16);
        System.out.println("解密使用的deskey:"+str_DESKey);
        String str_request = DES.getDesString(str, str_DESKey);

        System.out.println("解密后:"+str_request);
        return "";
    }
}