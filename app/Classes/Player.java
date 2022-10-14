package app.Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person{

    private static int coins=2000;
    private int bet;
    private ArrayList<Card> playerhand = new ArrayList<Card>();

    Scanner s = new Scanner(System.in);


    public Player( String name, int win, int lose, int tie, int score, int coins,int bet) {
        super(name,score, win, lose, tie);
        this.bet = bet;
        this.coins = coins;
    }

    public int getBet() {
        return bet;
    }

    public boolean setBet(int bet) {
        if(this.coins>=bet){
            this.coins-=bet;
            this.bet =bet;
            return true;
        }else{
            System.out.println("Game Over :( No much Coins");
            return false;
        }
    }


    public Player() {
        super();
    }

    public  int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void CheckCoins(){
        if(this.coins<=0){
            System.out.println("Insufissant Coins");
            System.out.println(" 1=> Back to Menu");
        }
    }

    public void gainCoins(int gain){
        this.coins= this.coins+gain;
    }


    public ArrayList<Card> playerDraw(ArrayList<Card> cards){
        this.playerhand.add(cards.get(0));
        cards.remove(0);
        return cards;
    }

    public void playerHand(){
        this.playerhand.forEach((val)-> System.out.printf("(%d %d) ",val.getHauteur(),val.getCouleur()));
    }


    public void calcDealerHands(){
        this.score=0;
        int plyaerScore = this.score;
        for(Card Dealerhand : this.playerhand){
            if(Dealerhand.getHauteur()==1 && plyaerScore>=10){
                this.score += 1;
                plyaerScore-=10;
            }else if(Dealerhand.getHauteur()==1 && plyaerScore<=10) {
                this.score += 11;
            }else if(Dealerhand.getHauteur()==11 || Dealerhand.getHauteur()==12 || Dealerhand.getHauteur()==13 ){
                this.score+=10;
            }else{
                this.score+=Dealerhand.getHauteur();
            }
        }
    }



}
