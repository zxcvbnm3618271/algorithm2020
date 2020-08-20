package org.lanqiao.algo.elementary._07_dfs;
//https://leetcode-cn.com/problems/minesweeper/
public class 扫雷游戏 {
//    定义8个方向
    int[] dx ={-1,1,0,0,-1,1,-1,1};
    int[] dy={0,0,-1,1,-1,1,1,-1};

    public char[][] updateBoard(char[][] board,int[] click){
        int x = click[0],y=click[1];
//        若起点是雷,游戏结束
        if (board[x][y] == 'M'){
            board[x][y]='X';
        }else {
            dfs(board,x,y);
        }
        return board;
    }

    private void dfs(char[][] board,int i,int j){
//        判断空地i,j周围是否有雷,若有,则将该位置修改为雷数,终止该路径的搜索
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int x =i+dx[k];
            int y = j+dy[k];
            if (x<0 || x>=board.length || y<0||y>=board[0].length){
                continue;
            }
            if (board[x][y]=='M'){
                cnt++;
            }
        }
        if (cnt > 0){
            board[i][j] =(char)(cnt+'0');
            return;
        }
//        若空地(i,j)周围没有雷,则将该位置修改为B,向8邻域的空地继续搜索
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x=i+dx[k];
            int y=j+dy[k];
            if (x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!='E'){
                continue;
            }
            dfs(board,x,y);
        }
    }
}
