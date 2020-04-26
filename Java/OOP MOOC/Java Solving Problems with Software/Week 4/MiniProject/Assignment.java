
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
    
    public void totalBirths(FileResource fr){
        
        StorageResource uniqueNames = new StorageResource();
        int uniqueBoyNames = 0;
        int uniqueGirlNames = 0;
        int totalNames;
        String gend;
        
        int totalBirths = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            
            if(uniqueNames.contains(rec.get(0))==false){
                uniqueNames.add(rec.get(1));
            }
        }
        
        for(String gender : uniqueNames.data()){
            gend = gender;
            if(gend.equals("F")){
                uniqueGirlNames += 1;
            }
            else{
                uniqueBoyNames += 1;
            }
            
        }
        
        totalNames = uniqueGirlNames + uniqueBoyNames;
        System.out.println("Total Births = " + totalBirths);
        System.out.println("Total Unique Boys Names = " + uniqueBoyNames);
        System.out.println("Total Unique Girls Names= " + uniqueGirlNames);
        System.out.println("Total Unique Names= " + totalNames);
    
    
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1905.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year,String name,String gender){
        String fileName = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        boolean found = false;
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                rank += 1;
                if (rec.get(0).equals(name)) {
                    found = true;
                    break;
                }
            }
            
        }
        
        if(found)return rank;
        else return -1;
    }
    
    public void testGetRank(){
        int rank = getRank(1947,"Michael","M");
        System.out.println("Michael McAllister " + rank);
    }
    
    
    public String getName(int year, int rank, String gender){
        String fileName = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        String name = null;
        int i = 0;
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                i += 1;
                if (i == rank) { 
                   return rec.get(0);
                }
            }
            
        }
        return "NO NAME";
    }
    
    public void testgetName() {
        String name = getName(1947, 7, "M");
        System.out.println(name);
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        
        int rankOldYear = getRank(year,name,gender);
        String newName = getName(newYear, rankOldYear, gender);
        
        System.out.println(name + " born in " + year +
                           " would be " + newName +
                           " if he/she("+gender+") was born in "
                           + newYear + ".");
        
    }
    
    public void testNameInYear() {
         whatIsNameInYear("Susan",1972,2014,"F");
        
    }
    
    
    
    public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 500000;
        int highestYear = 0;
        
        for(File f : dr.selectedFiles()){
            String fName = f.getName();
            int year = Integer.parseInt(fName.substring(3,7));
            int currentRank = getRank(year, name, gender);
            
            if(currentRank < highestRank){
                highestRank = currentRank;
                highestYear = year;
            }
            
                
        }
        return highestYear; 
    }
       
    public void testYearHighestRank(){
        int year = yearOfHighestRank("Mich","M");
        System.out.println(year);
    }
    
    public double getAverageRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        double runningRank = 0;
        int fileCount = 0;
        
        for(File f : dr.selectedFiles()){
            String fName = f.getName();
            int year = Integer.parseInt(fName.substring(3,7));
            int rank = getRank(year, name, gender);
            runningRank += rank;
            fileCount +=1;  
        }
        
        return runningRank/fileCount;
    }
    
    public void testAverageRank(){
        double average = getAverageRank("Robert", "M");
        System.out.println(average);
    }
    
    public int getTotalBirthsRankedHigher(int year, String name,String gender){
        String fileName = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        int sumOfBirthsRankedHigher = 0;
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                int currentBirth = Integer.parseInt(rec.get(2));
                sumOfBirthsRankedHigher += currentBirth;
                if(rec.get(0).equals(name)){
                    return sumOfBirthsRankedHigher - currentBirth;
                }
            }
        }
        return -1;
    }
    
     public void tester(){
        int t = getTotalBirthsRankedHigher(1990,"Emily","F");
        System.out.println("Sum of higher: " + t);
    }
    
}
    
    

