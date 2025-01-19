package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.List;
import java.util.ArrayList;

public class Player{
    private String name;
    private List<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);

    }
    // 手札のカードを表示
    public void showHand() {
        for (Card card : hand) {
            System.out.println(card); 
        }
    }

    public int calculateHandValue() {
        int total = 0;
        int aceCount = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++;
            }
        }

        // Aを1に変換する場合
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    
    }
    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public boolean isBusted() {
        return calculateHandValue() > 21;
    }

    @Override
    public String toString() {
        return name + "の手札: " + hand + " (合計: " + calculateHandValue() + ")";
    }


}