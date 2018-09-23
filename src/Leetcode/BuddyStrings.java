package Leetcode;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() == B.length() && A.length() > 1){
            byte[] a = A.getBytes();
            byte[] b = B.getBytes();

            if (A.equals(B)){
                int[] count = new int[26];
                for (int i = 0; i < a.length; ++i)
                    count[a[i] - 'a']++;

                for (int c: count)
                    if (c > 1) return true;
                return false;
            }else {

                int diff = 0;
                byte[] diffa = new byte[2];
                byte[] diffb = new byte[2];

                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i]) {
                        if (diff < 2) {
                            diffa[diff] = a[i];
                            diffb[diff] = b[i];
                        }
                        diff++;
                    }

                    if (diff == 3){
                        return false;
                    }
                }


                if (diff == 2 && diffa[0] == diffb[1] && diffa[1] == diffb[0]) {
                    return true;
                } else {
                    return false;
                }
            }
        }else {
            return false;
        }
    }
}
