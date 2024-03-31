public class BloodData {
    //Sets the instance variable
    private BloodTypes b;

    //Constructor sets default blood type to be O- (displayed as On)
    BloodData() {
        b = BloodTypes.On;
    }

    //Constructor sets the blood type to what the user inputs if valid from the enum class blood type
    BloodData(String type, String rh) {
        BloodTypes t = null;
        for (BloodTypes c : BloodTypes.values()) {
            if (c.isBloodType(type, rh)) {
                t = c;
            }
        }
        b = t;
    }

    //Returns the blood type
    public String toString(){
        return b.toString();
    }

    //Standard set and get methods
    public String getType(){
        return b.getType();
    }
    public String getRh(){
        return b.getRh();
    }

    //.equals method that checks if the blood types are the same.
    public boolean equals(BloodData o) {
        if (this == o) return true;
        else return false;
    }
}
