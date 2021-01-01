package mybookstore.mybookstore.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordHasher {

    public String hashPassword(String originalPassword) throws NoSuchAlgorithmException {

        String generatedPassword = null;

        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Add password bytes to digest
        md.update(originalPassword.getBytes());
        // Get the hash's bytes
        byte[] bytes = md.digest();
        // This bytes[] has bytes in decimal format;
        // Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes){
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        // Get complete hashed password in text format
        generatedPassword = sb.toString();

        return generatedPassword;
    }
}
