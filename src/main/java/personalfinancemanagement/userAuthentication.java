package personalfinancemanagement;

import java.security.*;
import java.util.regex.*;
import java.util.*;

public class userAuthentication {
    String username, email, password;

    // Salting and Hashing methods for password encryption
    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String saltedPassword = password + salt;
        byte[] hashBytes = digest.digest(saltedPassword.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    // Method to validate email format
    public static boolean isValidEmail(String email) {
        String emailValidityFormat = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailValidityFormat);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static void insertUserData(String username, String email, String password) {
        // Generate salt
        String salt = generateSalt();

        try {
            // Hash password with salt
            String hashedPassword = hashPassword(password, salt);

            // Insert user data into database
            DatabaseManager.insertUserData(username, email, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error hashing password: " + e.getMessage());
        }
    }

}
