class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> curr=new ArrayList<>(); 
        Arrays.sort(nums);
        recur(nums,0,curr,res);
        return res;
    }
    private void recur(int[] nums, int start,List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            recur(nums,i+1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
