class Solution {

    public void Solve(List<List<Integer>>ans , List<Integer>ds , int target ,  int start , int nums[])
    {
        // base case
        if(target == 0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (target < 0)
        {
            return;
        }

        

        for(int i = start ; i<nums.length; i++)
        {
           //if(i > start && nums[i] == nums[i-1]) continue;

           //if(nums[i] > target) break;

                
                
                ds.add(nums[i]);

                Solve(ans , ds , target - nums[i] , i , nums);

                ds.remove(ds.size()-1);
            
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>ds = new ArrayList<>();
        Arrays.sort(candidates);

        Solve(ans , ds , target ,  0 , candidates);

        return ans;
    }
}