class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> curr= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        recur(k, n,1,curr, res);
        return res;
    }
    public void recur(int k, int n,int elt, ArrayList<  Integer> curr, List<List<Integer>> res){

        //basecase
        if(curr.size()>=k){
            if(n==0){
               res.add(new ArrayList<>(curr));
            }
            return;
        }
        
        for(int i=elt;i<=9;i++){
            if(i<=n){
                curr.add(i);
                recur(k,n-i,i+1,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
}
