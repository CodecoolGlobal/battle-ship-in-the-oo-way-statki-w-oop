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


    public Player(){
        this.listOfUsersShips = new HashMap<>();
        this.listOfShips = new HashMap<>();
        
        
        listOfShips.put("Carrier", 5);
        // listOfShips.put("Battleship", 4);
        // listOfShips.put("Cruiser", 3);
        // listOfShips.put("Submarine", 3);
        listOfShips.put("Destroyer", 2);
    
    }
    public HashMap<String, ArrayList<ArrayList<Integer>>> addShipToUser(){
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
                Ship ship = new Ship(shipTemplate.getValue(), horizontal, x, y);
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

    public ArrayList<Integer> shot(){
        this.userShot = new ArrayList<>();
        System.out.println("Type coordinate on axis X");
        int userShotX = scan.nextInt();
        userShot.add(userShotX);
        System.out.println("Type coordinate on axis Y");
        int userShotY = scan.nextInt();
        userShot.add(userShotY);
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

