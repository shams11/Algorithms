/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * https://www.youtube.com/watch?v=-pO5TuSL-Ks
 */

package com.shams.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  public static void main(String[] args) {

    String[] s = {"i", "love", "leetcode", "i", "love", "leetcode", "leetcode", "shams", "shams", "shams", "shams"};
    int k = 2;
    List<String> result = topKFrequent1(s, k);
    System.out.println(result);
  }

  private static List<String> topKFrequent1(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) -> {
      int frequency1 = map.get(word1);
      int frequency2 = map.get(word2);
      if (frequency1 == frequency2) {
        // if frequency is same, then order words alphabetically
        return word2.compareTo(word1);
      }
      // else order by frequency
      return frequency1 - frequency2;
    });
    for (Map.Entry<String, Integer> e : map.entrySet()) {
      pq.add(e.getKey());
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    Collections.reverse(result);
    return result;
  }
}