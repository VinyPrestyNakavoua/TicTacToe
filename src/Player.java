import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name, String symbol) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public int askRow(){
        Scanner input = new Scanner(System.in);
        int row  = input.nextInt();
        input.close();
        return row;
    }

    public int askCol(){
        Scanner input = new Scanner(System.in);
        int col  = input.nextInt();
        input.close();
        return col;
    }
}
