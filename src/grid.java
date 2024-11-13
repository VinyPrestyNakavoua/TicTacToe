public class grid {
    private String[][] grid = new String[3][3];

    public grid() {
        initgrid();
    }
    public void initgrid(){
        for (int row = 0; row<3; row++){
            for (int col = 0; col<3; col++){
                grid[row][col] = "-";

            }
        }


    }

    public void affichGrid(){
        for ( int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean onemove(int row, int col, String symbol ){
        if (grid[row][col] == "-") {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public  String victory(String[] row, int nb_pions_aligned){
        // the symbol x for the first player and o for the second one
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<3; i++){
            if(row[i] == "x"){
                count1 = count1 + 1;
                count2 = 0;
                if (count1 == nb_pions_aligned){
                    return "x";
                }
            }
            else if (row[i] == "o") {
                count1 = 0;
                count2 = count2 + 1;
                if (count2 == nb_pions_aligned){
                    return "o";
                }
            }

            else{
                count1 = 0;
                count2 = 0;
            }
        }
    
        return "-";
        
    }

    public String victorydiag(int nb_pions_aligned=3){
        if(grid[0])
    }



}
    



