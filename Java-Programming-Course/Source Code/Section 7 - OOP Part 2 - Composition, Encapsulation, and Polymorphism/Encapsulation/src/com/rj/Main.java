package com.rj;

public class Main {

    public static void main(String[] args) {

//        Player player = new Player();
//        player.fullName = "New Player";
////        player.health = 20;
//        player.weapon = "Sword";
//
//        int demage = 10;
//        player.loseHealth(demage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//        demage = 11;
//        player.health = 200;
//        player.loseHealth(demage);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("New Player", 50, "Sword");
        System.out.println("Initial health is " + player.getHealth());
    }
}
