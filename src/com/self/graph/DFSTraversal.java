package com.self.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFSTraversal {
    private ArrayList<Integer> adjList[];
    private boolean[] visited;

    public void resetVisited() {
        visited = new boolean[visited.length];
    }

    DFSTraversal(int vSize) {
        adjList = new ArrayList[vSize];
        visited = new boolean[vSize];

        for (int i = 0; i < vSize; i++) {
            adjList[i] = new ArrayList();
        }
    }

    public void addEdge(int source, int dest) {
        adjList[source].add(dest);
    }

    public void DFS(int vertex) {
        DFS(vertex, adjList);
    }

    public void DFS(int vertex, ArrayList<Integer> edges[]) {
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for(int i = 0; i < edges[vertex].size(); i++) {
            var u = edges[vertex].get(i);
            if (!visited[u]) {
                DFS(u);
            }
        }
    }

    public boolean isConnected() {
        var visitedReverse = new boolean[visited.length];
        LinkedList<Integer> adjListReverse[] = new LinkedList[adjList.length];

        for (int i = 0; i < adjList.length; i++) {

        }

        return false;
    }

    public static void runSample() {
        var test = new DFSTraversal(5);

        test.addEdge(0,3);
        test.addEdge(0,1);
        test.addEdge(0,4);
        test.addEdge(1,2);
        test.addEdge(3,2);
//        test.addEdge(3,4);
//        test.addEdge(4,1);

        test.DFS(0);
        System.out.println();
        test.resetVisited();

        test.DFS(1);
        System.out.println();
        test.resetVisited();

        test.DFS(2);
        System.out.println();
        test.resetVisited();

        test.DFS(3);
        System.out.println();
        test.resetVisited();

        test.DFS(4);
        System.out.println();
        test.resetVisited();

        test.isConnected();
    }
}
