class Solution {
        
    public boolean check(int arr[]){
        for(int i=0; i<arr.length; i++)
            if(arr[i]!=0)
                return false;
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {        
        
        // SAME ANS SUBMITTED [YESTERDAY ~ Day - 18]
        
        if(s2.length() < s1.length()){
            return false;
        }
        
        int arr[] = new int[26];
        int s1_len = s1.length();
        
        for(int i=0; i<s1_len; i++){
            arr[s2.charAt(i)-'a']++;
            arr[s1.charAt(i)-'a']--;
        }
        
        if(check(arr))
            return true;    
        
        for(int i=s1_len; i<s2.length(); i++){        
            arr[s2.charAt(i-s1_len)-'a']--;
            arr[s2.charAt(i)-'a']++;
            if(check(arr)){
                return true;
            }
        }
        return false;
    }
}