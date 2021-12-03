package competitive.singhankit;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Given a list of number pairs, List all symmetric pairs
 * Ex - [{1,3},{5,7},{8,9},{3,1},{7,5},{9,9},{20,1}]
 * O/p - [{1,3},{7,5}]
 *
 * @author _singhankit
 */
public class Symmetric {


    public static void main(String[] args) {
        findPair(new int[][]{{1, 3}, {5, 7}, {8, 9}, {3, 1}, {7, 5}, {9, 9}, {20, 1},{9,9}});
    }


    public static void findPair(int[][] arr) {
        Map<Storage, Integer> map = new HashMap<>();
       List<Storage> sList= Arrays.stream(arr).map(e ->  new Storage(e[0], e[1])).collect(Collectors.toList());
       sList.forEach(e->{
           if(map.get(e)==null)
               map.put(e,1);
           else
               map.put(e,map.get(e)+1);
       });

       for(Map.Entry e:map.entrySet()){
           if((Integer)e.getValue()>1)
               System.out.println(e.getKey());
       }
    }


    private static class Storage {
        private int i;
        private int j;

        public Storage(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Storage storage = (Storage) o;
            return (i == storage.i && j == storage.j) || (i == storage.j && j == storage.i);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "{" +
                           "i=" + i +
                           ", j=" + j +
                           '}';
        }
    }
}

