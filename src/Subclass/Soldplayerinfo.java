package Subclass;

import java.io.Serializable;

public class Soldplayerinfo implements Serializable {
    String clubname ;

    public String getClubname() {
        return clubname;
    }

    public Player getPlayer() {
        return player;
    }

    Player player ;
    public Soldplayerinfo(String name  , Player sold)
    {
        clubname = name ;
        player = sold ;
    }
}
