import java.util.*;
/**
 * Sejin Park
 * 10/30
 */
public class ProgrammingChallenge
{
    
    public ProgrammingChallenge()
    {
        
       String[] letters = {"a","a","a","a","b","c","c","a","a","d","e","e","e","e"};
       
       String[] words = {"civic", "tent","push","level","radar","hello","stats","madam","world"};
       
       removeConsecutives(letters); 
       
       for(int i=0; i<words.length; i++)
            isPalindrome(words[i]); 
       GCF(36, 63); 
    }
     
     
      /*"a","a","b","c","c","a"
     * create an arraylist that removes the consecutive 
     * thus, the above array would become an 
     * arraylist that held the following values
     * a,b,c,a
     * print the contents of the arraylist to the screen
     * at end of method.
     */
    public void removeConsecutives(String[] a){
        int length = a.length;
        ArrayList<String> letters = new ArrayList<String>();
        for(int i=0; i<length; i++){
            try{ 
                if(!(a[i].equals(a[i+1]))){
                    letters.add(a[i]); 
                }
            }catch(Exception e){
                letters.add(a[i]); 
            }
        }
        System.out.println(letters); 
    }
    
      /*
     * Is the string a palindrome
     */
    public void isPalindrome(String word){
        String palindrome = "true"; 
        String[] letter = word.split("(?!^)");
        int count = 0;
        int length = word.length();
        for(int i = 0; i<length/2; i++){
            if(!(letter[i].equals(letter[length-i-1]))){
                palindrome = "false"; 
                i = length; 
            }
        }
        System.out.println(word + ": " + palindrome); 
    }
    
    public void GCF(int x, int y){
        int factor =0; 
        for(int i = 1; i <= (x/2); i++){
            for(int j = 1; j<= (y/2); j++){
                if(i ==j && x%i == 0 && y%j == 0){
                    factor = i; 
                }
            }
        }
        System.out.println(factor); 
    }
}