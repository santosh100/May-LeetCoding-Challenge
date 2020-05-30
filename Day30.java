/*
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        // Approach -  Used priority queue k smallest number approach (time-consuming but accepted)
        int ans[][] = new int[K][2];
        for(int i=0; i<K; i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
                        
        for(int i=K; i<points.length; i++){      
            
            int max = 0;
            int maxValue = 0;
            int newValue = 0;
            for(int j=1; j<K; j++){
                maxValue = ans[max][0]*ans[max][0] + ans[max][1]*ans[max][1];
                newValue = ans[j][0]*ans[j][0] + ans[j][1]*ans[j][1];
                if(newValue > maxValue){
                    max = j;
                }
            }
            
            maxValue = Math.abs(ans[max][0]*ans[max][0] + ans[max][1]*ans[max][1]);
            newValue = Math.abs(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            
            if(newValue < maxValue){
                ans[max][0] = points[i][0];      
                ans[max][1] = points[i][1];               
            }
        }
        return ans;
    }
}
*/

//Better solution by leetcode
//Time Complexity O(NlogN)
//Space Complexity O(N)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

