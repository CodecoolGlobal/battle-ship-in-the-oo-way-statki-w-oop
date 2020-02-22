import java.util.ArrayList;

class BattleShip {
    private Ocean ocean1 = new Ocean();
    private Player player1 = new Player(ocean1);

    private Ocean ocean2 = new Ocean();
    private Player player2 = new Player(ocean2);

    public void display(ArrayList <ArrayList<Square>> board){
    
        int indexOfRow = 1;
        String topLetters ="    A  B  C  D  E  F  G  H  I  J ";
        System.out.println(topLetters);
        System.out.println();
    
        for(ArrayList<Square> row : board){
            if(indexOfRow <10){
                System.out.print(indexOfRow + "  ");
            }else{
                System.out.print(indexOfRow + " ");
            }
            for(Square square : row){
                System.out.print(square.toString());
            }
            indexOfRow++;
            System.out.println();
        }
    }

    Integer player = 1;

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public void game(){
        System.out.println("Creator of ships for player 1.");
        player1.addShipToUser(ocean1);
        System.out.println("Creator of ships for player 2.");
        player2.addShipToUser(ocean2);
        while(true){
            System.out.println("Player 1 shot: ");
            player1.userShot();
            ocean2.isHit(player1.getUserShot(), player2.getListOfUserShips());
            display(ocean2.getBoard());
            player1.checkIfWin(player2.getListOfUserShips());
            System.out.println("Player 2 shot: ");
            player2.userShot();
            ocean1.isHit(player2.getUserShot(), player1.getListOfUserShips());
            display(ocean1.getBoard());
            player2.checkIfWin(player1.getListOfUserShips());
        }
    }

    public static void main(String[] args) {
        BattleShip newGame = new BattleShip();
        newGame.game();
    }
}