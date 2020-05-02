import java.util.HashMap;
class Solution {

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);
            }
        }     
        int ans = 0;
        for(int i=0; i<J.length(); i++){
            char c = J.charAt(i);
            if(hm.containsKey(c)){
                ans += hm.get(c);
            }
        }
        return ans;
    }
}