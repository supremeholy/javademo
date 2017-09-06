package com.zjdgm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String getMD532(String str)
    {
        byte bytes[] = getMD5Bytes(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++)
        {
            sb.append(String.format("%02X", bytes[i]));
        }


        return sb.toString();
    }

    /**
     * MD5 加密
     */
    public static byte[] getMD5Bytes(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        return byteArray;
    }

    //字符编码 UTF-16LE
    public static String getMD532UTF16LE(String str)
    {
        byte bytes[] = getMD5BytesUTF16LE(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++)
        {
            sb.append(String.format("%02x", bytes[i]));
        }


        return sb.toString();
    }

    /**
     * MD5 加密
     */
    public static byte[] getMD5BytesUTF16LE(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-16LE"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        return byteArray;
    }
}