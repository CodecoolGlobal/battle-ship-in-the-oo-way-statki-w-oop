import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Player {
    private HashMap <String, Integer> listOfShips;
    private HashMap <String, ArrayList<ArrayList<Integer>>> listOfUsersShips;
    private ArrayList<Integer> userShot;
    private int isSunk = 0;
    private String sunkShipName;
    Scanner scan = new Scanner(System.in);
    private ArrayList<Integer> sunkPoint = new ArrayList<>();
    private Ocean ocean;
    HashMap<String, Integer> upperRowofX;



    public Player(Ocean ocean){
        this.ocean = ocean;
        this.listOfUsersShips = new HashMap<>();
        this.listOfShips = new HashMap<>();
        this.userShot = new ArrayList<>();
        // listOfShips.put("Carrier", 5);
        // listOfShips.put("Battleship", 4);
        // listOfShips.put("Cruiser", 3);
        // listOfShips.put("Submarine", 3);
        listOfShips.put("Destroyer", 2);
        this.upperRowofX = new HashMap<>();
        upperRowofX.put("A",0);
        upperRowofX.put("B",1);
        upperRowofX.put("C",2);
        upperRowofX.put("D",3);
        upperRowofX.put("E",4);
        upperRowofX.put("F",5);
        upperRowofX.put("G",6);
        upperRowofX.put("H",7);
        upperRowofX.put("I",8);
        upperRowofX.put("J",9);
        upperRowofX.put("K",10);
    
    }
    public HashMap<String, ArrayList<ArrayList<Integer>>> addShipToUser(Ocean ocean){
            for (HashMap.Entry<String, Integer> shipTemplate : listOfShips.entrySet()){
                System.out.println("Create " + shipTemplate.getKey() + "- it has lenght of " + shipTemplate.getValue() + " fields.");
                System.out.println("Type staring point X ");
                int x = scan.nextInt();
                System.out.println("Type staring point y ");
                int y = scan.nextInt();
                System.out.println("Is it horizontal?");
                String Ishorizontal = scan.next();
                boolean horizontal;
                if (Ishorizontal.equals("yes")){
                    horizontal = true;
                }else{
                    horizontal = false;
                }
                Ship ship = new Ship(shipTemplate.getValue(), horizontal, x, y, ocean);
                System.out.println(ship.getShipLocation() + "lokalizacja w playerze przed dodaniem");
                listOfUsersShips.put(shipTemplate.getKey(), ship.getShipLocation());
            }

            return listOfUsersShips;
    }

    public void displayShips(){
        for (HashMap.Entry<String, ArrayList<ArrayList<Integer>>> ship : listOfUsersShips.entrySet()){
            System.out.println("slownik usera");
            System.out.println(ship.getKey() + " " + ship.getValue());
        }
    }

    public ArrayList<Integer> userShot(){
        System.out.println("Type coordinates to shot.");
        String userInput = scan.next();
        int x = 0;
        int y;
        char firstCharOfInput = userInput.charAt(0);
        for(HashMap.Entry<String, Integer> row : upperRowofX.entrySet()){
            if(firstCharOfInput == row.getKey().charAt(0)){
               x = row.getValue();
            }
        }       
        y = (Character.getNumericValue(userInput.charAt(1)) - 1);
        userShot.add(x);
        userShot.add(y);
        return userShot;
    }

    public ArrayList<Integer> getUserShot(){
        return userShot;
    } 

    public HashMap<String, ArrayList<ArrayList<Integer>>> getListOfUserShips(){
        return listOfUsersShips;
    }

    public boolean checkIfWin (HashMap<String, ArrayList<ArrayList<Integer>>> listOfUsersShips){
        this.sunkPoint = new ArrayList<>();
        sunkPoint.add(-1);
        sunkPoint.add(-1);

        for (HashMap.Entry<String, ArrayList<ArrayList<Integer>>> ship : listOfUsersShips.entrySet()){
            isSunk = 0;
            int sizeOfShip = listOfShips.get(ship.getKey());
            for(ArrayList<Integer> coordinates : ship.getValue()){   
                if(coordinates.equals(sunkPoint)){
                    isSunk++;
                    if(isSunk == sizeOfShip){
                        isSunk = 0;
                        sunkShipName = ship.getKey();
                        System.out.println(ship.getKey() + " has been destroyed");   
                        removeSunkShip(sunkShipName);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void removeSunkShip(String nameShip){
        listOfUsersShips.remove(nameShip);
    }
}

