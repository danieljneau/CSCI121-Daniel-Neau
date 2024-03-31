public class Patient {
    //Sets necessary instance varibles
    private short id;
    private short age;
    private BloodData blood;
    //Default constructor sets id and age to 0 and their blood to the default.
    Patient(){
        id = 0;
        age = 0;
        blood = new BloodData();
    }

    //Constructor with all values customizable
    Patient(short id, short age, String type, String rh){
        this.id = id;
        this.age = age;
        blood = new BloodData(type, rh);
    }


    public short getId() {
        return id;
    }

    public short getAge() {
        return age;
    }

    public BloodData getBlood() {
        return blood;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setBlood(String type, String rh) {
        this.blood = new BloodData(type, rh);
    }
}
