import java.util.HashMap;
    
class Solution {
        
    public int findMaxLength(int[] nums) {
                
        //Time Complexity O(N)
        //Space Complexity O(N)
        if(nums.length == 0 || nums.length == 1)
            return 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();   
        hm.put(0, -1);
        int count = 0;
        int longest = 0;
        
        for(int i=0; i<nums.length; i++){  
            if(nums[i] == 1){
                count++;
            }else{
                count--;
            }
            if(hm.containsKey(count)){
                longest = Math.max(longest, i - hm.get(count));
            }else{
                hm.put(count, i);
            }
        }    
        return longest;
    }
}