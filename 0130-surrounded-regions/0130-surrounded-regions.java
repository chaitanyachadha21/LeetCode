class Solution {

    public void dfs(int row , int col , int visited[][] , char board[][] , int n , int m)
    {
        visited[row][col] = 1;

        int dirX[] = new int[]{0,0,1,-1};
        int dirY[] = new int[]{-1,1,0,0};

        for(int i = 0; i<4; i++)
        {
            int new_row = row + dirX[i];
            int new_col = col + dirY[i];

            if(new_row >=0 && new_row<n && new_col>=0 && new_col<m && visited[new_row][new_col] == 0 && board[new_row][new_col] == 'O')
            {
                dfs(new_row , new_col , visited , board , n , m);
            }
        }
    }

    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        int visited[][] = new int[n][m];


        for(int i = 0; i<m; i++)
        {
            // first row
            if(visited[0][i] == 0 && board[0][i] == 'O')
            {
                dfs(0 , i , visited , board , n , m);
            }

            // last row
            if(visited[n-1][i] == 0 && board[n-1][i] == 'O')
            {
                dfs(n-1 , i , visited , board , n , m);
            }

            
        }

        for(int i = 0; i<n; i++)
        {
            // first col
            if(visited[i][0] == 0 && board[i][0] == 'O')
            {
                dfs(i , 0 , visited , board , n , m);
            }

            // last col
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O')
            {
                dfs(i , m-1 , visited , board , n , m);
            }
        }

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(visited[i][j] == 0 && board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }

        
    }
}