import java.util.ArrayList;

class Solution {
    
    /*
    public boolean isAnagram(String s, String p, int si, int ei){        
        if(ei-si != p.length()){
            return false;
        }
        
        int arr[] = new int[26];
        for(int i=0; i<p.length(); i++){
            arr[s.charAt(si+i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        
        for(int i=0; i<26; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<=s.length()-p.length(); i++){
            
            if(isAnagram(s, p, i, i+p.length())){
                list.add(i);
            }
            
        }
        
        return list;
    }
    */
    
    
    // Optimal Solution
    
    public boolean check(int arr[]){
        for(int i=0; i<arr.length; i++)
            if(arr[i]!=0)
                return false;
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        
        int arr[] = new int[26];
        int p_len = p.length();
        
        for(int i=0; i<p_len; i++){
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        
        if(check(arr))
            list.add(0);        
        
        for(int i=p_len; i<s.length(); i++){        
            arr[s.charAt(i-p_len)-'a']--;
            arr[s.charAt(i)-'a']++;
            if(check(arr)){
                list.add((i-p_len)+1);
            }
        }
        return list;
    }
}