package com.capg.entity;

public class Game {
    private int playerId;
    private String playerName;
    private String playerCountry;

    public Game() {
    }

    public Game(int playerId, String playerName, String playerCountry) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerCountry = playerCountry;
    }


    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }


    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }
}
