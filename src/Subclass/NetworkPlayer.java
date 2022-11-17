package Subclass;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class NetworkPlayer {
     String playername;
     String   Clubname;
     String  Countryname;
     int  age;
     double height;
     String  position;
     double weeklysalary;
     int number;

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
}
