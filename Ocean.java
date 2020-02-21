import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Ocean{

private ArrayList<ArrayList<Integer>> takenCoordinates = new ArrayList<>();

ArrayList <ArrayList<Square>> board;
int width = 10;
int height = 10;

Ocean(){
    this.board = new ArrayList<>();
    for (int i = 0; i < width; i++){
        ArrayList<Square> row = new ArrayList<>();
        for(int j = 0; j <width; j++){
            Square square = new Square();
            row.add(square);
        }
        board.add(row);
    }
}

public void isHit(ArrayList<Integer> shot, HashMap<String, ArrayList<ArrayList<Integer>>> listOfUsersShips){
    for(HashMap.Entry <String, ArrayList<ArrayList<Integer>>> ship : listOfUsersShips.entrySet()){
        ArrayList<ArrayList<Integer>> shipCoordinates = ship.getValue();
        for (ArrayList<Integer> pointOfShip : shipCoordinates){
            if (pointOfShip.equals(shot)){     
                pointOfShip.set(0, -1);           
                pointOfShip.set(1, -1);           
                markAfterShot(shot, true);
            }else{
                markAfterShot(shot, false);
            }
        }
    }
}

public void markAfterShot(ArrayList<Integer> shot, boolean isHit){
        int x = shot.get(0);
        int y = shot.get(1);
        // tu było odwrotnie w odsłanianiu 
        Square square = board.get(y).get(x);

    if (isHit){
        square.isHit();
        square.setSymbol();
    }else{
        square.setSymbol();
    }
}

public void putTakenCoordinates(ArrayList<ArrayList<Integer>> ship){
  
    for (ArrayList<Integer> coordinates : ship){
        takenCoordinates.add(coordinates);
    }
}

public ArrayList<ArrayList<Integer>> getTakenCoordinates(){
    return takenCoordinates;
}

public ArrayList <ArrayList<Square>> getBoard(){
    return board;
}


}