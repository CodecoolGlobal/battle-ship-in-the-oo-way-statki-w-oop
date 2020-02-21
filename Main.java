class Main{
    public static void main(String[] args) {
        Ocean ocean1 = new Ocean();
        Player player1 = new Player(ocean1);
        ocean1.display();
        player1.addShipToUser(ocean1);
        player1.displayShips();
        while (true){
            player1.userShot();
            ocean1.isHit(player1.getUserShot(), player1.getListOfUserShips());
            ocean1.display();
            player1.checkIfWin(player1.getListOfUserShips());
            player1.displayShips();
        }
    }
}