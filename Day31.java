class Solution {
    public int minDistance(String word1, String word2) {
        /* TLE
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();
        
        int ans = 0;
        if(word1.charAt(0) == word2.charAt(0)){
            ans = minDistance(word1.substring(1), word2.substring(1));
        }else{
            int a = 1 + minDistance(word1.substring(1), word2); //del
            int b = 1 + minDistance(word1, word2.substring(1)); //ins
            int c = 1 + minDistance(word1.substring(1), word2.substring(1)); //replace
            ans = Math.min(c, Math.min(a,b));
        }
        
        return ans;
        */
        
        int m = word1.length();
        int n = word2.length();
        int dp[][] =  new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=n; j++){
            dp[0][j] = j;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) != word2.charAt(j-1))
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}