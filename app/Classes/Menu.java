package app.Classes;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    static Scanner s = new Scanner(System.in);  // Create a Scanner object


    public static void MainMenu() {
        Game game=new Game();
        int choice;
        do {
            System.out.println("1 => Start the Game ");
            System.out.println("0 => Quiter ");


            System.out.println("Chose Your Number : ");
            choice = s.nextInt();
            if(choice ==1){
                game.StartGame();
            }else{
                exit(0);
            }


        }while (choice!=0);
    }
}
