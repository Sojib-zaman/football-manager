package Subclass;

import Subclass.Player;

import java.io.Serializable;
import java.util.List;

public class Playersoftheclub implements Serializable {
    List<Player> playerList  ;

    public Playersoftheclub(List<Player> playerList )
    {
        this.playerList = playerList ;


    }

    public Playersoftheclub() {

    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {

    }
}
