import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.cognitosync.AmazonCognitoSync;
import com.amazonaws.services.cognitosync.AmazonCognitoSyncAsyncClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("unused")
public class Controller {

	private static final String SUFFIX = "/";
	private static MainFrame view;
	
	public Controller(MainFrame v){
		view = v;
		//System.out.println("Welcome!!!");
		view.getBtnUpload().addActionListener(new BucketControllerAdd());
		view.getBtnList().addActionListener(new DisplayBucket());
		view.getBtnTimer().addActionListener(new BucketTimerAdd());
		view.getBtnDelete().addActionListener(new BucketControllerDelete());
		view.setVisible(true);

	}
	
	
	class BucketTimerAdd implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			
			String timer = view.getTimer();
			int finalTimer = Integer.parseInt(timer);
			System.out.println("Clicked!!!");
			new Reminder(finalTimer);
	        System.out.println("Task scheduled.");
				
		}
	}
	
	class BucketControllerAdd implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	        
			System.out.println("Clicked");
			String bucketName = view.getBucketName();
			String folderName = view.getFolderName();
			String keyId = view.getKeyId();
			String secretId = view.getSecretId();
			
			System.out.println(keyId);
			System.out.println("    ");
			System.out.println(secretId);
			AWSCredentials credentials = new BasicAWSCredentials(keyId,secretId);
			@SuppressWarnings("deprecation")
			AmazonS3 s3client = new AmazonS3Client(credentials);
			/*ExecutorService s3 = null;
			AmazonCognitoSyncAsyncClient user = new AmazonCognitoSyncAsyncClient(credentials); 
			AmazonCognitoSync user1;
			s3client.initiateMultipartUpload(null);*/
			
			
			s3client.createBucket(bucketName);
			
			for (Bucket bucket : s3client.listBuckets()) {
				System.out.println(" - " + bucket.getName());
			}
			@SuppressWarnings("unused")
			List<Bucket> buckets = s3client.listBuckets();
		    /*System.out.println("Your Amazon S3 buckets are:");
		    for (Bucket b : buckets) {
		        System.out.println("* " + b.getName());
		    }*/
			
			createFolder(bucketName, folderName, s3client);
			
			String fileName = folderName + "/" + "images.png";
			s3client.putObject(new PutObjectRequest(bucketName,fileName,new File("C:\\Users\\Dell\\Desktop\\practice.pdf")));
			System.out.println("Uploaded!!");
			
			
			/*String clientRegion = "ap-south-1";
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

	            // Initiate the multipart upload.
	            InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, keyName);
	            InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

	            System.out.println("First Successfull");
	            // Upload the file parts.
	            long filePosition = 0;
	            for (int i = 1; filePosition < contentLength; i++) {
	                // Because the last part could be less than 5 MB, adjust the part size as needed.
	                partSize = Math.min(partSize, (contentLength - filePosition));
	                System.out.println(partSize);
	                // Create the request to upload a part.
	                UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(bucketName).withKey(keyName).withUploadId(initResponse.getUploadId()).withPartNumber(i).withFileOffset(filePosition).withFile(file).withPartSize(partSize);
	                System.out.println("Second Successfull");
	                // Upload the part and add the response's ETag to our list.
	                UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
	                partETags.add(uploadResult.getPartETag());
	                System.out.println("Hi");
	                filePosition += partSize;
	                System.out.println(filePosition + "kb" + "Uploaded");
	            }

	            // Complete the multipart upload.
	            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, keyName,initResponse.getUploadId(), partETags);
	            s3Client.completeMultipartUpload(compRequest);
	        
	            
	            System.out.println("Upload Successfull");*/
			
		}
		
	}
	
	class DisplayBucket implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			String keyId = view.getKeyId();
			String secretId = view.getSecretId();
			//System.out.println("Hiiii");
			AWSCredentials credentials = new BasicAWSCredentials(keyId,secretId);
			@SuppressWarnings("deprecation")
			AmazonS3 s3client = new AmazonS3Client(credentials);
			List<Bucket> buckets = s3client.listBuckets();
			view.clearProducts();
		    System.out.println("Your Amazon S3 buckets are:");
		    for (Bucket b : buckets) {
		        System.out.println("* " + b.getName());
		        view.showBuckets(b.getName());
		    }
		}
	}
	
	
	class BucketControllerDelete implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			
			String keyId = view.getKeyId();
			String secretId = view.getSecretId();
			//System.out.println("Hiiii");
			AWSCredentials credentials = new BasicAWSCredentials(keyId,secretId);
			@SuppressWarnings("deprecation")
			AmazonS3 s3client = new AmazonS3Client(credentials);
			//AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
			String bucketName = view.getBucketName();
			
		    System.out.println(" - removing objects from bucket");
		    ObjectListing object_listing = s3client.listObjects(bucketName);
		    while (true) {
		        for (Iterator<?> iterator = object_listing.getObjectSummaries().iterator();iterator.hasNext();) {
		            S3ObjectSummary summary = (S3ObjectSummary)iterator.next();
		            s3client.deleteObject(bucketName, summary.getKey());
		        }

		        // more object_listing to retrieve?
		        if (object_listing.isTruncated()) {
		            object_listing = s3client.listNextBatchOfObjects(object_listing);
		        } else {
		            break;
		        }
			    
		    }
		
		}
	}
	
	
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,folderName + SUFFIX, emptyContent, metadata);
		
		client.putObject(putObjectRequest);
	}
	
	
	public static class Reminder {
	    Timer timer;

	    public Reminder(int seconds) {
	        timer = new Timer();
	        timer.schedule(new RemindTask(), seconds*1000*60);
		}

	    class RemindTask extends TimerTask {
	        public void run() {
	            System.out.println("Time's up!");
	            
	            String bucketName = view.getBucketName();
				String folderName = view.getFolderName();
				String keyId = view.getKeyId();
				String secretId = view.getSecretId();
				
				
				AWSCredentials credentials = new BasicAWSCredentials(keyId,secretId);
				@SuppressWarnings("deprecation")
				AmazonS3 s3client = new AmazonS3Client(credentials);
				
				s3client.createBucket(bucketName);
				
				for (Bucket bucket : s3client.listBuckets()) {
					System.out.println(" - " + bucket.getName());
				}
				@SuppressWarnings("unused")
				List<Bucket> buckets = s3client.listBuckets();
			    
				
				createFolder(bucketName, folderName, s3client);
				
				String fileName = folderName + "/" + "images.png";
				s3client.putObject(new PutObjectRequest(bucketName,fileName,new File("C:\\Users\\Dell\\Desktop\\practice.pdf")));
				System.out.println("Uploaded!!");
	            timer.cancel(); //Terminate the timer thread
	            
	        }
	    }
	}
}
