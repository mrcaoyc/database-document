package com.github.mrcaoyc.database.document.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author caoyongcheng
 */
public class DatabaseUtils {

    public static String getDatabaseNameFromUrl(String url) {

        if (url == null) {
            return null;
        }
        int startIndex = StringUtils.ordinalIndexOf(url, "/", 3);
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.delete(0, startIndex + 1);


        int questionIndex = StringUtils.indexOf(stringBuilder, "?");
        if (questionIndex != -1) {
            stringBuilder.delete(questionIndex, stringBuilder.length());
        }

        int colonIndex = StringUtils.indexOf(stringBuilder, ":");
        if (colonIndex != -1) {
            stringBuilder.delete(colonIndex, stringBuilder.length());
        }
        return stringBuilder.toString();
    }
}
