
/**
 * Write a description of mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mine {
  
  public String mystery(String dna) {
  int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}

public void test(){
     System.out.println(mystery("KKKKKSJSHSHSHSHSTBSBSBBB"));
     System.out.println(mystery("KKKTTTTTTKKSJSHSHSHSHSTBSBSBBB"));
     System.out.println(mystery("KKKKKSJSHSHSHSHSTTTTTTTBSBSBBB"));
     System.out.println(mystery("KKTTTTKKKSJSHSHSHSHSTBSBSBBB"));
     System.out.println(mystery("KKKKKSJSHSHSHSHSTBSBSTTTTBBB"));
}

}
