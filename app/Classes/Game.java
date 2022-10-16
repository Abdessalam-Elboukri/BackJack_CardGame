package app.Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Card> deck = new ArrayList<Card>();
    Player player = new Player();
    Dealer dealer = new Dealer();
    Scanner s = new Scanner(System.in);

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void StartGame() {
        int ch = 0;
        CreatePlayer();
        System.out.println("==========Let's Start==========");
        CreateCardlist();
        showPlayer();

        shwlistedcards();
        dealer.Shuffled(deck);
        // System.out.println("list after shuffle");
        // shwlistedcards();
        betPrice();
        //dealer.ShowFirstCardDealer();

    }


    public void CreateCardlist() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j, i);
                this.deck.add(card);
            }
        }

    }

    public void CreatePlayer() {

        System.out.println("Enter Your Name");
        String pl_name = s.next();
        player.setName(pl_name);
        System.out.println(" ===player -> " + player.getName() + " <- Created successfully=== ");
        System.out.println("Currents Coins : " + player.getCoins());
    }

    public void showPlayer() {
        System.out.println("Player Name : " + Player.getName() + "  ||  Player coins : " + Player.getCoins() + "  ||  Wins : " + Player.getWin() + "  ||  Loses : " + Player.getLose()
                + "  ||  Ties : " + Player.getTie());
    }

    public void shwlistedcards() {
        deck.forEach((value) -> System.out.printf("(%d %d)", value.getHauteur(), value.getCouleur()));
    }

    public int calcHansCards(ArrayList arr) {

        return 0;
    }

    public void betPrice() {
        int choice;
        do {
            System.out.println("Player Coins : " + Player.getCoins());
            System.out.println("Chose your bet Price =>");
            System.out.println("+++++++++++++++");
            System.out.println("1=> 100 ");
            System.out.println("2=> 500 ");
            System.out.println("3=> 1000 ");
            System.out.println("4=> 3000 ");
            System.out.println("+++++++++++++++");
            System.out.print("=> ");
            choice = s.nextInt();

            switch (choice) {
                case 1: {
                    player.setBet(100);
                    challenging();
                    break;
                }
                case 2: {
                    player.setBet(500);
                    challenging();
                    break;
                }
                case 3: {
                    player.setBet(1000);
                    challenging();
                    break;
                }
                case 4: {
                    player.setBet(3000);
                    challenging();
                    break;
                }
            }

        } while (choice != 0);

    }


    public void checkingScore(){
        if (player.score > 21) {
            showState();
            player.setCoins(player.getCoins() - player.getBet());
            //dealer.defausserCarte(getCarteDefausser(),palyer);
            //this.replay();
        }

        else if(player.score == 21)
        {
            player.getPlayerhand();
            compareScores();
        }

        else
        {
            standOrhit();
        }
    }
    }

    public void challenging() {
        dealer.piocheCarte(deck,this.player);
//=======================================================//
       showState();
    }

    public void showState(){
        System.out.println("Dealer Hand :=>");
        dealer.ShowFirstCardDealer();
        System.out.println("============================");
        System.out.println("Player Hand :=>");
        player.playerHand();
        player.calcPlayerHands();
        System.out.println("Payer Score :" + player.getScore());
    }

    public void compareScores(){}


    public void standOrhit(){
        int ch;
            System.out.println("\t1=> Hit");
            System.out.println("\t2=> Stand");
            ch = s.nextInt();

            switch(ch){
                case 1 :{
                    player.playerDraw(deck);
                    player.checkScore();
                    break;

                }
                case 2 :{
                    compareScores();
                    break;
                }
            }
    }

}






