/*
 * Closed Syllables: A closed syllable has one and only one vowel, and 
 * it ends in a consonant. 

 * Open Syllables: An open syllable has one and only one vowel, and that 
 * vowel occurs at the end of the syllable. 

 * Silent-E Syllables: A silent-e syllable ends in an e, has one and only 
 * one consonant before that e, and has one and only one vowel before that 
 * consonant. 

 * Vowel Combination Syllables: A vowel combination syllable has a cluster 
 * of two or three vowels or a vowel-consonant unit with a sound or sounds 
 * particular to that unit. 

 * Vowel-R Syllables: A vowel-r syllable is one which includes one and only 
 * one vowel followed by an r, or one vowel followed by an r which is 
 * followed by a silent e, or a vowel combination followed by an r. 

 * Consonant-L-E Syllables: In these syllables, a consonant is followed by 
 * le. The vowel sound in these syllables is the schwa sound that occurs 
 * before the l. Examples include -ble, -cle, -dle, -fle, and -gle.
 */
import java.util.*;
public class Syllables{
    public static void Syllables()
    {
        String[] words = {"cat", "hello", "world", "tennis", "episcopal", "count", "learn", "denise", "state","statement","fruit",
            "calculation","spite","spiteful","reservation",
            "late","lately","extreme","expensive", "purposeful"};
        int wordsLength = words.length;
        for(int i=0; i<wordsLength; i++)
            findSyllable(words[i]); 
    }
    public static void findSyllable(String word){
        String[] arr = word.split("(?!^)");
        int count = 0;
        int length = word.length();
        for(int i=0; i<length; i++){
            if(arr[i].equals("a")| arr[i].equals("e")| arr[i].equals("i")| 
            arr[i].equals("o")| arr[i].equals("u")| arr[i].equals("y")){ //for letter is vowel
                count ++;
                try{
                    if(arr[i].equals("y")&&(arr[i+1].equals("a") | arr[i+1].equals("e") 
                     | arr[i+1].equals("o") | arr[i+1].equals("u"))){ //sees if y is a consonant or vowel
                        count--;
                    }
                }catch(Exception e){
                }
                try{
                    if(arr[i-1].equals("a")| arr[i-1].equals("e")| arr[i-1].equals("i")|
                    arr[i-1].equals("o")| arr[i-1].equals("u")){//looks for double vowel syllable
                        count--;
                        try{
                            if(arr[i-1].equals("i"))//exception to double vowel rule
                                count ++; 
                        }catch(Exception e){
                        }
                        try{
                            if((arr[i-2].equals("a") | arr[i-2].equals("i") | 
                            arr[i-2].equals("e") | arr[i-2].equals("o") | 
                            arr[i-2].equals("u")) &! arr[i-1].equals("i"))//looks for triple+ vowel sylables
                                count ++; 
                        }catch(Exception e){
                        }
                    }
                }catch(Exception e){
                }
                if(arr[i].equals("e") && i>2 && (arr[i-2].equals("a") | 
                arr[i-2].equals("i") | arr[i-2].equals("e") | arr[i-2].equals("o") | 
                arr[i-2].equals("u"))){ //exception for e as an open ended syllable
                    count --; 
                    if(arr[i-1].equals("x"))//exception to e
                        count++; 
                    try{
                        if(arr[i+1].equals("d")||arr[i+1].equals("r"))//exception to e
                            count++;
                    }catch(Exception e){
                    }
                    try{
                        if(arr[i+2].equals("e"))//exception to e
                            count ++; 
                    }catch(Exception e){
                    }
                }
           }
        }
        if(count>1 && arr[length-1].equals("e") &! (arr[length-3].equals("a") | 
        arr[length-3].equals("i") | arr[length-3].equals("e") | arr[length-3].equals("o") | 
        arr[length-3].equals("u")))//for one syllable words with e at the end as only vowel
            count--;
        System.out.println("Word: " + word + "   syllable: " + count);
    }
}

