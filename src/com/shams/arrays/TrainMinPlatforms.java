/***
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * */

package com.shams.arrays;

import java.util.Arrays;

public class TrainMinPlatforms {

  /***
   * This is same as Meeting Rooms II - https://leetcode.com/problems/meeting-rooms-ii/
   * */
  public static void main(String[] args) {
//    int[] arr = {100, 140, 150, 200, 215};
//    int[] dep = {110, 300, 220, 230, 315};

    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = "
        + findPlatform(arr, dep, n));
  }

  static int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int platforms = 1, result = Integer.MIN_VALUE;
    int i = 1, j = 0;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        platforms++;
        i++;
      } else if (arr[i] > dep[j]) {
        platforms--;
        j++;
      }
      result = Math.max(result, platforms);
    }
    return result;
  }
}
