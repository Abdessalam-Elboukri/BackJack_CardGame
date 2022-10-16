package app.Classes;

import java.util.ArrayList;
import java.util.Random;

public class Dealer extends Person {

    private ArrayList<Card> ShuffledCards = new ArrayList<Card>();
    private ArrayList<Card> Dealerhand = new ArrayList<Card>();


    public Dealer(String name, int score, int win, int lose, int tie, ArrayList<Card> shuffledCards, ArrayList<Card> dealerhand) {
        super(name, score, win, lose, tie);
        ShuffledCards = shuffledCards;
        Dealerhand = dealerhand;
    }


    public Dealer() {
    }

    public void dealerHand(){
        this.Dealerhand.forEach((val)-> System.out.printf("(%d %d) ",val.getHauteur(),val.getCouleur()));
    }

    public void Shuffled(ArrayList arr) {
        for(int i =0;i<100;i++){
            ArrayList card = tirerUneCarte(arr);
            ShuffledCards = (ArrayList) card.get(1);
            ShuffledCards.add((Card) card.get(0));
        }
    }

    public ArrayList tirerUneCarte(ArrayList arr) {
            Random random = new Random();
            int n = random.nextInt(52);
            return extraireCarte(arr, n);
    }


    public static ArrayList extraireCarte(ArrayList arr1, int n) {
        ArrayList cardlist = new ArrayList<>();
        Card carteTire;
        carteTire = (Card) arr1.get(n);
        arr1.remove(n);
        cardlist.add(carteTire);
        cardlist.add(arr1);
        return cardlist;
    }

    public ArrayList<Card> DealerDraw(ArrayList<Card> cards){
        this.Dealerhand.add(cards.get(0));
        cards.remove(0);
        return cards;
    }

        public int calcDealerHands(){
        this.score=0;
        int DealerScore = this.score;
        for(Card Dealerhand : this.Dealerhand){
            if(Dealerhand.getHauteur()==1 && DealerScore>=10){
                this.score += 1;
                DealerScore-=10;
            }else if(Dealerhand.getHauteur()==1 && DealerScore<=10) {
                this.score += 11;
            }else if(Dealerhand.getHauteur()==11 || Dealerhand.getHauteur()==12 || Dealerhand.getHauteur()==13 ){
                this.score+=10;
            }else{
                this.score+=Dealerhand.getHauteur();
            }
        }
        return  this.score;
        }

    public void piocheCarte(ArrayList<Card> piocheCard,Player player){
        this.Dealerhand.add(piocheCard.get(0));
        piocheCard.remove(0);
        player.playerhand.add(piocheCard.get(0));
        piocheCard.remove(0);
        player.playerhand.add(piocheCard.get(0));
        piocheCard.remove(0);
        this.Dealerhand.add(piocheCard.get(0));
        piocheCard.remove(0);
    }

        public void ShowFirstCardDealer(){
            System.out.println(this.Dealerhand.get(0));
        }




}
