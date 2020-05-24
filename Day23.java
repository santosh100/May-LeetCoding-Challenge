import java.util.*;
class Element{
    int start;
    int end;
    Element(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    
    
    public int[][] intervalIntersection(int[][] A, int[][] B) {
       
       ArrayList<Element> list = new ArrayList<>(); 
        int i=0; 
        int j=0;        
        while(i<A.length && j<B.length){
            int start1 = A[i][0];
            int end1 = A[i][1];
            int start2 = B[j][0];
            int end2 = B[j][1];
                        
            int ansStart = Math.max(start1, start2);
            int ansEnd = Math.min(end1, end2);
            if(ansStart <= ansEnd)
                list.add(new Element(ansStart, ansEnd));
            
            if(end1>=end2){
                j++;
            }else{
                i++;
            }          
        }
        
        int arr[][] = new int[list.size()][2];
        for(i=0; i<list.size(); i++){
            Element e = list.get(i);
            arr[i][0] = e.start;
            arr[i][1] = e.end;
        }
        return arr;
    
    
    // Solution from LeetCode
    /*   
    List<int[]> ans = new ArrayList();
    int i = 0, j = 0;

    while (i < A.length && j < B.length) {
      // Let's check if A[i] intersects B[j].
      // lo - the startpoint of the intersection
      // hi - the endpoint of the intersection
      int lo = Math.max(A[i][0], B[j][0]);
      int hi = Math.min(A[i][1], B[j][1]);
      if (lo <= hi)
        ans.add(new int[]{lo, hi});

      // Remove the interval with the smallest endpoint
      if (A[i][1] < B[j][1])
        i++;
      else
        j++;
    }

    return ans.toArray(new int[ans.size()][]);
    */
        
  }
    
}