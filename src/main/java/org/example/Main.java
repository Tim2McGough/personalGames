package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {


        {

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hello and welcome! \nThis is a text adventure created by Tim! \n \n You'll be asked to enter prompts.\n i.e. 'you wake up in a bed in dark room. You can make out a light switch and some slippers'\n You can then respond 'I put on the slippers' OR 'I turn on the light switch'\n Good luck! \n \nEnter your name:");
            String playerName = keyboard.nextLine();
// Create a new Player instance
            Player player = new Player();
            player.setPlayerName(playerName);
            player.setHealth(74); // Setting initial health to 74
            player.setInventory(new ArrayList<>()); // Initialize an empty inventory


// Initialize the starting inventory
            ArrayList<String> startingInventory = new ArrayList<>();
            startingInventory.add("tattered clothes");
            startingInventory.add("lighter");
            startingInventory.add("pocket lasagna");
            player.setInventory(startingInventory);

// Display the player's initial status
            System.out.println(player.getPlayerName() + " wakes up, feeling " + player.getHealthStatus() + ". \n hint: you can see the commands I have programmed in so far using the word 'help' ");

            while (true) {
                System.out.println("\nWhat would you like to do?");
                String action = keyboard.nextLine().trim().toLowerCase();

                if (action.contains("inventory")) {
                    player.displayInventory();
                }
                else if (action.contains("look")) {
                    System.out.println("You look around the room. It’s dimly lit and cluttered but you think you can make out a torch on the wall.");
                }
                else if (action.contains("lighter") && action.contains("torch")|| (action.contains("light") && action.contains("torch"))) {
                    System.out.println("The torch is lit. A doorway opens in the stone wall. Do you want to enter? (yes/no)");

                    boolean validResponse = false;
                    while (!validResponse) {
                        String response = keyboard.nextLine().trim().toLowerCase();
                        if (response.equals("yes")) {
                            System.out.println("You step through the doorway and find yourself in a dark corridor.");
                            validResponse = true;
                            // You can add more interactions here for the corridor, or break the loop to end this scenario.
                            break;
                        } else if (response.equals("no")) {
                            System.out.println("You wait in the room a while and grow bored. Do you want to exit using the entrance? (yes/no)");
                        } else {
                            System.out.println("Please answer 'yes' or 'no'.");
                        }
                    }
                }
                else if (action.contains("help")) {
                    System.out.println("Current general commands are: \n help \n inventory \n eat \n status \n look");
                }
                else if (action.contains("health") || action.contains("status")) {
                    System.out.println(player.getPlayerName() + " is currently " + player.getHealthStatus() + ".");

                }
                //food example use
                else if (action.contains("eat") && (action.contains("lasagna") || action.contains("pocket") || action.contains("food"))) {
                    if (player.getInventory().contains("pocket lasagna")) {
                        // Remove the item from inventory
                        player.getInventory().remove("pocket lasagna");
                        System.out.println(player.getPlayerName() + " grabbed and ate the pocket lasagna from their sticky pocket. It was quite messy. \n Deeeelicious and oddly warm!");

                        // Increase health by 24, ensuring it doesn't exceed 100
                        int newHealth = Math.min(player.getHealth() + 24, 100);
                        player.setHealth(newHealth);
                        System.out.println(player.getPlayerName() + "'s health is now " + player.getHealthStatus() + ".");
                    } else {
                        System.out.println("You don't have anything to eat.");
                    }
                    //lighter use?

                    //
                } else if (action.contains("quit")) {
                    System.out.println("Thanks for playing! Goodbye.");
                    break;
                } else {
                    System.out.println("I don't understand. Try again.  Hint: some commands need to be combined to make sense. I.e. 'Eat' eat what??");
                }
            }
        }
    }
}