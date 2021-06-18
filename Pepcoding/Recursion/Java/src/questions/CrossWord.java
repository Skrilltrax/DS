// package questions;

// public class CrossWord {

//     static char[][] board = new char[10][10];

//     public static int placeHorizontal(int sr, int sc, String word) {
//         for (int i = 0; i < word.length(); i++) {
//             if (board[sr][sc + i] == '-') {
//                 board[sr][sc] = word.charAt(i);
//             }
//         }
//     }

//     public static unPlaceHorizontal() {
        
//     }

//     public static boolean canPlaceHorizontal(int sr, int sc, String word) {
//         if (sc + word.length() >= board[0].length)
//             return false;

//         if (sc == 0 && sc + board[sr][sc - 1] != '+')
//             return false;
        
//         if (sc != 0 && sc + word.length() < board[0].length - 1)
//             return false;

//         int i = 0;
//         for (; i < word.length(); i++) {
//             if (board[sr][sc + i] != '-' && board[sr][sc + i] != word.charAt(i))
//                 return false;
//         }
//         return true;
//     }

// }