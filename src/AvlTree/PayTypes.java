package AvlTree;

public class PayTypes {
    public int paytypes(int[] coinsAmt, int price){
        int[] coinValue = new int[]{1,5,10,20,50,100};
        int m = coinValue.length - 1; //货币种类数
        return paytypes2(coinsAmt, price, m, coinValue);
    }
   /**
    * 辅助递归
    */

    public int paytypes2(int[] coinsAmt, int price, int m, int[] coinValue){
        int s = 0;
        if (price == 0){
            return 1;
        }
        if (price < 0){
            return 0;
        }
        if (m < 0){
            return 0;
        }
        for (int i = 0; i <= coinsAmt[m]; i++){
            s = s + paytypes2(coinsAmt, price - i * coinValue[m], m-1, coinValue);
        }
        return s;
    }
}
