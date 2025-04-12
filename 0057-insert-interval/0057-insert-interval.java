import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Left part (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Overlapping part
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval); // merged interval

        // Right part (no overlap)
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][] manually
        int[][] result = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            result[j][0] = ans.get(j)[0];
            result[j][1] = ans.get(j)[1];
        }

        return result;
    }
}
