package com.self.graph;

import java.util.ArrayList;

public class GraphConnection {
    private final ArrayList<Integer>[] edges;
    private boolean[] visitedList;

    public void resetVisited() {
        visitedList = new boolean[visitedList.length];
    }

    GraphConnection(int vSize) {
        edges = new ArrayList[vSize];
        visitedList = new boolean[vSize];

        for (int i = 0; i < vSize; i++) {
            edges[i] = new ArrayList();
        }
    }

    public void addEdge(int source, int dest) {
        edges[source].add(dest);
    }

    public void DFS(int vertex) {
        DFS(vertex, edges, visitedList);
    }

    public void DFS(int vertex, ArrayList<Integer>[] edges, boolean[] visited) {
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for(int i = 0; i < edges[vertex].size(); i++) {
            var u = edges[vertex].get(i);
            if (!visited[u]) {
                DFS(u, edges, visited);
            }
        }
    }

    private boolean isAllVisited(boolean[] visited) {
        if (visited.length == 0) return false;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isConnected() {
        if (edges.length == 0) return false;

        var visitedReverse = new boolean[visitedList.length];
        ArrayList<Integer> edgeListReversed[] = new ArrayList[edges.length];

        for (int i = 0; i < edges.length; i++) {
            edgeListReversed[i] = new ArrayList();
        }

        // build reversed edge list
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].size(); j++) {
                var src = edges[i].get(j);
                edgeListReversed[src].add(i);
            }
        }

        System.out.print(" ...DFS on vertex 0: ");
        DFS(0, edges, visitedList);
        System.out.println();

        System.out.print(" ...DFS on vertex 0 (reversed): ");
        DFS(0, edgeListReversed, visitedReverse);
        System.out.println();

        for (int i =0; i < visitedList.length; i++) {
            if (visitedList[i] == false && visitedReverse[i] == false) {
                resetVisited();
                return false;
            }
        }

        resetVisited();
        return true;
    }

    public boolean isStronglyConnected() {
        if (edges.length == 0) return false;

        for (int i = 0; i < edges.length; i++) {
            System.out.print(" ...DFS on vertex " + i + ": ");
            DFS(i);
            System.out.println();
            if (!isAllVisited(visitedList)) {
                resetVisited();
                return false;
            }
            resetVisited();
        }
        return true;
    }

    public static void runSample() {
        var graph = new GraphConnection(5);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,2);

        System.out.println("Number of vertices: " + graph.visitedList.length + "\n");

        System.out.println("Checking if connected... ");
        var result = graph.isConnected();
        System.out.println(" --> connected: " + result);
        System.out.println("Checking if strongly connected... ");
        result = graph.isStronglyConnected();
        System.out.println(" --> strongly connected: " + result);

        System.out.println("\nAdding edges...\n");
        graph.addEdge(4,0);
        graph.addEdge(2,4);

        System.out.println("Checking if connected... ");
        result = graph.isConnected();
        System.out.println(" --> connected: " + result);
        System.out.println("Checking if strongly connected... ");
        result = graph.isStronglyConnected();
        System.out.println(" --> strongly connected: " + result);
    }
}
