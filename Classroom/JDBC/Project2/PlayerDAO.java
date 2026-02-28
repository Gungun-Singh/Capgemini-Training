package com.capg.dao;

import com.capg.entity.Game;
//import com.capg.entity.Game;
import java.util.List;

public interface PlayerDAO {

void insertPlayer(Game game);
void updatePlayer(Game game);
void deletePlayer(int playerId);

List<Game> getAllPlayers();
}
