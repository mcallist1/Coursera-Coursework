
/**
 * Write a description of Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Assignment {
    public CSVRecord coldestHourInFile(CSVParser parser){ 
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRow: parser){
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                
                if(currentTemp < coldestTemp){
                    coldestSoFar = currentRow;
                }
            }
            
        }
        
        return coldestSoFar;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource("nc_weather/2012/weather-2012-01-01.csv");
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temp was " + coldestHour.get("TemperatureF") + " on " + coldestHour.get("DateUTC"));
        
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String fName = null;
        String returnString = "";
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if(currentTemp < coldestTemp){
                    coldestSoFar = currentRow;
                    fName = f.getAbsolutePath();
                }
            }
        }
        return fName;
    }
    
    public void testFileWithColdesttemperature(){
        String coldestFile = fileWithColdestTemperature();
        FileResource fr = new FileResource(coldestFile);
        CSVRecord coldestRow = coldestHourInFile(fr.getCSVParser());
        double coldestTemp = Double.parseDouble(coldestRow.get("TemperatureF"));
        
        System.out.println("Coldest day was in file " + coldestFile);
        System.out.println("Coldest temperature on that day was " + coldestTemp);
        System.out.println("All the Temperatures on the coldest day were:");
        
        for(CSVRecord temp : fr.getCSVParser()){
            System.out.println(temp.get("DateUTC") + " " + temp.get("TemperatureF"));
        }
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        
        CSVRecord lowestSoFar = null;
        
        for(CSVRecord currentRow : parser){
            if(currentRow.get("Humidity").equals("NA") == false){
                if(lowestSoFar == null){
                    lowestSoFar = currentRow;
                }
                else{
                    double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                    if(currentHumidity < lowestHumidity){
                        lowestSoFar = currentRow;
                    }
                }   
            }
            
        }
        return lowestSoFar;
        
    }
    
    public void testLowestHumidityInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if(lowestSoFar == null){
                lowestSoFar = currentRow;
            }
            else{
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                if(currentHumidity < lowestHumidity){
                        lowestSoFar = currentRow;
                }
            } 
        }
        
        return lowestSoFar;
    }
    
    public void testLowestHumidityInManyfiles(){
        CSVRecord lowestHumidityRecord = lowestHumidityInManyFiles(); 
        String lowestHumidity = lowestHumidityRecord.get("Humidity");
        String time = lowestHumidityRecord.get("DateUTC");
        
        System.out.println("Lowest Humidity was " + lowestHumidity + " at " + time);
        
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        int count = 0;
        double sum = 0;
        
        for(CSVRecord row : parser){
            if(row.get("TemperatureF").equals("NA")==false){
                sum += Double.parseDouble(row.get("TemperatureF"));
                count +=1;
            }    
        }
        
        return sum/count;
    }
    
    public void testAverageTemperatureInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureInFile(parser);
        
        System.out.println("Average temperature in file is " +averageTemp);
        
    }
    
    //Fix this method, not working correctly.
    public double averageTemperatureWithHighHumidity(CSVParser parser, int value){
        double count = 0;
        double sum = 0;
        
        for(CSVRecord row : parser){
             if(row.get("Humidity").equals("N/A") == false){
                 double humidity = Double.parseDouble(row.get("Humidity"));
                 if(humidity >= value){
                     sum += Double.parseDouble(row.get("TemperatureF"));
                     count +=1;
                 }
            }
        }
        return sum/count;
    }
    
    public void testAverageTemperatureWithHighHumidity(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        double avTempHighHumidity = averageTemperatureWithHighHumidity(parser, 80);
        System.out.println(avTempHighHumidity + "baby");
        
    }
    
    
    
}
