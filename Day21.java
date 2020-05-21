class Solution {
    public int countSquares(int[][] matrix) {
        
        // APPROACH - 1
        // TIME: O(N^N)
        // SPACE: O(N^N)
        /*
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int count = 0;                               
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j];
                }else if(matrix[i][j] == 1){                    
                    int top = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                        
                    dp[i][j] = 1 + Math.min(top, Math.min(left, diagonal));                 
                }
                count += dp[i][j];      
                
            }            
        }        
        return count;
        */
        
        
        // APPROACH - 2
        // little faster than approach - 1
        // TIME: O(N^N)
        // SPACE: O(N^N)
        /*
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int count = 0;                               
        
        for(int i=0; i<m; i++){
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }
        for(int j=1; j<n; j++){
            dp[0][j] = matrix[0][j];
            count += dp[0][j];
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                
               if(matrix[i][j] == 1){                    
                    int top = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                        
                    dp[i][j] = 1 + Math.min(top, Math.min(left, diagonal));                 
                }
                count += dp[i][j];      
                
            }            
        }        
        return count;
        */
              
        
        // APPROACH - 3
        // little than APPROACH - 1 and 2
        // TIME: O(N^N)
        // SPACE: O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;                               
        
        for(int i=0; i<m; i++){
            count += matrix[i][0];            
        }
        for(int j=1; j<n; j++){
            count += matrix[0][j];           
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                
               if(matrix[i][j] == 1){
                   matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                   count += matrix[i][j];
               }
            }            
        }        
        return count;
                             
    }
}