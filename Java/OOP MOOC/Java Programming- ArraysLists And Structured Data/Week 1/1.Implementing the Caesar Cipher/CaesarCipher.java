
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key){
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1){
                boolean isUpper = Character.isUpperCase(currChar);
                if(isUpper){
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    char newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                    encrypted.setCharAt(i, newChar);
                }
            }
            
        }
        
        return encrypted.toString();
        
    }
    
    public void testCaesar(){
        String code = encrypt("First Legion",17);
        System.out.println(code);
    }
    
    public void testCaesar1(){
        
        int key = 19;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        
        
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphaKey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphaKey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(i % 2 == 0){
                if(idx != -1){
                    boolean isUpper = Character.isUpperCase(currChar);
                    if(isUpper){
                        char newChar = shiftedAlphaKey1.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                    else{
                        char newChar = Character.toLowerCase(shiftedAlphaKey1.charAt(idx));
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            else{
                if(idx != -1){
                    boolean isUpper = Character.isUpperCase(currChar);
                    if(isUpper){
                        char newChar = shiftedAlphaKey2.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                    else{
                        char newChar = Character.toLowerCase(shiftedAlphaKey2.charAt(idx));
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
        }
        
        return encrypted.toString();
    }
    
    
    public void tester5(){
        
        String result = encryptTwoKeys("First Legion", 23,17);
        System.out.println(result);
    }
    
    
}
