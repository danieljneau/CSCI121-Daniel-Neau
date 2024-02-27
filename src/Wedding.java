import java.util.Date;
public class Wedding{
    private String date;
    private Couple couple;
    private Location location;
    public Wedding (String date, Couple couple, Location location){
        this.couple = couple;
        this.date = date;
        this.location = location;
    }
    public String getDate(){
        return date;
    }
    public Couple getCouple(){
        return couple;
    }
    public Location getLocation(){
        return location;
    }
    public String toString(){
        return couple.toString() +"\n" + date + "@ the " + location.toString();
    }
}
