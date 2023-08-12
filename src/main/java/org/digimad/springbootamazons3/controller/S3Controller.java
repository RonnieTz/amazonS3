package org.digimad.springbootamazons3.controller;

import org.digimad.springbootamazons3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @GetMapping("/read")
    public void readFromAmazonS3() throws IOException {
        s3Service.readCsvFromS3("s3-digimad-prod","test.csv");
    }
}
