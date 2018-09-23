package Leetcode;

public class BuyAndSellStk2 {
    public int maxProfit(int[] prices) {
        int flag = 0;
        int total = 0;
        int temp = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                flag=1;
            }else{
                flag=0;
            }
            if(flag==1){
                temp = prices[i]-prices[i-1]+temp;
            }
            if(flag==0||i==prices.length-1){
                total+=temp;
                temp=0;
            }
        }
        return total;

    }


}
