class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
 
        int t = 1;
        int power = 1;
        for(int i=1; i<=num; i++){
            if(i==power){
                result[i] = 1;
                power <<= 1;
                t = 1;
            }else{
                result[i] = result[t]+1;
                t++;
            }
        }
 
        return result;
    }
}