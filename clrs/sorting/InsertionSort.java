import java.util.ArrayList;

public class InsertionSort {
    public static ArrayList<Integer> sortIncreasing(ArrayList<Integer> list) {
        var i = 0;
        var j = 0;

        for (i = 2; i < list.size(); i++) {
            var current = list.get(i);
            j = i - 1;
            while (j > 0 && list.get(j) > current) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j, current);
        }

        return list;
    }
}