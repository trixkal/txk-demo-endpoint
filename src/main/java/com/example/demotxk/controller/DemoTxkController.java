package com.example.demotxk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

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
            String fileName = "herokuFileTest.pdf";
            String sftpRemoteDirectory = "/";
            Path filePath = Paths.get(sftpRemoteDirectory + fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            //System.out.println(remoteFileTemplate.get("ftp://rocmer@localhost/ConfigCloudLocal.txt", null));


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
