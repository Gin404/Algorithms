package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTria {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            List<Integer> a = new ArrayList<>();
            a.add(1);
            result.add(a);
        }

        if (numRows > 1){
            List<Integer> b = new ArrayList<>();
            b.add(1);
            b.add(1);
            result.add(b);
        }

        for (int i = 2; i< numRows; i++){
            int[] arry = new int[i+1];

            arry[0] = 1;
            arry[i] = 1;
            for (int j = 1; j < i/2+1; j++){
                arry[j] = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                arry[i-j] = arry[j];
            }

            List<Integer> list = new ArrayList<>();
            for (int g = 0; g < arry.length; g++){
                list.add(arry[g]);
            }

            result.add(list);

        }
        return result;
    }
}
