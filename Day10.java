class Solution {
    public int findJudge(int N, int[][] trust) {
        
        // My Approach using Adjacency list
        /*
        int matrix[][] = new int[N+1][N+1];
        for(int i=0; i<trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            matrix[a][b] = 1;
        }
        
        boolean flag = false;
        boolean f = false;
        int judge = -1;
        for(int i=1; i<=N; i++){
            int count = 0;
            f = false;
            for(int j=1; j<=N; j++){
                if(matrix[j][i] == 1)
                    count++;
                if(matrix[i][j] == 1){
                    f = true;
                }
            }
            if(count == N-1 && f == false){
                if(judge == -1){
                    flag = true;
                    judge = i;
                }else{                    
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            return judge;
        }else{
            return -1;
        }
        
        */
        
        
        
        // Optimal Approach (Hint: concept of in_degree and out_degree)
        
        int arr[] = new int[N+1];
        for(int i=0; i<trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            arr[a]--;
            arr[b]++;
        }
        
        for(int i=1; i<=N; i++){
            if(arr[i] == N-1){                
                return i;                
            }            
        }
        return -1;        
    }
}