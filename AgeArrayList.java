import java.util.*;
public class AgeArrayList{
    public static void AgeArrayList(){
        Scanner sc = new Scanner(System.in);
        boolean plugging = true; 
        ArrayList<Integer> age = new ArrayList<Integer>();
        int year; 
        int average = 0; 
        while(plugging){
            System.out.println("Enter age of family member (negative number to stop): ");
            year = sc.nextInt(); 
            if(year>=0)
                age.add(year); 
            else
                plugging = false; 
        }
        int length = age.size(); 
        for(int i=0; i<length; i++){
            average += age.get(i); 
        }
        average=average/(length); 
        System.out.println("Average: " + average); 
    }
}
