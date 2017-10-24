/**

* Write a short description of what the class does (one line)

* @author (your name)

* @version (a version number or a date)

*/

import java.util.*;

public class EAUsername{//class header
    public EAUsername(){
    }
    public EAUsername(String name, String gradYear){
        boolean checkMiddle = true; 
        String lastName = "";
        String middleName = "";
        String userMiddle = "";
        int indexMiddleLast = 0;
        
        int indexFirstMiddle = name.indexOf(" ");
        
        String firstName = name.substring(0, indexFirstMiddle);
        String middleLastName = name.substring(indexFirstMiddle + 1);
        
        
        try { //makes sure that there is a middle name
            indexMiddleLast = middleLastName.indexOf(" ");
            middleName = name.substring(indexFirstMiddle, indexMiddleLast);
        } catch (StringIndexOutOfBoundsException e) {
            checkMiddle = false;
        }
        
        if(checkMiddle == true){
            indexMiddleLast = name.indexOf(" ", indexFirstMiddle);
            middleName = middleLastName.substring(0, indexMiddleLast);
            lastName = middleLastName.substring(indexMiddleLast + 1);
            userMiddle = middleLastName.substring(0,1);
        }else{
            lastName = middleLastName.substring(0);
        }
        
        String userLast = (" ");
        
        int lengthLast = lastName.length();
        
        if(lengthLast > 4){//finds last name part of username
            userLast = lastName.substring(0, 4);
        } else {
            userLast = lastName; 
        }
        
        String userFirst = name.substring(0,1);
        String userGrad = gradYear.substring(2); 
        
        System.out.println("username is: " + userLast + userFirst + userMiddle + userGrad);
    }
}