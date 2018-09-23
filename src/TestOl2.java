import java.util.*;

public class TestOl2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] strings = s.split(" ");
        int city = Integer.parseInt(strings[0]);
        int road = Integer.parseInt(strings[1]);
        System.out.println("c: "+city+"  r: "+road);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        while (true){
            String str = scan.nextLine();
            if (str.equals("")){
                break;
            }
            String[] strs = str.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            System.out.println("a: "+a+"  b: "+b);

            if (map.get(a) == null){
                Set<Integer> set = new HashSet<Integer>();
                set.add(b);
            }else {
                map.get(a).add(b);
            }
        }

        /*Set<Integer> setA = new HashSet<>();
        setA.add(2);
        map.put(1, setA);

        Set<Integer> setB = new HashSet<>();
        setB.add(3);
        setB.add(5);
        setB.add(6);
        map.put(2, setB);

        Set<Integer> setC = new HashSet<>();
        setC.add(5);
        map.put(3, setC);

        Set<Integer> setD = new HashSet<>();
        setD.add(3);
        map.put(4, setD);

        Set<Integer> setE = new HashSet<>();
        setE.add(2);
        setE.add(4);
        map.put(5, setE);

        Set<Integer> setF = new HashSet<>();
        setF.add(7);
        map.put(6, setF);

        Set<Integer> setG = new HashSet<>();
        map.put(7, setG);

        Set<Integer> des = destinations(new HashSet<Integer>(), map, 7);

        System.out.println(des.toString());*/

    }

    public static Set<Integer> destinations(Set<Integer> set, Map<Integer, Set<Integer>> map, Integer city){
        if (map == null){
            return set;
        }
        set.add(city);
        Set<Integer> neighbor = map.get(city);
        for (Integer i : neighbor){
            if (!set.contains(i)){
                set = destinations(set, map, i);
            }
        }
        return set;
    }

    //na%b=d, d
}
