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


@SuppressWarnings("unused")
public class S3Object extends MainFrame {
	
	
	//private static final String SUFFIX = "/";
	//private static final String ClientConfiguration = null;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome!!!!!!!");
		
		/*String clientRegion = "ap-south-1";
        String bucketName = "anybuckets3654";
        String keyName = "AKIAJOHIXUIZLRH2HGIQ";.
        String filePath = "C:\\Users\\Dell\\Desktop\\testvideo.mp4";
        String fileName = "testvideo";
        
        File file = new File(filePath);
        long contentLength = file.length();
        long partSize = 5 * 1024 * 1024; // Set part size to 5 MB. 

       
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).withCredentials(new ProfileCredentialsProvider()).build();         
            // Create a list of ETag objects. You retrieve ETags for each object part uploaded,
            // then, after each individual part has been uploaded, pass the list of ETags to 
            // the request to complete the upload.
            List<PartETag> partETags = new ArrayList<PartETag>();

            // Initiate the multipart upload.
            InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, fileName);
            InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

            // Upload the file parts.
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                // Because the last part could be less than 5 MB, adjust the part size as needed.
                partSize = Math.min(partSize, (contentLength - filePosition));

                // Create the request to upload a part.
                UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(bucketName).withKey(keyName).withUploadId(initResponse.getUploadId()).withPartNumber(i).withFileOffset(filePosition).withFile(file).withPartSize(partSize);

                // Upload the part and add the response's ETag to our list.
                UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());

                filePosition += partSize;
            }
                
                CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName,keyName,initResponse.getUploadId(), partETags);
                s3Client.completeMultipartUpload(compRequest);
		
                System.out.println("Uploaded!!!");*/
		 
		MainFrame mainFrame = new MainFrame();
		Controller projectController = new Controller(mainFrame); 
		mainFrame.setVisible(true);
		mainFrame.setSize(300,200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*AWSCredentials credentials = new BasicAWSCredentials("","");
		
		
		AmazonS3 s3client = new AmazonS3Client(credentials);
		ExecutorService s3 = null;
		AmazonCognitoSyncAsyncClient user = new AmazonCognitoSyncAsyncClient(credentials); 
		AmazonCognitoSync user1;
		s3client.initiateMultipartUpload(null);
		
		
		String bucketName = "pracs3123";
		//s3client.createBucket(bucketName);
		
		for (Bucket bucket : s3client.listBuckets()) {
			System.out.println(" - " + bucket.getName());
		}
		List<Bucket> buckets = s3client.listBuckets();
	    System.out.println("Your Amazon S3 buckets are:");
	    for (Bucket b : buckets) {
	        System.out.println("* " + b.getName());
	    }
		
		String folderName = "folderpractice";
		createFolder(bucketName, folderName, s3client);
		
		String fileName = folderName + "/" + "images.png";
		s3client.putObject(new PutObjectRequest(bucketName,fileName,new File("C:\\Users\\Dell\\Desktop\\images.png")));
		
		
		//s3client.putObject(new PutObjectRequest());
		
		//s3client.initiateMultipartUpload(new InitiateMultipartUploadRequest(bucketName,any));
		//s3client.getObject(fileName, folderName);
		
		//s3client.deleteBucket(bucketName);
		
		//final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		
		//deleteFolder(bucketName, folderName, s3client);
		
		// deletes bucket
		//s3client.deleteBucket(bucketName);
		//s3client.putObject(bucketName, folderName,new File("C:\\Users\\Dell\\Desktop\\testvideo.mp4"));
	
		
	}
	
	
	/*public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,folderName + SUFFIX, emptyContent, metadata);
		
		client.putObject(putObjectRequest);
	}*/
	
	
	/*public static void deleteFolder(String bucketName,String folderName,AmazonS3 client) {
		
		List fileList = client.listObjects(bucketName,folderName).getObjectSummaries();
		
		for(S3ObjectSummary file1 : fileList) {
			
			client.deleteObject(bucketName, file1.getKey());
			
		}
		client.deleteObject(bucketName, folderName);
	}*/
	
	
	}
            
}


/*public class S3Object {

	public static void main(String[] args) throws IOException {
        String clientRegion = "ap-south-1";
        String bucketName = "pracs31";
        String keyName = "";
        String filePath = "C:\\Users\\Dell\\Desktop\\testvideo.mp4";  
        
        File file = new File(filePath);
        long contentLength = file.length();
        long partSize = 5 * 1024 * 1024; // Set part size to 5 MB. 
        //System.out.println(contentLength);
        //try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).withCredentials(new ProfileCredentialsProvider()).build();
                       
            // Create a list of ETag objects. You retrieve ETags for each object part uploaded,
            // then, after each individual part has been uploaded, pass the list of ETags to 
            // the request to complete the upload.
            
            List<PartETag> partETags = new ArrayList<PartETag>();

           
            InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, keyName);
            InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

            System.out.println("First Successfull");
            
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                
                partSize = Math.min(partSize, (contentLength - filePosition));
                System.out.println(partSize);
            
                UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(bucketName).withKey(keyName).withUploadId(initResponse.getUploadId()).withPartNumber(i).withFileOffset(filePosition).withFile(file).withPartSize(partSize);
                System.out.println("Second Successfull");
              
                UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());
                
                filePosition += partSize;
                System.out.println(filePosition + "kb" + "Uploaded");
            }

            
            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, keyName,initResponse.getUploadId(), partETags);
            s3Client.completeMultipartUpload(compRequest);
        
            
            System.out.println("Upload Successfull");
        /*catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
	}
}*/