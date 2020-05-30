class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
 
        // step 1: create adjlist and indegree map
        
        Map<Integer, Integer> IndegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
         
        for (int i = 0; i < numCourses; i++) {
            IndegreeMap.put(i, 0);
            adjList.put(i, new ArrayList<>());
        }
 
        for (int[] prerequisite : prerequisites) {           
            IndegreeMap.put(prerequisite[1], IndegreeMap.get(prerequisite[1])+1);
        }
 
        for (int[] prerequisite : prerequisites) {
            List<Integer> neighbors = adjList.get(prerequisite[0]);
            neighbors.add(prerequisite[1]);
            adjList.put(prerequisite[0], neighbors);
        }
 
        // step 2: get all nodes with indegree 0 and put into the queuue        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (Integer key : IndegreeMap.keySet()) {
            int indegree = IndegreeMap.get(key);
            if (indegree == 0) {
                queue.offer(key);
                count++;
            }
        }
 
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int neighbor : adjList.get(curNode)) {
                int indegree = IndegreeMap.get(neighbor);
                indegree -= 1;
                IndegreeMap.put(neighbor, indegree);
 
                if (indegree == 0) {
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
 
        return count == numCourses;
    }
}