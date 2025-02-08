class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

        for(int i = 0; i<numCourses ; i++)
        {
            ls.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<prerequisites.length; i++)
        {
            ls.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int inorder[] = new int[numCourses];


        for(int i = 0; i<numCourses; i++)
        {
            for(int it : ls.get(i))
            {
                inorder[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i = 0; i<numCourses; i++)
        {
            if(inorder[i] == 0)
            {
                q.add(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty())
        {
            int node = q.remove();

            cnt++;

            for(int it : ls.get(node))
            {
                inorder[it]--;

                if(inorder[it] == 0)
                {
                    q.add(it);
                }
            }
        }

        if(cnt == numCourses)
        {
            return true;
        }

        return false;
    }
}