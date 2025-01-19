package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = { "ハート", "ダイヤ", "クラブ", "スペード" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0); // 先頭のカードを引く
    }

}

