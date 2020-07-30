
package com.blog.util;


import java.io.PrintStream;

import org.apache.shiro.crypto.hash.Md5Hash;


public class CryptographyUtil {

    public static String md5(String str, String salt) {

        return new Md5Hash(str, salt).toString();

    }


    public static void main(String[] args) {

        String password = "976700";
        System.out.println("Md5加密：" + md5(password, "java123"));

    }

}



