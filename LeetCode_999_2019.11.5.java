package Demo06;
/*
在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
另外，车不能与其他友方（白色）象进入同一个方格。
返回车能够在一次移动中捕获到的卒的数量。
 */

class LeetCode_999 {
    public static int numRookCaptures(char[][] board) {

        int i = 0;
        int j = 0;
        for(int a = 0; a < board.length;a++){
            for(int b = 0;b < board[a].length;b++){
                if(board[a][b] == 'R'){
                    i = a;j = b;
                break;}
            }
        }
        System.out.println(i);
        System.out.println(j);
        int result = 0;
        int left = j-1;
        int right = j+1;
        int up = i-1;
        int down = i+1;
        System.out.println(result);
        while(left >= 0 && board[i][left] != 'B'){
            if(board[i][left] == 'p'){
                ++result;
                break;
            }
            left--;
        }
        while(right < board.length && board[i][right] != 'B'){
            if(board[i][right] == 'p'){
                result++;
                break;
            }
            right++;
        }
        while(up >= 0 && board[up][j] != 'B'){
            if(board[up][j] == 'p'){
                result++;
                break;}
            up--;
        }
        while(down < board.length && board[i][down] != 'B'){
            if(board[i][down] == 'p'){
                result++;
                break;}
            down++;
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] arr = {{'.','.','.'},
                        {'p','R','p'},
                        {'.','B','p'}
        };
        System.out.println(numRookCaptures(arr));


    }
}
/*
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".","R",".",".",".","p"],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
*/