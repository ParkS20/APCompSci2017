import java.util.*; 
public class LogarithmChallenges{
    LogarithmChallenges(){
        int[] nums = {35, 6, 2, 12, 3, 27, 10, 56, 7, 21, 28, 50, 32, 41, 1, 5, 8, 90, 1};
        //selection(nums);
        int number = 26; 
        //goldbach(number); 
        int[] prime = arrayOfPrime();
        System.out.println(Arrays.toString(prime)); 
        insertion(prime); 
    }
    public void selection(int[] nums){
        int n; 
        int jlow =0; 
        for(int i =0; i<nums.length; i++){
            jlow= i; 
            n = nums[i]; 
            for(int j = i+1; j<nums.length; j++){
                if(nums[j]<nums[i]){
                    nums[i] = nums[j];
                    jlow = j; 
                }
            }
            nums[jlow] = n;
        }
        System.out.println(Arrays.toString(nums));  
    }
    public void goldbach (int num){
        int primeNum1 = 1; 
        int primeNum2 = 1; 
        boolean prime1 = true; 
        boolean prime2 = true; 
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                prime1 = prime(i); 
                prime2 = prime(j); 
                if(prime1==true && prime2==true && i+j==num){
                    primeNum1 = i; 
                    primeNum2 = j; 
                }
            }
        }
        System.out.println(primeNum1 + ", " + primeNum2); 
    }
    public int[] arrayOfPrime(){
        int[] nums = new int[10];
        int max = 200;
        int min = 1;
        int randomNum; 
        for(int i=0; i<10; i++){
            randomNum = (int)(Math.random() * ((max - min) + 1)) + min;
            if(prime(randomNum) == true && duplicate(i, nums) == false){
                nums[i] = randomNum; 
            }else{
                i--; 
            }
        }
        return nums; 
    }
    public void insertion (int[] num){
        boolean goBack = false; 
        int last; 
        int place =1; 
        for(int i=1; i<num.length; i++){
            if(num[i] <num[i-1]){
                goBack = true; 
            }
            while(goBack){
                last = num[i-place]; 
                num[i-place] = num[i-place +1]; 
                num[i - place + 1] = last; 
                try{
                    if(num[i-place] < num[i-place-1]){
                        place ++; 
                    }else{
                        goBack = false; 
                        place = 1; 
                    }
                }catch(Exception e){
                    goBack = false; 
                    place =1; 
                }
            }
        }
        System.out.println(Arrays.toString(num)); 
    }
    public boolean prime (int num){
        boolean prime = true; 
        for(int i = 2; i<num;i++){
            if(num%i==0)
                prime = false; 
        }
        return prime; 
    }
    public boolean duplicate(int num, int[] array){
        boolean duplicate = false; 
        for(int i = 0; i<num; i++){
            if(array[num] == array[i])
                duplicate = true; 
        }
        return duplicate; 
    }
}
