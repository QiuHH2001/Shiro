package com.qhh.springbootshiro.utils;

import java.util.Random;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  17:21
 * @Description: TODO
 */
public class SaltUtils {
    /**
     * 生成salt
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
