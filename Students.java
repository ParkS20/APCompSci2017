public class Students{
    public Students(){
    }
    public Students(int gradYear){
        if(2024 >= gradYear && gradYear>= 2022){
            Middle mid = new Middle(); 
            mid.Chapel(); 
        }
        if(2021>= gradYear && gradYear>=2018){
            Upper upper = new Upper(); 
            upper.Chapel(); 
        }
        System.out.println("Make sure to wear the right dress code!");
    }
}