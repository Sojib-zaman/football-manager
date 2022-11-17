package Search;


import Subclass.Country;
import Subclass.Player;
import Subclass.club;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class playersearcher {


    List<Player> playerList;
    List<Country> countrylist = new ArrayList<>();
    club playerclub ;

    public playersearcher(List<Player>playerList) throws Exception {

        //playerList = fileoperations.readFromFile();
        this.playerList = playerList ;

        for (Player x : playerList)
        {
            boolean found = false;
            for (Country y : countrylist)
            {
                if (y.getCountryname().equalsIgnoreCase(x.getCountryname()))
                    found = true;
            }
            if (found == false)
            {
                Country country = new Country() ;
                country.setCountryname(x.getCountryname());


                countrylist.add(country);
            }
        }


    }
    public List<Player>getPlayerList()
    {
        return playerList;
    }
    public List<Country>getCountrylist()
    {
        return countrylist;
    }

    public List<Player> searchbyname(String s) {
        List<Player> players = new ArrayList<>();
        for (Player p : playerList) {
            if (s.equalsIgnoreCase(p.getPlayername()))
                players.add(p);
        }
        return players;
    }






    public List<Player> searchbypos(String s) {
        List<Player> players = new ArrayList<>();
        for (Player p : playerList) {
            if (s.equalsIgnoreCase(p.getPosition()))
                players.add(p);
        }
        return players;
    }

    public int countryplayer(String countryname) throws IOException {
        int playercountpercountry = 0;
        for(Player x:playerList)
        {
              if(countryname.equalsIgnoreCase(x.getCountryname()))
                    playercountpercountry++;

        }
       return playercountpercountry;
    }


    public List<Player> clubcountryplayer(String validinput1)
    {
        List<Player> players = new ArrayList<>();
        for(Player x: playerList)
        {
            if(validinput1.equalsIgnoreCase(x.getCountryname()))
            {
               players.add(x);


            }

        }
        return players;
    }

    public List<Player> salaryplayer(String validinput1, String validinput2)
    {
        List<Player> players = new ArrayList<>();

        for(Player x: playerList)
        {
            if(x.getWeeklysalary()>=Integer.parseInt(validinput1) && x.getWeeklysalary()<=Integer.parseInt(validinput2))
            {
                players.add(x);

            }

        }
        return players;
    }
}
