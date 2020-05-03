import java.util.HashMap;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);;
            }
        }
        
        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(hm.containsKey(c)){
                int counts = hm.get(c);
                if(counts > 0){
                    hm.replace(c, counts-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}