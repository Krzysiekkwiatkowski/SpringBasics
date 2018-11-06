package pl.coderslab.beans;

public class Ship {
    private Captain captain;

    public Captain getCaptain() {
        return captain;
    }

    public Ship(Captain captain) {
        this.captain = captain;
    }
}
