package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Card{

    static class Cards{
        public String suit;
        public String rank;

        public Cards(String suit, String rank) {
                this.suit = suit;
                this.rank = rank;
        }
        @Override
        public String toString() {
            return suit + "の" + rank;
        }
    }
    

    public static List<Cards> createDeck() {
        String[] suits = { "ハート", "ダイヤ", "クラブ", "スペード" }; // 種類
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" }; // ランク
        List<Cards> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Cards(suit, rank));
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        List<Cards> deck = createDeck(); // トランプを用意
        Collections.shuffle(deck);
        for (Cards card : deck) {
            System.out.println(card);
        }
    }


}
