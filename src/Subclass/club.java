package Subclass;

import Network.ReadThreadClient;

import java.util.ArrayList;
import java.util.List;
public class club {

    List<Player> playersoftheclub = new ArrayList();
    private int totalplayers; //can be max 7
    private double totalsalaryofclubperweek;
    String clubName;

    public club(String s) {
        clubName = s;
    }

    public String getclubname() {
        return clubName;
    }

    public void showplayersofthisclub() {

        /*
        for (Player p : playersoftheclub)
            printallinformation.printinfo(p);

         */
    }

    public void setPlayersoftheclub() {
        playersoftheclub= ReadThreadClient.getlist().getPlayerList();
    }


    public void setoneplayer(Player p)
    {
        playersoftheclub.add(p) ;
        totalplayers++ ;
    }




    public List<Player> getmaxheightplayer() {
        setPlayersoftheclub();
        List<Player> players = new ArrayList<>();
        double maxheight = 0.3;
        for (Player p : playersoftheclub) {
            if (p.getHeight() >= maxheight) maxheight = p.getHeight();
        }

        for (Player p : playersoftheclub) {
            if (p.getHeight() == maxheight)
                players.add(p);
        }
        return players;


    }

    public double getTotalsalaryofclub()
    {
        setPlayersoftheclub();

        for(Player p:playersoftheclub)
        {
            totalsalaryofclubperweek+=p.getWeeklysalary();
        }
        return totalsalaryofclubperweek;

    }

    public List<Player> getmaxsalaryplayer()
    {
        setPlayersoftheclub();
        List<Player> players = new ArrayList<>();
        double maxsalary = 0.0 ;
        for (Player p : playersoftheclub) {
            if (p.getWeeklysalary() >= maxsalary) maxsalary= p.getWeeklysalary();
        }

        for (Player p : playersoftheclub) {
            if (p.getWeeklysalary() == maxsalary)
                 players.add(p);
        }
        return players;



    }
    public List<Player> getmaxageplayer()
    {
        setPlayersoftheclub();
        List<Player> players = new ArrayList<>();
        int maxage =13;
        for (Player p : playersoftheclub) {
            if (p.getAge() >= maxage) maxage= p.getAge();
        }

        for (Player p : playersoftheclub) {
            if (p.getAge() == maxage)
                players.add(p);
        }
        return players;


    }
    public int getTotalplayers()
    {
        return totalplayers;
    }


}

