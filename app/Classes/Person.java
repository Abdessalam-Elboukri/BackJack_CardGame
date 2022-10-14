package app.Classes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    private static final AtomicInteger id = new AtomicInteger();
    protected static String Name;
    protected  int score=0;
    protected static int win=0;
    protected static int lose=0;
    protected static int tie=0 ;



    public Person( String name,int score, int win, int lose, int tie) {
        this.Name = name;
        this.score=score;
        this.win = win;
        this.lose = lose;
        this.tie = tie;
    }

    public Person() {
    }


    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public  int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public static int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public static int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }
}