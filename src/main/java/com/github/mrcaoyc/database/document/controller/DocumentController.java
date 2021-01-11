package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author caoyongcheng
 */
@Api(tags = "数据库文档")
@RestController
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @ApiOperation(value = "生成并下载数据库文档")
    @ApiImplicitParam(name = "dataSourceConfigId", value = "数据库配置Id")
    @GetMapping("/documents")
    public void listTables(@RequestParam Long dataSourceConfigId, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.ms-word");
        response.setCharacterEncoding("utf-8");

        // 这里URLEncoder.encode可以防止中文乱码 当然和easy excel没有关系
        String fileName = URLEncoder.encode(System.currentTimeMillis() + "", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".docx");

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            documentService.generateDatabaseDocumentWord(dataSourceConfigId, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
