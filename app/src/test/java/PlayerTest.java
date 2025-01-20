import org.junit.jupiter.api.Test;
import jp.ac.uryukyu.ie.e245711_e245738.Card;
import jp.ac.uryukyu.ie.e245711_e245738.Player;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player("Subaru");

    @Test
    void testCalculateHandValueWithAce11() {

        // カードを追加
        player.addCard(new Card("ハート", "10", 10));
        player.addCard(new Card("クラブ", "A", 11));

        // 合計値が25であることを確認
        assertEquals(21, player.calculateHandValue(), "手札の合計値が正しく計算されているかテスト");
    }

    @Test
    void testCalculateHandValueWithAce1() {
        // プレイヤーを作成

        // Aを含むカードを追加
        player.addCard(new Card("ハート", "A", 1));
        player.addCard(new Card("クラブ", "K", 10));
        player.addCard(new Card("ハート", "5", 5));
        // 合計値が21であることを確認
        assertEquals(16, player.calculateHandValue(), "Aを1として計算した場合の合計値が正しいかテスト");
    }
    @Test
    void testIsBusted(){
        player.addCard(new Card("ハート", "K", 10));
        player.addCard(new Card("クラブ", "K", 10));
        player.addCard(new Card("ダイヤ", "5", 5));

        // バストしているためtrueが返されることを確認
        assertTrue(player.isBusted(), "プレイヤーがバストしているかテスト");
    }
}
