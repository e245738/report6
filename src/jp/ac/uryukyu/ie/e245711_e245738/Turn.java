package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.Scanner;

public class Turn {
    Scanner scanner = new Scanner(System.in);

    // プレイヤーのターン
    public void playerTurn(Player player, Deck deck) {
        while (true) {
            System.out.println(player.getName() + "、カードを引きますか？");
            System.out.println("H（一枚引く）またはS（ターン終了）を選択してください: ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("H")) {
                System.out.println(player.getName() + "はカードを引きました！");
                player.addCard(deck.draw());
                player.showHand(); // 現在の手札を表示

                if (player.isBusted()) { // バースト判定
                    System.out.println("バーストしました(21超えた)。あなたの負けです。");
                    return;
                }
            } else if (choice.equalsIgnoreCase("S")) {
                System.out.println("Sを選択しました。" + player.getName() + "のターンは終了になりました");
                break;
            } else {
                System.out.println("無効な入力です。H または S を入力してください。");
            }
        }
    }

    // ディーラーのターン
    public void dealerTurn(Player dealer, Deck deck) {
        System.out.println(dealer.getName() + "のターンです。");
        while (dealer.calculateHandValue() < 17) { // 手札の合計が17未満の場合カードを引く
            System.out.println(dealer.getName() + "はカードを引きました！");
            dealer.addCard(deck.draw());
            dealer.showHand(); // 現在の手札を表示
        }

        if (dealer.isBusted()) {
            System.out.println(dealer.getName() + "はバーストしました！");
        } else {
            System.out.println(dealer.getName() + "のターンが終了しました。");
        }
    }
}