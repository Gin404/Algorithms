package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        List<Integer> high = new ArrayList<>();
        List<Integer> low = new ArrayList<>();

        boolean trend = false;
        for (int i = 0; i < length; i++){
            if (i > 0){
                if (prices[i] > prices[i-1]){
                    trend = true;
                }else if (prices[i] < prices[i-1]){
                    trend = false;
                }
            }

            if (i+1 < length && prices[i+1] > prices[i]){
                if (low.isEmpty()){
                    low.add(prices[i]);
                }else {
                    if (trend == false){
                        low.add(prices[i]);
                    }
                }
            }

            if (!low.isEmpty() && trend == true){
                if (i == length-1){
                    high.add(prices[i]);
                }else {
                    if (prices[i+1] < prices[i]){
                        high.add(prices[i]);
                    }
                }
            }
        }

        if (low.size() == 0){
            return 0;
        }

        int profit = 0;
        for (int i=0; i<low.size(); i++){
            for (int j=i; j<high.size(); j++){
                profit = Math.max(high.get(j) - low.get(i), profit);
            }
        }

        return profit;
    }
}
