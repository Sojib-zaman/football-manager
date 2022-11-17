package Subclass;

import java.io.Serializable;

public class Boughtplayerinfo implements Serializable {

    String fromclubname ;
    String toclubname ;
    Player boughtplayer ;
    public Boughtplayerinfo(){}
    public Boughtplayerinfo(String from , String to , Player player)
    {
        this.fromclubname = from ;
        this.toclubname = to ;
        this.boughtplayer = player ;
    }
    public String getFromclubname() {
        return fromclubname;
    }

    public void setFromclubname(String fromclubname) {
        this.fromclubname = fromclubname;
    }

    public String getToclubname() {
        return toclubname;
    }

    public void setToclubname(String toclubname) {
        this.toclubname = toclubname;
    }

    public Player getBoughtplayer() {
        return boughtplayer;
    }

    public void setBoughtplayer(Player boughtplayer) {
        this.boughtplayer = boughtplayer;
    }

}
