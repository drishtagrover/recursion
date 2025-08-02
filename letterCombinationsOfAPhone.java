class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] mapping = new String[]{
            "",     
            "",     
            "abc",  
            "def", 
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };
        recur(res,digits,0,new StringBuilder(),mapping);
        return res;
    }
    private void recur(List<String> res,String digits,int idx, StringBuilder curr,String[] mapping){
        if(idx==digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters = mapping[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c); 
            recur(res, digits, idx + 1, curr, mapping); 
            curr.deleteCharAt(curr.length() - 1); 
        }
    }
}
