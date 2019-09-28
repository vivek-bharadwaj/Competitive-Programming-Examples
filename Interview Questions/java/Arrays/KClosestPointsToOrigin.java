/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
         // O(NlogN) solution
        Arrays.sort(points, (x1, x2) -> (x1[0] * x1[0] + x1[1] * x1[1] - x2[0] * x2[0] - x2[1] * x2[1]));
        return Arrays.copyOfRange(points, 0, K);
    }

   public int[][] kClosest2(int[][] points, int K) {
    // O(NlogK) solution
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((x1, x2) -> (x2[0] * x2[0] + x2[1] * x2[1] - x1[0] * x1[0] - x1[1] * x1[1]));
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] ans = new int[K][2];
        while (K > 0) {
            ans[--K] = heap.poll();
        }
        return ans;
    } 
}