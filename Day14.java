class TrieNode{
    TrieNode arr[];
    boolean isEnd;
    public TrieNode(){
        this.arr = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    
    public TrieNode searchNode(String s){
        TrieNode temp = root;
        for(int i=0; i<s.length(); i++){           
            int index = s.charAt(i)-'a';
            if(temp.arr[index]!=null){
                temp = temp.arr[index];
            }else{
                return null;
            }
        }
 
        if(temp==root)
            return null;
 
        return temp;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(temp.arr[index] == null){
                TrieNode newNode = new TrieNode();
                temp.arr[index] = newNode;
                temp = newNode;
            }else{
                temp = temp.arr[index];
            }
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = searchNode(word);
        if(temp==null){
            return false;
        }else{
            if(temp.isEnd)
                return true;
        }
 
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = searchNode(prefix);
        if(temp==null){
            return false;
        }else{
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */