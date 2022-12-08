package com.qhh;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  10:10
 * @Description: TODO
 */
public class TestShiroMD5 {
    public static void main(String[] args) {
//        Md5Hash md5Hash = new Md5Hash();
//        md5Hash.setBytes("123".getBytes());
//        String s = md5Hash.toHex();

        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        Md5Hash md5Hash1 = new Md5Hash("123", "0x");
        System.out.println(md5Hash1.toHex());

    }
}
