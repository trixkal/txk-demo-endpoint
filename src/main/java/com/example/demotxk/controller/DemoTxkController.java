package com.example.demotxk.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTxkController {


    SftpRemoteFileTemplate remoteFileTemplate;

    @GetMapping("/testHeroku/")
    public String testHeroku() {

        return "ResponseEntity.OK.Heroku";
    }

    @GetMapping("/downloadFTPFile")
    public ResponseEntity<Resource> downloadFTPFile() {
        String responseSftp = null;
        try {

            String contentType = "application/octet-stream";
            String fileName = "http://www.orimi.com/pdf-test.pdf";
            Resource resource = new UrlResource("http://www.orimi.com/pdf-test.pdf");

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("finish roc");
        return null;
    }
}
