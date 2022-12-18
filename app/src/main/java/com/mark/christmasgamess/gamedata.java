package com.mark.christmasgamess;

public class gamedata {
    int gameImage;
    String gamename ;
    String gameURl;

    public gamedata(int gameImage, String gamename, String gameURl) {
        this.gameImage = gameImage;
        this.gamename = gamename;
        this.gameURl = gameURl;
    }

    public int getGameImage() {
        return gameImage;
    }

    public void setGameImage(int gameImage) {
        this.gameImage = gameImage;
    }

    public gamedata(String gamename, String gameURl) {
        this.gamename = gamename;
        this.gameURl = gameURl;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public String getGameURl() {
        return gameURl;
    }

    public void setGameURl(String gameURl) {
        this.gameURl = gameURl;
    }
}
