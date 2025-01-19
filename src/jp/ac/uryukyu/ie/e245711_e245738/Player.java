package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.List;
import java.util.ArrayList;
/**
 * ゲームのプレイヤーを表現するクラス。
 * プレイヤーは名前と手札を持ち、手札の管理やスコア計算を行います。
 */
public class Player{
    private String name;
    private List<Card> hand;
    
    /**
     * プレイヤーを初期化します。
     * @param name プレイヤーの名前
     */
    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }
    /**
     * 手札にカードを追加します。
     * @param card 追加するカード
     */
    public void addCard(Card card) {
        hand.add(card);

    }
    
    /**
     * 手札のカードを表示します。
     * 手札のすべてのカードを1行ずつ標準出力に出力します。
     */
    public void showHand() {
        for (Card card : hand) {
            System.out.println(card); 
        }
    }
    
    /**
     * 手札の合計値を計算します。
     * A（エース）は合計が21を超える場合に1として扱います。
     * @return 手札の合計値
     */
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
    /**
     * 現在の手札を取得します。
     * 
     * @return プレイヤーの手札（List形式）
     */
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