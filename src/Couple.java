public class Couple{
    private Person bride;
    private Person groom;
    public Couple(Person groom, Person bride){
        this.bride = bride;
        this.groom = groom;
    }
    public Person getBride(){
        return bride;
    }
    public Person getGroom(){
        return groom;
    }
    public String toString(){
        return bride.toString() + " and " + groom.toString();
    }
}
