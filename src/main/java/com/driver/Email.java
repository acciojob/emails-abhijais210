package com.driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String emailId;
    private String password;
    Email(){

    }
    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword) && isValid(newPassword)){
            setPassword(newPassword);
        }
    }
    public boolean isValid(String newPassword){
        boolean hasOneUpper = false;
        boolean hasOneLower = false;
        boolean hasOneDigit = false;
        boolean hasOneSpecial = false;

        //if new password length < 8 then this not valid password
        if(newPassword.length() < 8)
            return false;

        for(char ch : newPassword.toCharArray()){
            if(ch >= 'a' && ch <= 'z') {
                hasOneLower = true;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                hasOneUpper = true;
            }
            else if(ch >= '0' && ch <= '9'){
                hasOneDigit = true;
            }
            else{
                hasOneSpecial = true;
            }
        }

        return hasOneUpper && hasOneDigit && hasOneLower && hasOneSpecial;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
