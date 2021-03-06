package com.frame.wyx.util;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 34919 on 2017/7/8.
 */
public final class PropsUtil {
    private static final Logger LOGGER = Logger.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /*
    * 获取数值类型属性（默认为0）
    * */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /*
    * 获取数值类型属性（可指定默认值）
    * */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /*
    * 获取布尔型属性（默认值为false）
    * */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /*
    * 获取布尔型属性（可指定默认值）
    * */
    public static boolean getBoolean(Properties props, String key, Boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
