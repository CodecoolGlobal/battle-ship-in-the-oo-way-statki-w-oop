class Main{
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
        Player player1 = new Player();
        ocean.display();
        player1.addShipToUser();
        while (true){
            player1.shot();
            ocean.isHit(player1.getUserShot(), player1.getListOfUserShips());
            ocean.display();
            // player1.checkIfWin(player1.getListOfUserShips());
            player1.displayShips();
        }
    }
}