package app.Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person{

    private static int coins=6000;
    private int bet;
    protected ArrayList<Card> playerhand = new ArrayList<Card>();

    Scanner s = new Scanner(System.in);


    public Player( String name, int win, int lose, int tie, int score, int coins,int bet) {
        super(name,score, win, lose, tie);
        this.bet = bet;
        this.coins = coins;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        Game game= new Game();
        if(this.coins>=bet){
            this.coins-=bet;
            this.bet =bet;

        }else{
            System.out.println(" :( No much Coins");
            game.betPrice();
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

    public  int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Card> getPlayerhand() {
        return playerhand;
    }

    public void CheckCoins(){
        if(this.coins<=0){
            System.out.println("Insufissant Coins");
            System.out.println(" 1=> Back to Menu");
        }
    }

    public boolean checkScore(){
        if(this.score>21){
            System.out.println("Dealer Win");
        }
        return false;
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


    public int calcPlayerHands(){
        this.score=0;
        int plyaerScore = this.score;
        for(Card playerhand : this.playerhand){
            if(playerhand.getHauteur()==1 && plyaerScore>=10){
                this.score += 1;
                plyaerScore-=10;
            }else if(playerhand.getHauteur()==1 && plyaerScore<=10) {
                this.score += 11;
            }else if(playerhand.getHauteur()==11 || playerhand.getHauteur()==12 || playerhand.getHauteur()==13 ){
                this.score+=10;
            }else{
                this.score+=playerhand.getHauteur();
            }
        }
        return  this.score;
    }



}
