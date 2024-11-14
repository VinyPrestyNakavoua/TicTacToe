import java.util.Random;
public class Ai {
    private Random random = new Random();

    public int [] playComp(int [][] grid){
        int row = aiRow();
        int col = aiCol();
        while (!isCellEmpty(grid, row, col)) {
            row = aiRow();
            col = aiCol();
        }
        return new int [] {row, col};
    }

    public int aiCol(){
        return random.nextInt(3);
    }

    public int aiRow(){
        return random.nextInt(3); 
    }

    private boolean isCellEmpty(int [][] grid, int row, int col) {
        if (grid[row][col] == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
