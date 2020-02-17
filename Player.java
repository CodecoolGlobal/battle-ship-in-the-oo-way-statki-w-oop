import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Player {
    private HashMap <String, Integer> listOfShips;
    private HashMap <String, ArrayList<ArrayList<Integer>>> listOfUsersShips;
    private ArrayList<Integer> userShot;
    private Integer sumOfCoordinates; 
    Scanner scan = new Scanner(System.in);


    public Player(){
        this.listOfUsersShips = new HashMap<>();
        this.listOfShips = new HashMap<>();
        
        
        listOfShips.put("Carrier", 2);
        // listOfShips.put("Battleship", 4);
        // listOfShips.put("Cruiser", 3);
        // listOfShips.put("Submarine", 3);
        // listOfShips.put("Destroyer", 2);
    
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

    public void checkIfWin (HashMap<String, ArrayList<ArrayList<Integer>>> listOfUsersShips){
        sumOfCoordinates = 0;
        for (HashMap.Entry<String, ArrayList<ArrayList<Integer>>> ship : listOfUsersShips.entrySet()){
            for(ArrayList<Integer> coordinates : ship.getValue()){   
                sumOfCoordinates += coordinates.get(0);
                sumOfCoordinates += coordinates.get(1);
                if (sumOfCoordinates == 0){
                    listOfUsersShips.remove(ship.getKey());
                }
            }
        }
    }
}

