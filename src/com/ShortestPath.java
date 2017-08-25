package com;

public class ShortestPath {
	// A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=9;
    int minDistance(int dist[], Boolean sptSet[]){
    	int min = Integer.MAX_VALUE, min_index = -1;
    	
    	for(int v = 0; v < V; v++ )
    		if(sptSet[v] == false && dist[v] <= min){
    			min = dist[v];
    			min_index = v;
    		}
    	return min_index;
    }
    
    void printSolution(int dist[], int n){
    	System.out.println("Vertex distance from source");
    	for(int i = 0; i < V; i++)
    		System.out.println(i+ " \t " +dist[i]);
    }
    
    void dijkstra(int graph[][], int source){
    	int dist[] = new int[V];
    	Boolean sptSet[] = new Boolean[V];
    	
    	for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
    	
    	dist[source] = 0;
    	
    	for(int count=0; count < V-1; count++){
    		int u = minDistance(dist, sptSet);
    		
    		sptSet[u] = true;
    		
    		for(int v = 0; v < V; v++)
    			if(!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
    				dist[v] = dist[u] + graph[u][v];
    	}
    	printSolution(dist, V);
    }
    
}
