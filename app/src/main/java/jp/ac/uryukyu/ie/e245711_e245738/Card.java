package jp.ac.uryukyu.ie.e245711_e245738;
/** 
 *ターンを表すクラス。(このクラスはe245711D　知花昴担当）
 *カードを表すクラス
 *各カードはスイート、ランク、値を持ちます。
 */
public class Card{

    private String suit;
    /** カードのスート（例: "ハート", "ダイヤ"など）。 */
    private String rank;
    /** カードのランク（例: "A", "2", "K"など）。 */
    private int value;
    /** カードの値（ゲームのルールに基づいた数値的価値）。 */

    /**
     * Cardクラスのコンストラクタ。
     *
     * @param suit カードのスート
     * @param rank カードのランク
     * @param value カードの値
     */
    public Card(String suit, String rank, int value) {
            this.suit = suit;
            this.rank = rank;
            this.value = value;

    }
    
    /**
     * カードのスートを取得します。
     * @return カードのスート
     */
    public String getSuit(){
        return suit;

    }

    /**
     * カードのランクを取得します。
     * @return カードのランク
     */
    public String getRank(){
        return rank;

    }

    /**
     * カードの値を取得します。
     * @return カードの値
     */
    public int getValue(){
        return value;

    }
    
    /**
     * カードの文字列表現を返します。
     * 例: "ハートのA"
     * @return カードのスートとランクを組み合わせた文字列
     */
    @Override
    public String toString() {
        return suit + "の" + rank;
    }
}