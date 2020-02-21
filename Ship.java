import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ship{

    // private int lenght;
    // private boolean horizontal;
    // private int startingX;
    // private int startingY;
    private ArrayList<ArrayList<Integer>> shipLocation =new ArrayList<>();
    private ArrayList<ArrayList<Integer>> tempLocation = new ArrayList<>();



    public Ship(int lenght, Boolean horizontal, int startingX, int startingY, Ocean ocean){
        this.shipLocation = createShip(lenght,horizontal,startingX,startingY, ocean);

    }

    public ArrayList<ArrayList<Integer>> createShip(int lenght, Boolean horizontal, int startingX, int startingY, Ocean ocean){

        if (startingX+lenght<=10) {
        for(int i =0; i < lenght; i++){
            ArrayList<Integer> tempCoordinates = new ArrayList<>();
            if (horizontal){
                // musi byc -1
                tempCoordinates.add(startingX - 1);
                tempCoordinates.add(startingY-1);
                tempLocation.add(tempCoordinates);
                startingX++;
                
            }else {
                tempCoordinates.add(startingX - 1);
                tempCoordinates.add(startingY - 1);
                tempLocation.add(tempCoordinates);
                startingY++;
                
            }}}
            else {
                System.out.println("Incorrect coordinates - the ship won't fit in");
            }
            checkIfPositionTaken(ocean.getTakenCoordinates(), ocean);
        return shipLocation;
    }

    public void checkIfPositionTaken(ArrayList<ArrayList<Integer>> board, Ocean ocean){
        if(board.isEmpty()){
            System.out.println("pusta");
            ocean.putTakenCoordinates(tempLocation);
            for (ArrayList<Integer> tempCoordinates : tempLocation){
                shipLocation.add(tempCoordinates);
            }

        }else{
            System.out.println("nie jest pusta");
            for(ArrayList<Integer> existingCoordinates : board){
                for(ArrayList<Integer> tempCoordinates : tempLocation){
                    if(existingCoordinates.equals(tempCoordinates)){
                        break;
                    }else{
                        shipLocation.add(tempCoordinates);
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getShipLocation(){
        return shipLocation;
    }

}