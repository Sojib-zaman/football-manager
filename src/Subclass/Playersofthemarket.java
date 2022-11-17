package Subclass;

import Subclass.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playersofthemarket implements Serializable {
    public List<Player> marketplayer  ;

    public Playersofthemarket(List<Player> playerList )
    {
        this.marketplayer = new ArrayList<>();
        for(Player p : playerList) this.marketplayer.add(p) ;



    }

    public Playersofthemarket() {

    }

    public List<Player> getPlayerList() {
        return marketplayer;
    }
}
