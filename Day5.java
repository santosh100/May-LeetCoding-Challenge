import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
            // char,    counts      
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);                
            }
        }
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(hm.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}