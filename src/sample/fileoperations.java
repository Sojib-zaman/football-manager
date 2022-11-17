package sample;

import Subclass.Player;
import Subclass.club;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class fileoperations {
    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";
    //Reading the list from player text file
    static List<Player>globalplayer  = new ArrayList() ;

    public static List<Player> allplayer() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player p = new Player(tokens[0] , tokens[1] , Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]),tokens[4],tokens[5],Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7])) ;
            globalplayer.add(p);

        }
        br.close();
        return globalplayer;
    }


    public static List<Player> readFromFile(String username) throws Exception {
        List<Player> playerList = new ArrayList();
        for(Player p: globalplayer)
        {
            if(p.isinmarket!=1 && username.equals(p.getClubname()))
                playerList.add(p);
        }

        return playerList;
    }


    //making a clublist
    public static List<club> takeinfoclub(List<Player> playerList )
    {
        List<club>listofclubs=new ArrayList() ;
        boolean zero = true;
        boolean validity = true;
        for(Player p:playerList)
        {

            club c=new club(p.getClubname()) ;
            for(club x:listofclubs)
            {

                if(c.getclubname().equalsIgnoreCase(x.getclubname()))
                    validity=false ;
            }

            if(zero | validity)
            {
                listofclubs.add(c) ;
                zero=false;

            }
            validity=true;

        }
        return listofclubs;

    }





    public static void writeToFile(List<Player>playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        for (Player s : playerList) {
            bw.write(s.getPlayername() + "," +s.getCountryname() + "," +s.getAge()+","+s.getHeight()+","+s.getClubname()+","+s.getPosition()+","+s.getNumber()+","+s.getWeeklysalary());
            bw.write("\n");
        }
        bw.close();
    }


}
