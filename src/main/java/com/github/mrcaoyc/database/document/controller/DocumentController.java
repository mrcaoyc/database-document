package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author caoyongcheng
 */
@RestController
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("documents")
    public void listTables(@RequestParam Long dataSourceConfigId, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.ms-word");
        response.setCharacterEncoding("utf-8");

        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系

        String fileName = URLEncoder.encode(System.currentTimeMillis() + "", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".docx");

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            documentService.generateDatabaseDocumentWord(dataSourceConfigId, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
