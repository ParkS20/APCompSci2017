import java.util.*;
public class StudentStarter{
    public StudentStarter(){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Graduation Year: ");
        int gradYear = sc.nextInt(); 
        Students stu = new Students(gradYear); 
    }
}
