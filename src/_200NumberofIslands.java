import java.util.Arrays;

public class _200NumberofIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid ,int x, int y){
        if (grid[x][y]=='1'){
            grid[x][y]='0';
        }
        if (x-1>=0 &&  grid[x-1][y]=='1' )
            dfs(grid,x-1,y);
        if (x+1<grid.length &&  grid[x+1][y]=='1' )
            dfs(grid,x+1,y);
        if (y-1>=0 &&  grid[x][y-1]=='1' )
            dfs(grid,x,y-1);
        if (y+1<grid[0].length &&  grid[x][y+1]=='1' )
            dfs(grid,x,y+1);

    }

}
