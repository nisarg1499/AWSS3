import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

import com.amazonaws.services.codedeploy.AmazonCodeDeploy;
import com.amazonaws.services.cognitosync.*;
import com.amazonaws.services.config.AmazonConfig;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;


@SuppressWarnings({ "unused", "serial" })
public class S3Object extends MainFrame {
	
	
	//private static final String SUFFIX = "/";
	//private static final String ClientConfiguration = null;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome!!!!!!!");
		
		 
		MainFrame mainFrame = new MainFrame();
		Controller projectController = new Controller(mainFrame); 
		mainFrame.setVisible(true);
		mainFrame.setSize(300,200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.println("Haard Here");
	
	
	}
            
}

