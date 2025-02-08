import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            ls.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            ls.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int inorder[] = new int[numCourses];

        // Count in-degrees
        for (int i = 0; i < numCourses; i++) {
            for (int it : ls.get(i)) {
                inorder[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with 0 in-degree
        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[numCourses];
        int index = 0;

        // Perform Kahn's algorithm for topological sorting
        while (!q.isEmpty()) {
            int node = q.remove();
            topo[index++] = node;

            for (int it : ls.get(node)) {
                inorder[it]--;
                if (inorder[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check if all courses were processed
        if (index == numCourses) {
            return topo;
        }
        return new int[]{};
    }
}
