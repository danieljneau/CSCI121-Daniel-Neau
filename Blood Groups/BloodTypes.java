//Enum containing the 8 different possible blood types
public enum BloodTypes {
    On("O", "-"),
    Op("O", "+"),
    An("A", "-"),
    Ap("A", "+"),
    Bn("B", "-"),
    Bp("B", "+"),
    ABp("AB", "+"),
    ABn("AB", "-");
    private final String type;
    private final String rh;
    BloodTypes(String type, String rh) {
        this.type=type;
        this.rh=rh;
    }

    //Standard set and get method
    public String getType() {
        return type;
    }

    public String getRh() {
        return rh;
    }

    //Checks if the blood type given is the same as the blood type held
    public boolean isBloodType(String t, String r){
        if(this.getType().equals(t)&&this.getRh().equals(r)){
            return true;
        }
        else{
            return false;
        }
    }
}
