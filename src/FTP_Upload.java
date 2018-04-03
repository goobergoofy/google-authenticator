import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTP_Upload {

    FTPClient ftp = null;
    finalNameClass finalNameClassObject = new finalNameClass();

    String current_user = System.getProperty("user.name");

    public FTP_Upload(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.connect(host);
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }

    public void uploadFile(String localFileFullName, String fileName, String hostDir) throws Exception {
        try(InputStream input = new FileInputStream(new File(localFileFullName))){
            this.ftp.storeFile(hostDir + fileName, input);
        }
    }

    public void disconnect() {
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                System.out.println("Closing application...");
            }
        }
    }

    public void compileUpload() throws Exception {
        FTP_Upload ftpUploader = new FTP_Upload("144.217.164.62", "google", "google");
        ftpUploader.uploadFile("/Users/" + current_user + "/Documents/" + finalNameClassObject.getFinal_name(), finalNameClassObject.getFinal_name(), "");
        ftpUploader.disconnect();
    }

}