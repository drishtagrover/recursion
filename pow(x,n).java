class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double smallPow = myPow(x,n/2);// myPow(x,n-1) bhi bhej sakte 
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        if(n%2==0){
            return smallPow* smallPow; // myPow(x,n-1)*n bhi aa sakta bus TC zyada hogi
        }
        return smallPow*smallPow*x;
    }
}
