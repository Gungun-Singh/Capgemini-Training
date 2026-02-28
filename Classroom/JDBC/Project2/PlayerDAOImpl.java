package com.capg.dao;
import com.capg.entity.Game;
import com.capg.repository.PlayerRepo;
//import com.capg.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO{

    @Override
    public void insertPlayer(Game game){
        String sql = "INSERT INTO players VALUES (?,?,?)";

        try(Connection conn = PlayerRepo.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, game.getPlayerId());
            pstmt.setString(2, game.getPlayerName());
            pstmt.setString(3, game.getPlayerCountry());

            pstmt.executeUpdate();
            System.out.println("Player Inserted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlayer(Game game) {}

    @Override
    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM players WHERE playerid=?";

        try (Connection conn = PlayerRepo.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
            System.out.println("Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Game> getAllPlayers() {

        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM players";

        try (Connection conn = PlayerRepo.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Game g = new Game();
                g.setPlayerId(rs.getInt(1));
                g.setPlayerName(rs.getString(2));
                g.setPlayerCountry(rs.getString(3));
                list.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
