package app.Classes;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card> cardDeffause = new ArrayList<>();
    Player player = new Player();
    Dealer dealer = new Dealer();
    Scanner s = new Scanner(System.in);

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
    public ArrayList<Card> getCardDeffause(){return this.cardDeffause;}

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
        System.out.println("Player Name : " + player.getName() + "  ||  Player coins : " + player.getCoins() + "  ||  Wins : " + player.getWin() + "  ||  Loses : " + player.getLose()
                + "  ||  Ties : " + player.getTie());
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
            showPlayer();
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
        showState();
        if (player.score > 21) {
            System.out.println("Dealer Win");
            player.setLose(player.getLose()+1);
            player.setCoins(player.getCoins() - player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
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


    public void challenging() {
        dealer.piocheCarte(deck,this.player);
//=======================================================//
        checkingScore();
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


    public void compareScores(){
        dealer.calcDealerHands();
        System.out.print("\nDealer Cards :\t\t");  dealer.dealerHand();
        System.out.println("Dealer Score : " + dealer.score);

        if (dealer.score < 17)
        {
            dealer.DealerDraw(deck);
            compareScores();
        }
        //while(dealer.score<17){
          //  dealer.DealerDraw(deck);
        //}

        else if(dealer.score > 21)
        {
            System.out.println("player win");
            player.setWin(player.getWin()+1);
            player.setCoins(player.getCoins()+ player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }

        else if(dealer.score == player.score)
        {
            System.out.println("Tie");
            player.setTie(player.getTie()+1);
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }

        else if(dealer.score < player.score )
        {
            System.out.println("player win");
            player.setWin(player.getWin()+1);
            player.setCoins(player.getCoins() + player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }

        else if(dealer.score == 21)
        {
            System.out.println("dealer win");
            player.setLose(player.getLose()+1);
            player.setCoins(player.getCoins() - player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }

        else if (dealer.score < 21 && player.score == 21)
        {
            System.out.println("player win");
            player.setWin(player.getWin()+1);
            player.setCoins(player.getCoins() + player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }

        else
        {
            System.out.println("Dealer win");
            player.setLose(player.getLose()+1);
            player.setCoins(player.getCoins() - player.getBet());
            dealer.cardsDeffausse(getCardDeffause(),player,deck );
            this.replay();
        }
    }





    public void standOrhit(){
        int ch;
            System.out.println("\t1=> Hit");
            System.out.println("\t2=> Stand");
            ch = s.nextInt();

            switch(ch){
                case 1 :{
                    player.playerDraw(deck);
                    checkingScore();
                    break;

                }
                case 2 :{
                    compareScores();
                    break;
                }
            }
    }

    private void replay() {
        System.out.println("1=> \tPlay again");
        System.out.println("0=> \tQuiter");

        int ch ;
        System.out.println("Your choice : ");
        ch=s.nextInt();
        switch (ch){
            case 1 : {
                betPrice();
                break;
            }
            case 2 : {
                exit(0);
            }
        }


    }

}






