
public class App {
    public static void main(String[] args) throws Exception {
        grid grid = new grid();
        grid.initgrid();
        grid.affichGrid();
        for (int i=0; i<3; i++){
            grid[1][i] = "x";
        }

        System.out.println(victory(grid[1],nb_pions_aligned=3));
    }
}
