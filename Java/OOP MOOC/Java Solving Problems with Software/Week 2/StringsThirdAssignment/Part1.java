

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
   
    
    public int FindStopCodon(String dnaStr,
                             int startIndex,
                             String stopCodon){
       
     int currIndex =  dnaStr.indexOf(stopCodon,startIndex+3);
     
     while(currIndex != -1){
         
         if((currIndex - startIndex) % 3 ==0){
                return currIndex;
            }
         else{
             currIndex = dnaStr.indexOf(stopCodon,currIndex + 1);
            }
              
     }
                                 
     return dnaStr.length();
        
    }
    
    public String FindGene(String dna, int where){
        
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex == -1){
            return "";
        }
        
        int taaIndex = FindStopCodon(dna,startIndex,"TAA");
        int tagIndex = FindStopCodon(dna,startIndex,"TAG");
        int tgaIndex = FindStopCodon(dna,startIndex,"TGA");
        
        int minIndex = Math.min(Math.min(taaIndex,tagIndex),
                                tgaIndex);
        if(minIndex == dna.length()){
            return "";
        }
        else{
            return dna.substring(startIndex,minIndex+3);
        }
                                
        
    }
    
    
    public void PrintAllGenes(String dna){
        
        int startIndex = 0;
        
        while(true){
            
            String currentGene = FindGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex)+
                currentGene.length();
            
            
        }
        
    }
    
    
    public StorageResource GetAllGenes(String dna){
        
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        
        while(true){
            
            String currentGene = FindGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            
            geneList.add(currentGene);
            
            startIndex = dna.indexOf(currentGene,startIndex)+
                currentGene.length();
            
            
        }
        
        return geneList;
        
    }
    
    public double CGRatio(String dna){
        
        dna = dna.toUpperCase();
        double CG = 0;
        
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                CG += 1;
            }
        }
        
        return (float)CG/dna.length();
        
        
    }
    
    public int CountCTG(String dna){
        
        int startIndex = 0;
        int CTGCount = 0;
        
        while(true){
            
            int ctg = dna.indexOf("CTG", startIndex);
            
            if(ctg != -1){
                CTGCount += 1;
                startIndex = ctg + 3;
            }
            else{
                break;
            }
            
            
        }
        
        return CTGCount;
        
    }
    
    public void TestCTGCount(){
        
        String dna = "HFHFHFAHACTGJFJFJFJCTG";
        System.out.println("Count is " + CountCTG(dna));
        
        
    }
    
    public void TestCTRatio(){
        
        String dna = "ATGCCATAG";
        System.out.println("Ratio is " + CGRatio(dna));
        
    }
    
    public void TestOn(String dna){
        System.out.println("Testing PrintAll on " + dna);
        PrintAllGenes(dna);
    }
    
    public void Test(){
        TestOn("AATGCTAACTAGCTGACTAAT");
    }
        
    public void ProcessGenes(StorageResource sr){
        
        int overNine = 0;
        int highCG = 0;
        int stringLength = 0;
        
        for(String s: sr.data()){
            
            int sLen = s.length();
            
            if(s.length() > 60){
                System.out.println(s +" has more than 60 chars");
                overNine ++;
                
            }
            
            if(CGRatio(s) > 0.35){
                System.out.println(s +" has CG ratio > 0.35");
                highCG ++;
            }
            
            if(sLen > stringLength){
                stringLength = sLen;
            }
            
        }
        
        
        System.out.println("The longest string is " + stringLength + " characters");
        
    }
    
    public void TestProcessGenes(){
        
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
       
        StorageResource sr = new StorageResource();
        sr = GetAllGenes(dna);
        
        for (String gene : sr.data() ){
            sr.add(gene);
        }
        
        ProcessGenes(sr);
        
    }
    
    public int CountGenes(String dna){
       
        int startIndex = 0;
        int count = 0;
        
        while(true){
            
            String currentGene = FindGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            count ++;
            startIndex = dna.indexOf(currentGene,startIndex)+
                currentGene.length();
            
            
        }
        return count;
       
       
    }
    
   
    
    public void Assignment(){
        
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        System.out.println("Count of genes is " + CountGenes(dna));
        
        int overSixty = 0;
        int cg = 0;
        int ctgCount = CountCTG(dna);
        
        StorageResource sr = new StorageResource();
        sr = GetAllGenes(dna);
        int longestGene = 0;
        
        
        for (String item : sr.data()) {
            if(item.length() > 60){
                overSixty+=1;
            }
            
            if(CGRatio(item) > 0.35 ){
                cg += 1;
            }
            
            if(item.length() > longestGene){
                longestGene = item.length();
            }
            
            
        }
        
        
        System.out.println("Over Sixty = " + overSixty);
        System.out.println("CG Over 0.35  = " + cg);
        System.out.println("CTG Count  = " + ctgCount);
        System.out.println("Longest Gene = " + longestGene);
    }
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


