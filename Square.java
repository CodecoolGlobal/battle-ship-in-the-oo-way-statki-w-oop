class Square{
    private String symbol = " - ";
    private boolean isHit = false;

    public void isHit(){
        isHit = true;
    }

    public boolean getIshit(){
        return isHit;
    }
    public String setSymbol(){
        if(isHit == true){
            symbol = " X ";
        }else{
            symbol = " O ";
        }
        return symbol;
    }

    public String toString(){
        return symbol;
    }
}