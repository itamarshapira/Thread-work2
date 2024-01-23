package X_O;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose which game you want to play:\n1. User vs CPU.\n2. CPU vs CPU");
        int choiceOfUser = sc.nextInt();

        switch (choiceOfUser) {
            case 1:
                playUserGame();
                break;
            case 2:
                PlayTheSelfGame();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }



    private static void playUserGame() {
        UserGame userGame = new UserGame();

        UserPlayer playerX = new UserPlayer(PlayerType.X, userGame);
        UserPlayer playerO = new UserPlayer(PlayerType.O, userGame);

        Thread threadO = new Thread(playerO);
        threadO.start();
        // Wait for the threads to finish
//        try {
//            threadO.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    public static void PlayTheSelfGame() {
        // Create an instance of SelfGame
        SelfGame selfGame = new SelfGame();

        // Create two SelfPlayer instances (X and O)
        SelfPlayer playerX = new SelfPlayer(PlayerType.X, selfGame);
        SelfPlayer playerO = new SelfPlayer(PlayerType.O, selfGame);

        // Create and start two threads for the players
        Thread threadX = new Thread(playerX);
        Thread threadO = new Thread(playerO);

        threadX.start();
        threadO.start();

        // Wait for the threads to finish
        try {
            threadX.join();
            threadO.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
