class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> curr= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        recur(candidates, target,0,curr, res);
        return res;
    }
    public void recur(int[] candidates, int target,int idx, ArrayList<  Integer> curr, List<List<Integer>> res){

        //basecase

        if(idx==candidates.length){
            if(target==0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        //pick
        if(candidates[idx]<=target){
            curr.add(candidates[idx]);
            recur(candidates, target-candidates[idx],idx,curr, res);
            curr.remove(curr.size()-1);
        }
        //nopick
        recur(candidates, target,idx+1,curr, res);
    }
}
