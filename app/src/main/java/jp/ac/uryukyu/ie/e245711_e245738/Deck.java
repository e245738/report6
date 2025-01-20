package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * トランプのデッキを表すクラス(このクラスはe245711D　知花昴担当）
 * ５２枚のカードを生成し、シャッフルやカードを引く機能がある。
 */

public class Deck {
    private List<Card> cards;
    
    /**
     * デッキを初期化します。
     * ハート、ダイヤ、クラブ、スペードの4つのスートと、2からAまでのランクの
     * 合計52枚のカードを生成します。
     */
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
    /**
     * デッキをシャッフルします。
     * カードの順序がランダムになります。
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    /**
     * デッキの先頭から1枚のカードを引きます。
     * 引いたカードはデッキから削除されます。
     * @return 引いたカードオブジェクト。
     */
    public Card draw() {
        return cards.remove(0); // 先頭のカードを引く
    }

}