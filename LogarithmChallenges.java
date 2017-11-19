import java.util.*; 
public class LogarithmChallenges{
    LogarithmChallenges(){
        int[] nums = {35, 6, 2, 12, 3, 27, 10, 56, 7, 21, 28, 50, 32, 41, 1, 5, 8, 90, 1};
        //selection(nums);
        int number = 26; 
        //goldbach(number); 
        int length = 50;
        int[] prime = arrayOfPrime(length);
        int max = length;
        int min = 0;
        int randomNum = (int)(Math.random() * ((max - min) + 1)) + min;
        prime = insertion(prime); 
        sequential(randomNum, prime);   
        binarySearch(randomNum, prime);
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
    public int[] arrayOfPrime(int number){
        int[] nums = new int[number];
        int max = 500;
        int min = 2;
        int randomNum; 
        for(int i=0; i<nums.length; i++){
            randomNum = (int)(Math.random() * ((max - min) + 1)) + min;
            if(prime(randomNum) == true && duplicate(randomNum, i, nums) == false){
                nums[i] = randomNum; 
            }else{
                i--; 
            }
        }
        return nums; 
    }
    public int[] insertion (int[] num){
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
        return num; 
    }
    public void sequential(int num, int[]list){
        int spot=0; 
        int counter = 0; 
        for(int i=0; i<list.length; i++){
            if(list[i] == list[num]){
                spot = i; 
                counter = i + 1; 
                i += list.length;  
            }
        }
        System.out.println("Sequential: ");
        System.out.println("Spot: " + spot); 
        System.out.println("Iterations: " + counter); 
    }
    public void binarySearch(int num, int[] list){
        boolean cut = true; 
        int counter = 1; 
        int spot=0; 
        int middle = list.length/2; 
        while(cut){
            if(list[num]>list[middle]){
                counter ++; 
                try{
                    middle = middle + (list.length/((int)(Math.pow(2, counter)))); 
                }catch(Exception e){
                    middle += 1; 
                }
            }else if(list[num] == list[middle]){
                cut = false; 
                spot = middle; 
            }else{
                counter ++; 
                try{
                    middle = middle - (list.length/((int)(Math.pow(2, counter)))); 
                }catch(Exception e){
                    middle -=1; 
                }
            }
        }
        System.out.println("Binary Search: "); 
        System.out.println("Spot: " + spot); 
        System.out.println("Iterations: " + counter); 
    }
    public boolean prime (int num){
        boolean prime = true; 
        for(int i = 2; i<num;i++){
            if(num%i==0)
                prime = false; 
        }
        return prime; 
    }
    public boolean duplicate(int num, int place, int[] array){
        boolean duplicate = false; 
        array[place] = num; 
        for(int i = 0; i<place; i++){
            if(array[place] == array[i])
                duplicate = true; 
        }
        return duplicate; 
    }
}
