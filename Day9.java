class Solution {
    public boolean isPerfectSquare(int num) {
        
        //MY APPROACH (ACCEPTED)
        /*
        long i;
        for(i=1; i*i< num; i++);
        if(i*i == num)
            return true;
        else
            return false;
        */
        
        
        //OPTIMAL ONE (USING BINARY SEARCH)
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((long)mid*mid == num){
                return true;
            }else if(num < (long)mid*mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
        
    }
}