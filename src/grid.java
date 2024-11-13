public class grid {
    private int[][] grid = new int[3][3];

    public grid() {
        initgrid();
    }
    public void initgrid(){
        for (int row = 0; row<3; row++){
            for (int col = 0; col<3; col++){
                grid[row][col] = 0;

            }
        }


    }

    public int getCell(int row, int col) {
        return grid[row][col];
    }


    public int[] getRow(int row) {
        int [] row_return = {getCell(row, 0), getCell(row, 1), getCell(row, 2)};
        return row_return;
    }

    public int [] getCol (int col){
        int [] col_return = {getCell(0, col), getCell(1, col), getCell(2, col)};
        return col_return;

    }

    public void setCell(int row, int col, int value) {
        grid[row][col] = value;
    }


    public void affichGrid(){
        for ( int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean oneMove(int row, int col, int num_player){
        if (grid[row][col] == 0) {
            grid[row][col] = num_player;
            return true;
        }
        return false;
    }

    public  int victory(int[] row, int nb_pions_aligned){
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<3; i++){
            if(row[i] == 1){
                count1 = count1 + 1;
                count2 = 0;
                if (count1 == nb_pions_aligned){
                    return 1;
                }
            }
            else if (row[i] == 2) {
                count1 = 0;
                count2 = count2 + 1;
                if (count2 == nb_pions_aligned){
                    return 2;
                }
            }

            else{
                count1 = 0;
                count2 = 0;
            }
        }
    
        return 0;
        
    }

    public int [] getDiag1(){
        int [] row_return = {0, 0, 0};
        for (int i=0; i<3; i++){
             row_return[i] = getCell(i,i);
        }
        return row_return;
    }

    public int [] getDiag2(){
        int [] row_return = {0, 0, 0};
        for (int i=0; i<3; i++){
             row_return[i] = getCell(i,2-i);
        }
        return row_return;
    }




    public int victorydiag(int nb_pions_aligned){
        int [] diag1 = getDiag1();
        int [] diag2 = getDiag2();
        if (victory(diag1,3) == 1 | victory(diag2,3) == 1){
            return 1;
        }
        else if (victory(diag1,3) == 2 | victory(diag2,3) == 2){
            return 2;
        }
        else{
            return 0;
        }

    }

    public int victoryLine(int row){
        return victory(getRow(row), 3);
    }

    public int victoryCol(int col){
        return victory(getCol(col), 3);
    }




}
    



