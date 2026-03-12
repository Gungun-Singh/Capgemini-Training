import com.capg.dao.PlayerDAO;
import com.capg.dao.PlayerDAOImpl;
import com.capg.entity.Game;

public class Main {
    public static void main(String[] args) {
        PlayerDAO dao = new PlayerDAOImpl();

        //INSERT
        dao.insertPlayer(new Game(10,"Dhoni","Ind"));

        //UPDATE
        dao.updatePlayer(new Game(10, "MS Dhoni", "IND"));

        // 🔹 FETCH (SELECT)
        List<Game> list = dao.getAllPlayers();

        System.out.println("---- Player List ----");
        for (Game g : list) {
            System.out.println(
                    g.getPlayerId() + " " +
                            g.getPlayerName() + " " +
                            g.getPlayerCountry()
            );
        }

        // 🔹 DELETE
        dao.deletePlayer(10);

        System.out.println("Done");

    }
}
