package com.github.sysnote8main.bwlmlib.util;

import com.github.sysnote8main.bwlmlib.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLog {
    private static final Logger MainLogger = LogManager.getLogger(Tags.modname);
    public static void info(String str) {
        MainLogger.info(str);
    }
    public static void warn(String str) {
        MainLogger.warn(str);
    }
    public static void error(String str) {
        MainLogger.error(str);
    }
}
