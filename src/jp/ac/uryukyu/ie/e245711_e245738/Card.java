package jp.ac.uryukyu.ie.e245711_e245738;

public class Card{

    private String suit;
    private String rank;
    private int value;

    public Card(String suit, String rank, int value) {
            this.suit = suit;
            this.rank = rank;
            this.value = value;

    }

    public String getSuit(){
        return suit;

    }
    public String getRank(){
        return rank;

    }
    public int getValue(){
        return value;

    }

    @Override
    public String toString() {
        return suit + "の" + rank;
    }
}