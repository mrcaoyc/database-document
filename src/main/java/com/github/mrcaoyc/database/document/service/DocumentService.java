package com.github.mrcaoyc.database.document.service;

import java.io.OutputStream;

/**
 * @author caoyongcheng
 */
public interface DocumentService {

    /**
     * 生成数据库文档
     *
     * @param dataSourceConfigurationId 数据库配置Id
     * @param outputStream              文档输出流
     */
    void generateDatabaseDocumentWord(Long dataSourceConfigurationId, OutputStream outputStream);
}
