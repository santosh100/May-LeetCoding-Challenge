class Solution {
    
    private boolean getColor(List<List<Integer>> graph, int[] colorArr, int color, int node) {
		if (colorArr[node] != 0) return colorArr[node] == color;
		colorArr[node] = color;
		for (int x : graph.get(node)) {
			if (!getColor(graph, colorArr, -color, x)) return false;
		}
		return true;
    }
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			graph.add(new ArrayList<Integer>());
		for(int[] dis : dislikes){
			graph.get(dis[0]).add(dis[1]);
			graph.get(dis[1]).add(dis[0]);
		}
		int[] colorArr = new int[N+1];
		for(int i = 1; i <= N; i++){
			if(colorArr[i] == 0 && !getColor(graph, colorArr, 1, i)){
				return false;
			}
		}
		return true;
    }
    
    
}