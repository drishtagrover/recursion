class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> curr= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        recur(candidates, target,0,curr, res);
        return res;
    }
    public void recur(int[] candidates, int target,int idx, ArrayList<  Integer> curr, List<List<Integer>> res){

        //basecase

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if((i==idx || candidates[i-1]!=candidates[i]) && candidates[i]<=target){
                curr.add(candidates[i]);
                recur(candidates,target-candidates[i],i+1,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
}
