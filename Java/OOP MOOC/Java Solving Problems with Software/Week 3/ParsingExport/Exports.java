
/**
 * Write a description of Exports here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Exports {
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord rec : parser){
            if(rec.get("Country").equals(country)){
                return rec.get("Country")+": " 
                      + rec.get("Exports") +": "
                      + rec.get("Value (dollars)"); 
            }
        }
        return "NOT FOUND";
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        String info = countryInfo(parser, "Germany");
        System.out.println(info);
        
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        
        for(CSVRecord rec : parser){
            String export = rec.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(rec.get("Country"));
            }
        }
        
    }
    
    public void tester2(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        listExportersTwoProducts(parser, "cotton", "flowers");
        
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        
        int number = 0;
        
        for(CSVRecord rec : parser){
            String exports = rec.get("Exports");
            if(exports.contains(exportItem)){
                number+=1;
            }
        }
        
        return number;
    }
    
    public void tester3(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        int numOfExp = numberOfExporters(parser, "cocoa");
        System.out.println(numOfExp);
        
    }
    
    public void bigExporters(CSVParser parser, String amount){
        
        int amountLength = amount.length();
        for(CSVRecord rec: parser){
            int recLength = rec.get("Value (dollars)").length();
            if(recLength > amountLength){
                System.out.println(rec.get("Country") + " " + rec.get("Value (dollars)"));
            }
        }
    }
    
    public void tester4(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        bigExporters(parser, "$999,999,999,999");
       
   
    }
    
    
}
