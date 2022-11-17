package Subclass;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Player implements Serializable {
    /*
    private final SimpleStringProperty playername;
    private final SimpleStringProperty  Clubname;
    private final SimpleStringProperty Countryname;
    private final SimpleIntegerProperty age;
    private final SimpleDoubleProperty height;
    private final SimpleStringProperty position;
    private final SimpleDoubleProperty weeklysalary;
    private final SimpleIntegerProperty number;
     */
    String playername;
    String   Clubname;

    String  Countryname;
    int  age;
    double height;
    String  position;
    double weeklysalary;
    int number;
    public int isinmarket  = 0 ;


    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    String  Price;

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getClubname() {
        return Clubname;
    }

    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    public String getCountryname() {
        return Countryname;
    }

    public void setCountryname(String countryname) {
        Countryname = countryname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getWeeklysalary() {
        return weeklysalary;
    }

    public void setWeeklysalary(double weeklysalary) {
        this.weeklysalary = weeklysalary;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    Player()
    {
        /*
        playername = new SimpleStringProperty();
        Countryname = new SimpleStringProperty() ;
        this.age = new SimpleIntegerProperty();
        this.height = new SimpleDoubleProperty();
        Clubname =  new SimpleStringProperty();
        position =  new SimpleStringProperty();
        this.number = new SimpleIntegerProperty();
        this.weeklysalary = new SimpleDoubleProperty();

         */
    }
   public Player(String Pname, String Coname, int age, double height, String club, String pos, int num, double sal) {
        /*
        playername = new SimpleStringProperty(Pname);
        Countryname = new SimpleStringProperty(Coname);
        this.age = new SimpleIntegerProperty(age);
        this.height = new SimpleDoubleProperty(height);
        Clubname = new SimpleStringProperty(club);
        position = new SimpleStringProperty(pos);
        this.number = new SimpleIntegerProperty(num);
        this.weeklysalary = new SimpleDoubleProperty(sal);
         */
        playername = Pname ;
        Countryname = Coname ;
        this.age = age ;
        this.height = height ;
        Clubname = club ;
        position=pos;
        this.number = num ;
        this.weeklysalary=sal ;
        Price="";

    }



}
