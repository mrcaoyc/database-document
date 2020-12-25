package com.github.mrcaoyc.database.document.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DatabaseUtilsTest {

    @Test
    public void when_getDatabaseNameFromUrl_given_url_databaseName_after_nothing() {
        String url = "jdbc:mysql://192.168.103.31:3307/book";
        String database = DatabaseUtils.getDatabaseNameFromUrl(url);
        Assertions.assertEquals(database, "book");
    }

    @Test
    public void when_getDatabaseNameFromUrl_given_url_databaseName_after_have_parameters() {
        String url = "jdbc:mysql://192.168.103.31:3307/book?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        String database = DatabaseUtils.getDatabaseNameFromUrl(url);
        Assertions.assertEquals(database, "book");
    }

    @Test
    public void when_getDatabaseNameFromUrl_given_url_databaseName_after_have_port() {
        String url = "jdbc:mysql://192.168.103.31:3307/book:3306?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        String database = DatabaseUtils.getDatabaseNameFromUrl(url);
        Assertions.assertEquals(database, "book");
    }
}