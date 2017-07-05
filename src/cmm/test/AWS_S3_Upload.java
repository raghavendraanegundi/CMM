package cmm.test;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
/**
 * Created by Raghavendra.A on 28-06-2017.
 */
public class AWS_S3_Upload {

    public static void main(String[] args) {
        String s3Url = "http://s3.amazonaws.com/com.charter.aesd.e2e.tvod.automation";
        try {
            System.out.println("----------Start UploadFileToS3----------");
            // credentials object identifying user for authentication
            AWSCredentials credentials = new BasicAWSCredentials("AKIAJ4SIT2WPNMPPH7YA", "1fGRwk1B7azyZYexceWAKj5uSms40eP59wrtaD1R");
            // create a client connection based on credentials
            AmazonS3 s3client = new AmazonS3Client(credentials);
            // Set the End Point
            s3client.setEndpoint("http://s3.amazonaws.com/com.charter.aesd.e2e.tvod.automation");
            // upload the file to the folder and set it to public
            String fullFileName = "CMM_MDMS_SELENIUM" + "/" + "MDMS_SEARCH_OUTPUT.csv";
            s3client.putObject(new PutObjectRequest("com.charter.aesd.e2e.tvod.automation", fullFileName, new File("C:\\Users\\Raghavendra.A\\Documents\\MDMS_SEARCH_OUPUT.csv")).withCannedAcl(CannedAccessControlList.PublicRead));
//            s3client.putObject(new PutObjectRequest("com.charter.aesd.e2e.tvod.automation", fullFileName, new File("C:\\Users\\Raghavendra.A\\Documents\\MDMS_SEARCH_OUPUT.csv")).withCannedAcl(CannedAccessControlList.PublicRead));
            System.out.println("Uploaded file to S3 Bucket: " + s3Url);
            System.out.println("----------End UploadFileToS3----------");
        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "*****Fail to create upload file in S3 Bucket...", e);
            e.printStackTrace();
        }
    }

    private static void createFolder(String bucketName, String folderName, AmazonS3 client) {
        System.out.println("Start createFolder() Method:");
        try {
            // create meta-data for your folder and set content-length to 0
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(0);
            // create empty content
            InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
            // create a PutObjectRequest passing the folder name suffixed by /
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + "/", emptyContent, metadata);
            // send request to S3 to create folder
            client.putObject(putObjectRequest);
            System.out.println("Folder created: " + folderName);

        } catch (Exception e) {
//            System(Level.SEVERE, "*****Fail to create folder in S3 Bucket...", e);
            e.printStackTrace();
        }
        System.out.println("End createFolder() Method:");
    }


}
