import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


class GetShot {
    private ArrayList<Integer> userShot = new ArrayList<>();
    private String userInput = new String();
    Scanner scan = new Scanner(System.in);
    HashMap<String, Integer> upperRowofX;

    GetShot(){
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

    public String userInput(){
        return userInput = scan.nextLine();
    }

    public ArrayList<Integer> userShot(){
        userInput();
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
    public static void main(String[] args) {
        GetShot user =  new GetShot();
        user.userShot();    
    }
}