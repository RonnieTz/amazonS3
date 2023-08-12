package org.digimad.springbootamazons3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class S3Service {
    @Autowired
    private S3Client s3Client;

    public void readCsvFromS3(String bucketName, String fileKey) throws IOException {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(fileKey).build();
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(getObjectRequest);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));
        String line;
        while ((line = reader.readLine()) != null) {
            //process the csv line
            System.out.println(line);
        }
        reader.close();
        response.close();
    }
}
