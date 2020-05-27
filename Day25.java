class Solution {   
    public int maxUncrossedLines(int[] A, int[] B) {
        
        // LCS logic
        int arr[][] =  new int[A.length+1][B.length+1];
        for(int i=1; i<arr.length; i++){
            for(int j = 1; j<arr[0].length; j++){
                if(A[i-1] == B[j-1]){
                    arr[i][j] = 1 + arr[i-1][j-1];
                }else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[arr.length-1][arr[0].length-1];
    }
}