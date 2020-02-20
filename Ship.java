import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ship{

    private int lenght;
    private boolean horizontal;
    private int startingX;
    private int startingY;
    private ArrayList<ArrayList<Integer>> shipLocation;

    public Ship(int lenght, Boolean horizontal, int startingX, int startingY){
  
            this.shipLocation = createShip(lenght,horizontal,startingX,startingY);
    }

    public ArrayList<ArrayList<Integer>> createShip(int lenght, Boolean horizontal, int startingX, int startingY){
        ArrayList<ArrayList<Integer>> shipLocation = new ArrayList<>();
        if (startingX+lenght<=10) {
        for(int i =0; i < lenght; i++){
            ArrayList<Integer> shipCoordinates = new ArrayList<>();
            if (horizontal){
                
                shipCoordinates.add(startingX);
                shipCoordinates.add(startingY);
                shipLocation.add(shipCoordinates);
                startingX++;
                
            }else {
                shipCoordinates.add(startingX);
                shipCoordinates.add(startingY);
                shipLocation.add(shipCoordinates);
                startingY++;
                
            }}}
            else {
                System.out.println("Incorrect coordinates - the ship won't fit in");
            }
    

        return shipLocation;
    }

    public ArrayList<ArrayList<Integer>> getShipLocation(){
        return shipLocation;
    }

}