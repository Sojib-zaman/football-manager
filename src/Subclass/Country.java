package Subclass;

import Search.playersearcher;
import Subclass.Player;

import java.util.ArrayList;
import java.util.List;

public class Country {
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setPlayercount(List<Player> playerList) throws Exception {
        this.playercount = new playersearcher(playerList).countryplayer(countryname);
    }

    public String countryname ;
    public   int playercount ;
    List<Player> playersoftheclub = new ArrayList();

    public Country() throws Exception {

    }


    public String getCountryname() {
        return countryname;
    }

    public int getPlayercount() {
        return playercount;
    }

    public List<Player> getPlayersoftheclub() {
        return playersoftheclub;
    }
}
