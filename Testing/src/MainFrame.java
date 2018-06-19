
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;


@SuppressWarnings({ "unused", "serial" })
public class MainFrame extends JFrame {
	private static final String SUFFIX = "/";

	private JPanel pnlInput = new JPanel(new GridLayout(0,2,3,3));
	private JPanel pnlCommand = new JPanel(new GridLayout(0,3,3,3));
	private JPanel pnlSpace = new JPanel(new GridLayout(0,1,3,3));
	
	private JLabel lblBrowse = new JLabel("Browse");
	private JLabel lblBucket = new JLabel("Bucket Name");
	private JLabel lblFolder = new JLabel("Folder Name");
	private JLabel lblTimer = new JLabel("Timer");
	private JLabel lblKeyId = new JLabel("Access Key Id");
	private JLabel lblSecretId = new JLabel("Secret Access Key");
	
	private JTextField txtBrowse = new JTextField(10);
	private JTextField txtBucket = new JTextField(10);
	private JTextField txtFolder = new JTextField(10);
	private JTextField txtTimer = new JTextField(10);
	private JTextField txtKeyId = new JTextField(10);
	private JTextField txtSecretId = new JTextField(10);
	
	private JLabel lblSpace = new JLabel();
	private JTextField txtSpace = new JTextField(10);
	
	private JButton btnBrowse = new JButton("Browse");
	private JButton btnUpload = new JButton("Upload");
	private JButton btnTimer = new JButton("TimerUpload");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnList = new JButton("List");
	
	
	public MainFrame() {
		
		pnlInput.add(lblBrowse);
		pnlInput.add(txtBrowse);
		pnlInput.add(lblSpace);
		pnlInput.add(lblBucket);
		pnlInput.add(txtBucket);
		pnlInput.add(lblFolder);
		pnlInput.add(txtFolder);
		pnlInput.add(lblTimer);
		pnlInput.add(txtTimer);
		pnlInput.add(lblKeyId);
		pnlInput.add(txtKeyId);
		pnlInput.add(lblSecretId);
		pnlInput.add(txtSecretId);
		
		pnlInput.add(lblSpace);
		//pnlInput.add(txtSpace);
		pnlInput.add(lblSpace);
		
		pnlCommand.add(btnBrowse);
		pnlCommand.add(btnUpload);
		pnlCommand.add(btnTimer);
		pnlCommand.add(btnDelete);
		pnlCommand.add(btnList);
		
		this.add(pnlInput,BorderLayout.NORTH);
		this.add(pnlCommand,BorderLayout.CENTER);
		this.add(pnlSpace,BorderLayout.SOUTH);
		
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
	}
	
	// Getters..
	public JButton getBtnBrowse() {
		return btnBrowse;
	}
	public JButton getBtnUpload() {
		return btnUpload;
	}
	public JButton getBtnTimer() {
		return btnTimer;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnList() {
		return btnList;
	}
	
	
	/*public String getBrowse() {
		return txtBrowse.getText();
	}*/
	public String getBucketName() {
		return txtBucket.getText();
	}
	public String getFolderName() {
		return txtFolder.getText();
	}
	public String getTimer() {
		return txtTimer.getText();
	}
	public String getKeyId() {
		return txtKeyId.getText();
	}
	public String getSecretId() {
		return txtSecretId.getText();
	}
	
	
	public void setTxtBucketName(JTextField txtBucket) {
		this.txtBucket = txtBucket;
	}
	public void setTxtFolderName(JTextField txtFolder) {
		this.txtFolder = txtFolder;
	}
	public void setTimer(JTextField txtTimer) {
		this.txtTimer = txtTimer;
	}
	public void setTxtKey(JTextField txtKeyId) {
		this.txtKeyId = txtKeyId;
	}
	public void setTxtId(JTextField txtSecretId) {
		this.txtSecretId = txtSecretId;
	}
	
	
	
	/*public void showProduct(String productId, String productPrice, String productQty){
		
		ProductSelectPanel psp = new ProductSelectPanel(productId,productPrice,productQty);
		psp.addMouseListener(new EditListener());
		pnlSpace.add(psp);
		pnlSpace.setLayout(new GridLayout(0,1,3,3));
		/*pnlSpace.add(new JLabel(productId));
		//pnlSpace.add(new JLabel(productName));
		pnlSpace.add(new JLabel(productPrice));
		pnlSpace.add(new JLabel(productQty));*/
	//}
	
	public void showBuckets(String bucketName) {
		
		pnlSpace.add(new JLabel(bucketName));
	}
	
	public void clearProducts() {
		pnlSpace.removeAll();
		
		JPanel header = new JPanel(new GridLayout(0,3,3,3));
		header.add(new JLabel("Bucket Names :"));
		//pnlSpace.add(new JLabel("Product Name"));
		pnlSpace.add(header); 
	}
	
	
}
