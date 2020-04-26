
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    
    public void TestOn(String dna){
        System.out.println("Testing PrintAll on " + dna);
        PrintAllGenes(dna);
    }
    
    public void Test(){
        TestOn("AATGCTAACTAGCTGACTAAT");
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


