
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String FindSimpleGene(String dna){
        
        String result;
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA",startIndex + 3);
        if(stopIndex == -1){
            return "";
        }
        
        result = dna.substring(startIndex,stopIndex + 3);
        
        if(result.length() % 3 == 0){
            return result;
        }
        else{
            return "";
            }
        }
        
    public void TestSimpleGene(){
        
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        String lower = dna.toLowerCase();
        System.out.println("DNA(A) strand is " + dna);
        String gene = FindSimpleGene(dna);
        System.out.println("Gene is " + gene);
        System.out.println(lower);
        
        dna = "ATGHFHFHFHFHFHFHFHDHSSHTAA";
        System.out.println("DNA strand is " + dna);
        gene = FindSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TAAATGJGJGGJTAAHSHGSGSFJDHDATG";
        System.out.println("DNA strand is " + dna);
        gene = FindSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "BABAYAYAHFDGGJFHSGSHATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = FindSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        
     
        
        
    }
    
       
        
        
    }


