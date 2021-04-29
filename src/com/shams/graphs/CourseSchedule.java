/**
 * https://www.youtube.com/watch?v=kXy0ABd1vwo&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=9&ab_channel=TECHDOSE
 * https://leetcode.com/problems/course-schedule/submissions/
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
  public static void main(String[] args) {
    int[][] a = {
        {1, 0}
    };
    System.out.println(canFinish(2, a));
  }

  private static boolean canFinish(int numOfCourses, int[][] prerequisites) {
    List[] map = new List[numOfCourses+1];
    for(int i = 0; i <= numOfCourses; i++) {
      map[i] = new ArrayList<>();
    }
    for(int[] pr : prerequisites) {
      map[pr[0]].add(pr[1]);
    }
    int[] colours = new int[numOfCourses+1];
    for(int i = 0; i <= numOfCourses; i++) {
      if(colours[i] == 0) {
        if(isCycle(i, map, colours)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isCycle(int s, List[] map, int[] colours) {
    if(colours[s] == 2) return true;
    colours[s] = 2;
    List<Integer> neighbours = map[s];
    for(Integer n : neighbours) {
      if(colours[n] != 1) {
        if(isCycle(n, map, colours)) {
          return true;
        }
      }
    }
    colours[s] = 1;
    return false;
  }
  /***
   * public boolean canFinish(int numCourses, int[][] prerequisites) {
   *         if(numCourses == 1) return true;
   *
   *         Map<Integer, Integer> coloursMap = new HashMap<>();
   *         Map<Integer, List<Integer>> map = new HashMap<>();
   *         for(int[] pr : prerequisites) {
   *             if(!map.containsKey(pr[0])) {
   *                 map.put(pr[0], new ArrayList<>());
   *             }
   *             map.get(pr[0]).add(pr[1]);
   *             coloursMap.put(pr[0], 0);
   *         }
   *
   *         for(Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
   *             if(coloursMap.get(e.getKey()) == 0) {
   *                 if(isCycle(e.getKey(), map, coloursMap)) {
   *                     return false;
   *                 }
   *             }
   *         }
   *         return true;
   *     }
   *
   *     private boolean isCycle(int key, Map<Integer, List<Integer>> map, Map<Integer, Integer> colours) {
   *         if(colours.getOrDefault(key, -1) == 2) return true;
   *         colours.put(key, 2);
   *         List<Integer> neighbours = map.getOrDefault(key, new ArrayList<>());
   *         for(int n : neighbours) {
   *             if(colours.getOrDefault(n, -1) != 1) {
   *                 if(isCycle(n, map, colours)) {
   *                     return true;
   *                 }
   *             }
   *         }
   *         colours.put(key, 1);
   *         return false;
   *     }
   * */
}
