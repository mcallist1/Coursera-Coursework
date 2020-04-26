
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int HowMany(String stringa,String stringb){
        
        int count = 0;
        int currIndex = stringb.indexOf(stringa,0);
        
        while(currIndex != -1){
           count ++; 
           currIndex = stringb.indexOf(stringa,currIndex +
                        stringa.length()); 
            
        }
       
        return count;
        
    }
    
    
    public void TestHowMany(){
        
        int test1 = HowMany("GAA","ATGAACGAATTGAATC");
        int test2 = HowMany("AA","ATAAAA");
        int test3 = HowMany("AA","ATAAAAHFHFHFHFHFHSHSAAFFAAA");
        
        
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
    
    
}
