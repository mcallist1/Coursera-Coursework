
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
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
    
    
   public void TestCountGenes(){
       int count = CountGenes("ATGTAAGATGCCCTAG");
       System.out.println("Count of genes is " + count);
    }
    
    
    
}
