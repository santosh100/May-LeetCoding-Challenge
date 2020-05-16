class Solution {
    
    public int kadanesAlgo(int A[]){
        int n = A.length;                        
        int maxSum = Integer.MIN_VALUE;                       
        int currentSum = 0; 
        for(int i=0; i<n; i++){   
            currentSum += A[i%n];
                
            if(currentSum > maxSum)
                maxSum = currentSum;  
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
    
    
    
    public int maxSubarraySumCircular(int[] A) {    
        
        
        // o(N^2) Solution => TLE
        /*
        int n = A.length;                
        int max = Integer.MIN_VALUE;                
        for(int i=0; i<n; i++){
            int currentSum = 0; 
            for(int j=i; j<n+i; j++){   
                currentSum += A[j%n];
                
                if(currentSum > max)
                    max = currentSum;  
                if(currentSum < 0)
                    currentSum = 0;
            }
                                                             
        }                           
        return max;   
        */
        
        
        /*
        * OPTIMAL APPROACH
        *
        * Algo: 
        * 1. Apply Simple Kadane's Algo
        * 2. Sum the Array
        * 3. Inverse Array Values i.e. - to + and + to -
        * 4. Apply Kadane's Algo on Inversed Array Values
        * 5. .........
        */
        
        int n = A.length;
        int Ans1 = kadanesAlgo(A);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += A[i];
            A[i] *= -1;
        }
        int Ans2 = kadanesAlgo(A);
        
        if((Ans2+sum != 0) && Ans2+sum > Ans1 ){
            return Ans2+sum;
        }else{
            return Ans1;
        }
    }
}