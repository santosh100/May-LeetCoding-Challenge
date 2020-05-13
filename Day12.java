class Solution {
    
    // My Approach - O(logn) - Accepted
    /*
    public int singleNonDuplicate(int[] nums) {        
        if(nums.length == 1){
            return nums[0];
        }
        
        int value = 1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(mid-1 <0 && nums[mid+1] != nums[mid]){
                value = nums[mid];
                break;
            }else{
                if(mid+1 >nums.length-1 && nums[mid-1] != nums[mid]){
                    value = nums[mid];
                    break;
                }else{
                    if(mid >0 && mid<nums.length-1 && nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]){
                        value = nums[mid];
                        break;
                    }else{
                        if(mid%2 == 1){
                            if(nums[mid]%2 == 1){
                                if(mid >0 && nums[mid-1] == nums[mid]){
                                    left = mid+1;
                                }else{
                                    right = mid-1;
                                }
                            }else{
                                if( mid >0 && nums[mid-1] == nums[mid]){
                                    left = mid+1;
                                }else{
                                    right = mid-1;
                                }   
                            }
                        }else{
                            if(nums[mid]%2 == 0){
                                if(mid <nums.length-1 && nums[mid+1] == nums[mid]){
                                    left = mid+1;
                                }else{
                                    right = mid-1;
                                }
                            }else{
                                if(mid < nums.length-1 && nums[mid+1] == nums[mid]){
                                    left = mid+1;
                                }else{
                                    right = mid-1;
                                }
                            }
                        }
                    }
                }
            }                                                                                    
        }
        return value;
    }
    */            
    
    
    // Better One -  O(logn)
    
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0; 
        int right = nums.length-1;
        
        while(left<right){
            
            int mid = left + (right - left)/2;
            boolean check_if_halves_are_even = (right - mid) % 2 == 0;
            
            if(nums[mid+1] == nums[mid]){
                
                if(check_if_halves_are_even){
                    left = mid + 2;
                }else{
                    right = mid - 1;                    
                }
                
            }else if(nums[mid - 1] == nums[mid]){
                
                if(check_if_halves_are_even){
                    right = mid - 2;
                }else{
                    left = mid + 1;
                }
                
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
    
}