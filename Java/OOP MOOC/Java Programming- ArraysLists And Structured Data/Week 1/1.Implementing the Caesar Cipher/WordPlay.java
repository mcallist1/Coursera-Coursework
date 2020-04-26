
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public boolean isVowel(char ch){
        
        char lower = Character.toLowerCase(ch);
        String vowels = "aeiou";
        int flag =  vowels.indexOf(lower);
        
        if (flag == -1) return false;
        else return true;
        
    }
    
    public void tester(){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
    }
    
    public String replaceVowels(String phrase, char ch){
        
        String phraseLower = phrase.toLowerCase();
        StringBuilder sb = new StringBuilder(phraseLower);
        for(int i = 0; i < sb.length(); i++){
            
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i, ch);
            }
            
        }
        
        return sb.toString();
           
    }
    
    public void tester2(){
        String tomo = replaceVowels("Hello World",'*');
        System.out.println(tomo);
        
    }
    
    public String emphasize(String phrase, char ch){
        
        String phraseLower = phrase.toLowerCase();
        StringBuilder sb = new StringBuilder(phraseLower);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == ch){
                if(i % 2 == 0){
                    sb.setCharAt(i, '*');
                }else{
                    sb.setCharAt(i, '+');
                }
            }
            
        }
        
        return sb.toString();
        
    }
    
    public void tester3(){
        String tomo = emphasize("dna ctgaaactga",'a');
        String mary = emphasize("Mary Bella Abracadabra",'a');
        System.out.println(tomo);
        System.out.println(mary);
    }
    
    
    
    
    
    
    
    

}
