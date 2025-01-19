package jp.ac.uryukyu.ie.e245711_e245738;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("プレイヤー");
        Player dealer = new Player("ディーラー");
        Deck deck = new Deck();
        Turn turn = new Turn();
        
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
        
        turn.playerTurn(player, deck);
        
        if (!player.isBusted()) { // プレイヤーがバーストしていなければディーラーのターン
            turn.dealerTurn(dealer, deck);
        }

        System.out.println("最終結果:");
        System.out.println(player.getName() + "の手札:");
        player.showHand();
        System.out.println(dealer.getName() + "の手札:");
        dealer.showHand();
        
        if (dealer.calculateHandValue() > 21 || player.calculateHandValue() > dealer.calculateHandValue()) {
            System.out.println("プレイヤーの勝ちです！");
        } else if (player.calculateHandValue() < dealer.calculateHandValue()) {
            System.out.println("プレイヤーの負けです！");
        } else {
            System.out.println("引き分けです！");
        }

    }
}