package com.shams.graphs;

import static com.shams.commons.UtilityHelper.getNeighbours;
import com.shams.commons.UtilityHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
  static boolean[] visited;

  public static void main(String[] args) {
    int[][] a = {
        {0, 1, 1, 0, 0, 0},
        {1, 0, 0, 1, 1, 0},
        {1, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 1, 1},
        {0, 1, 1, 1, 0, 1},
        {0, 0, 0, 1, 1, 0}
    };
    visited = new boolean[a[0].length];
    bfs(0, a);
  }

  private static void bfs(int s, int[][] a) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = true;
    System.out.print( s + " ");
    while(!q.isEmpty()) {
      s = q.poll();
      List<Integer> neighbours = getNeighbours(s, a);
      for(Integer u : neighbours) {
        if(!visited[u]) {
          q.add(u);
          visited[u] = true;
          System.out.print(u + " ");
        }
      }
    }
  }
}
