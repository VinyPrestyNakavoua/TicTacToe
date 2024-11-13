
public class App {
    public static void main(String[] args) throws Exception {
        grid grid = new grid();
        grid.initgrid();
        grid.affichGrid();
        for (int i=0; i<3; i++){
            grid.setCell(1, i, 1);
        }

        System.out.println(grid.victory(grid.getRow(1),3));
        grid.affichGrid();
        System.out.println(grid.victoryLine(1));
        for (int i=0; i<3; i++){
            grid.setCell(i, 2, 2);
        }
        grid.affichGrid();
        System.out.println(grid.victoryCol(2));
        grid.setCell(0, 0, 1);
        System.out.println(grid.victorydiag(3));
        grid.affichGrid();


    }
}
