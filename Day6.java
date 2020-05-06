import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {       
        HashMap<Integer,Integer> hm = new HashMap<>();
            // value, count
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(hm.containsKey(nums[i])){
                if(hm.get(nums[i])+1 > n/2){
                    return nums[i];
                }else{
                    hm.replace(nums[i], hm.get(nums[i]) + 1 );
                }
            }else{
                hm.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}