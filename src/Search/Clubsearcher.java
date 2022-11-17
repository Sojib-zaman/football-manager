package Search;

import Subclass.Player;
import Subclass.club;
import sample.fileoperations;

import java.util.ArrayList;
import java.util.List;

public class Clubsearcher {
    String clubname ;
    List<Player> playerList = new ArrayList<>();
    List<club> clubList = new ArrayList<>();

    public Clubsearcher(List<Player>playerList) throws Exception {
        this.playerList = playerList;
        clubList= fileoperations.takeinfoclub(playerList);
    }
    public List<Player>getPlayerList()
    {
        return playerList;
    }

    public List<Player> searchmaxage(String validinput)
    {
        System.out.println(validinput);


        List<Player> players = new ArrayList<>();
        for(club c:clubList)
        {
            if(c.getclubname().equalsIgnoreCase(validinput))
                    players=c.getmaxageplayer();
        }
        return players;

    }
    public List<Player> searchmaxheight(String validinput)
    {

        List<Player> players = new ArrayList<>();
        for(club c:clubList)
        {
            if(c.getclubname().equalsIgnoreCase(validinput))
                players=c.getmaxheightplayer();
        }
        return players;

    }
    public List<Player> searchmaxsalary(String validinput)
    {

        List<Player> players = new ArrayList<>();
        for(club c:clubList)
        {
            if(c.getclubname().equalsIgnoreCase(validinput))
                players=c.getmaxsalaryplayer();
        }
        return players;

    }
    public double totalsalary(String validinput)
    {
        double salary = 0 ;


        for(club c:clubList)
        {
            if(c.getclubname().equalsIgnoreCase(validinput))
                salary = c.getTotalsalaryofclub();
        }
        return salary;

    }
}
