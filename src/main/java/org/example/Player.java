package org.example;
import java.util.*;
public class Player {

    private String playerName;
    private int health;
    private ArrayList<String> inventory;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
    public void takeDamage(int damage){
        health -= damage;

        if (health <= 0){
            System.out.println("You ran out of health " + playerName + "! \n Game over.");
        } else {
            System.out.println(playerName + "took" + damage + "damage. Current Health: " + health);
        }
    }
    public void pickUpItem(String item) {
        inventory.add(item);
        System.out.println(playerName + " picked up: " + item);

    }
    public String getHealthStatus() {
        if (health == 100) {
            return "uninjured";
        } else if (health >= 75) {
            return "mostly healthy";
        } else if (health >= 50) {
            return "wounded";
        } else if (health >= 25) {
            return "very hurt";
        } else {
            return "Seek immediate care!";
        }
    }
    //Inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println(playerName + "'s inventory is empty.");
        } else {
            System.out.println(playerName + "'s Inventory:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }


}