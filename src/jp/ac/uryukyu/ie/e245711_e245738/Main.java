package jp.ac.uryukyu.ie.e245711_e245738;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("プレイヤー");
        Player dealer = new Player("ディーラー");

        Deck deck = new Deck();
        System.out.println("BlackJackスタート！！");
        deck.shuffle();
        player.addCard(deck.draw());
        player.addCard(deck.draw());
        dealer.addCard(deck.draw());
        dealer.addCard(deck.draw());
        System.out.println(player.getName() + "の手札");
        player.showHand();
        System.out.println(dealer.getName() + "の手札:");
        dealer.showHand();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(player + "カードを引きますか？");
            System.out.println("H（一枚引く）またはS（ターン終了）を選択してください: ");
            
            String choice = scanner.nextLine().trim();

            if (choice.equals("H")) {
                System.out.println(player + "はカードを引きました！");
                player.addCard(deck.draw());
                player.getHand();
                if(player.isBusted()) {
                    System.out.println("バーストしました(21超えた)。あなたの負けです。");
                    return;
                }
            } else if (choice.equals("S")) {
                System.out.println("Sを選択しました。" + player + "のターンは終了になりました");
                break;                
            }
        }
        System.out.println(dealer.getName() + "のターンです。");
        while (dealer.calculateHandValue() < 17) { // 手札の合計が17未満の場合カードを引く
            System.out.println(dealer.getName() + "はカードを引きました！");
            dealer.addCard(deck.draw());
            dealer.showHand(); // 現在の手札を表示
        }

        if (dealer.isBusted()) {
            System.out.println(dealer.getName() + "はバーストしました！あなたの勝ちです！");
        } else {
            System.out.println(dealer.getName() + "のターンが終了しました。");
        }  
    }
}