package com.ash.portraits.util;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;

@Service
public class ImageUploadService {

//	@Autowired
//	private AmazonS3 amazonS3;
//
//	@Value("${cloud.aws.s3.bucket}")
//	private String bucketName;
//
//	public String uploadImage(MultipartFile file) throws IOException {
//		String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//
//		// Upload file to S3
////		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), new ObjectMetadata())
////				.withCannedAcl(CannedAccessControlList.PublicRead) // Make the file public
////		);
//
//		// Generate and return the file URL
//		return amazonS3.getUrl(bucketName, fileName).toString();
//	}
}
