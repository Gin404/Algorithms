package Leetcode;

import Leetcode.LinkedListCyc.LinkedListCycle;
import Leetcode.LinkedListCyc.ListNode;
import Leetcode.Merge2List.Add2Nums;
import Leetcode.Merge2List.MergeTwoLists;
import Leetcode.RemoveDplcFromSLL.RemoveDp;
import Leetcode.SameTr.MinDepthofBST;
import Leetcode.SameTr.PathSum;
import Leetcode.SameTr.SortedArry2BST;
import Leetcode.SameTr.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetTest {
    @Test
    public void testTwoSum(){
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }

    @Test
    public void testReverseInt(){
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(-2147483648));
        System.out.println(reverseInt.reverse(1563847412));

    }

    @Test
    public void testBinaryGap(){
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(6));
    }

    @Test
    public void testLemonade(){
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5,5,10}));
        System.out.println(lemonadeChange.lemonadeChange(new int[]{10,10}));
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5,5,10,10,20}));
    }

    @Test
    public void testBuddyString(){
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.buddyStrings("abc", "acb"));
    }

    @Test
    public void testLinkedCycle(){
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        ListNode F = new ListNode(6);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = C;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycleQk(A));

    }

    @Test
    public void testRmvDplc(){
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1}));
    }

    @Test
    public void testLgCP(){
        LgestComPref lgestComPref = new LgestComPref();
        System.out.println(lgestComPref.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lgestComPref.longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }

    @Test
    public void testMerge2Lst(){
        Leetcode.Merge2List.ListNode A = new Leetcode.Merge2List.ListNode(1);
        Leetcode.Merge2List.ListNode B = new Leetcode.Merge2List.ListNode(2);
        Leetcode.Merge2List.ListNode C = new Leetcode.Merge2List.ListNode(3);

        Leetcode.Merge2List.ListNode D = new Leetcode.Merge2List.ListNode(1);
        Leetcode.Merge2List.ListNode E = new Leetcode.Merge2List.ListNode(3);
        Leetcode.Merge2List.ListNode F = new Leetcode.Merge2List.ListNode(4);

        A.next = B;
        B.next = C;

        D.next = E;
        E.next = F;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(A, D);
    }

    @Test
    public void testRmEle(){
        RemoveEle removeEle = new RemoveEle();
        System.out.println(removeEle.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeEle.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeEle.removeElement(new int[]{3,3}, 3));
        System.out.println(removeEle.removeElement(new int[]{2,3}, 3));
        System.out.println(removeEle.removeElement(new int[]{3,2}, 3));
    }

    @Test
    public void testStrStr(){
        ImplStrStr implStrStr = new ImplStrStr();
        System.out.println(implStrStr.strStr("hello", "ll"));
        System.out.println(implStrStr.strStr("aaaaa", "bba"));
    }

    @Test
    public void testCAS(){
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }
    @Test
    public void testMSA(){
        MaxSubArry maxSubArry = new MaxSubArry();
        System.out.println(maxSubArry.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void testPlusOne(){
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9,9})));
    }

    @Test
    public void testAddBin(){
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1011", "1010"));
    }

    @Test
    public void testRmvDp(){
        Leetcode.RemoveDplcFromSLL.ListNode a = new Leetcode.RemoveDplcFromSLL.ListNode(1);
        Leetcode.RemoveDplcFromSLL.ListNode b = new Leetcode.RemoveDplcFromSLL.ListNode(1);
        Leetcode.RemoveDplcFromSLL.ListNode c = new Leetcode.RemoveDplcFromSLL.ListNode(2);
        Leetcode.RemoveDplcFromSLL.ListNode d = new Leetcode.RemoveDplcFromSLL.ListNode(3);
        Leetcode.RemoveDplcFromSLL.ListNode e = new Leetcode.RemoveDplcFromSLL.ListNode(4);
        Leetcode.RemoveDplcFromSLL.ListNode f = new Leetcode.RemoveDplcFromSLL.ListNode(4);

        RemoveDp removeDp = new RemoveDp();
        System.out.println(removeDp.deleteDuplicates(a));
    }

    @Test
    public void testSortedArry2BST(){
        SortedArry2BST sortedArry2BST = new SortedArry2BST();
        sortedArry2BST.sortedArrayToBST(new int[]{1,2,3,4,5});
    }

    @Test
    public void testMinDepthofBST(){
        MinDepthofBST minDepthofBST = new MinDepthofBST();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        //a.right = c;
        //b.left = d;
        //b.right = e;
        //c.left = f;
        //c.right = g;

        System.out.println(minDepthofBST.minDepth(a));
    }

    @Test
    public void testHasSum(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(a, 7));
    }

    @Test
    public void testPascalTria(){
        PascalTria pascalTria = new PascalTria();
        System.out.println(pascalTria.generate(2).toString());

    }

    @Test
    public void testProfit(){
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfit(new int[]{5,6,6,5,4,1,9,2,4,5}));
    }

    @Test
    public void testStock2(){
        BuyAndSellStk2 buyAndSellStk2 = new BuyAndSellStk2();
        buyAndSellStk2.maxProfit(new int[]{7,1,5,3,6,4});
    }

    @Test
    public void testPalin(){
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testAdd2Num(){
        Leetcode.Merge2List.ListNode A = new Leetcode.Merge2List.ListNode(0);


        Leetcode.Merge2List.ListNode E = new Leetcode.Merge2List.ListNode(1);
        Leetcode.Merge2List.ListNode F = new Leetcode.Merge2List.ListNode(8);


        E.next = F;


        Add2Nums add2Nums = new Add2Nums();
        add2Nums.addTwoNumbers(A, E);
    }

}
