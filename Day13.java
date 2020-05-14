import java.util.ArrayList;

class Solution {
    public String removeKdigits(String num, int k) {        
        
        /*
        * My Approach - Remove first largest digit starting from 0, repeat this k times
        * Time Complexity - O(N^2)
        * Space Complexity - O(1)
        
        * You can implement using stack for O(N) complexity
        */
        
        for(int i=0; i<k; i++){
            int j=0;
            while(j+1 < num.length() && num.charAt(j) <= num.charAt(j+1)){
                j++;
            }
            
            String first_half = ""+num.substring(0, j);
            String second_half = ""+num.substring(j+1, num.length());
            num = first_half + second_half;
        }
        int i=0;
        while(i< num.length() && num.charAt(i) == '0'){
            i++;
        }
        num = ""+num.substring(i, num.length());
        if(num.length() == 0){
            return "0";
        }else{
            return num;
        }
    }
}