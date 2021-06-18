// package questions;

// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;

// public class TugOfWar {

//     /**
//      * Very Bad solution
//      */

//     static int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
//     static int[] arr1 = new int[arr.length];
//     static int minSum = Integer.MAX_VALUE;
    
//     public static int playBF(int index, boolean[] visited) {
//         if (index == arr.length) {
//             int sum1 = 0;
//             int sum2 = 0;
            
//             for (int i = 0; i < index / 2; i++) {
//                 sum1 += arr1[i];
//             }
//             for (int j = index / 2; j < index; j++) {
//                 sum2 += arr1[j];
//             }
//             if (Math.abs(sum1 - sum2) < minSum) {
//                 minSum = Math.abs(sum1 - sum2);
//                 for (int ele : arr1)
//                 System.out.print(ele + " ");
//                 System.out.println();
//             }
//             return 1;
//         }
        
//         int count = 0;
        
//         for (int i = 0; i < arr.length; i++) {
//             if (visited[i] == false) {
//                 visited[i] = true;
//                 arr1[index] = arr[i];
//                 count += playBF(index + 1, visited);
//                 visited[i] = false;
//             }
//         }
//         return count;
//     }
    
//     static ArrayList<Integer> ques = new ArrayList<>(Arrays.asList(23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4));

//     static int minNumSum = Integer.MAX_VALUE;

//     public static int playSmart(ArrayList<Integer> ques, ArrayList<Integer> list1, ArrayList<Integer> list2) {

//         if (list1.size() + list2.size() == ques.size()) {
//             int sum1 = 0;
//             int sum2 = 0;
//             for (int ele: list1) {
//                 sum1 += ele;
//             }
//             for (int ele: list2) {
//                 sum2 += ele;
//             }
//             if (Math.abs(sum1 - sum2) < minNumSum)
//                 // minNumSum = 
//             return 1;
//         }

//     }

//     public static void main(String[] args) {
//         System.out.println(playSmart(ques, 0));
//     }
// }