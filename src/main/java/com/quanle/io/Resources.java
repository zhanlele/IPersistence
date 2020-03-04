package com.quanle.io;

import java.io.InputStream;

/**
 * @author quanle
 * @date 2020/3/2 10:28 PM
 */
public class Resources {

    /**
     * 将配置文件加载成字节输入流，放入程序内存中
     * @param path 配置文件路径
     * @return 字节输入流
     */
    public static InputStream getResourceAsStream(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
