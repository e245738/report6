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
        
        System.out.println(player);
        player.showHand();
        System.out.println(dealer);
        dealer.showHand();
        
        turn.playerTurn(player, deck);
        
        if (!player.isBusted()) { // プレイヤーがバーストしていなければディーラーのターン
            turn.dealerTurn(dealer, deck);
        }

        System.out.println("最終結果:");
        System.out.println(player);
        player.showHand();
        System.out.println(dealer);
        dealer.showHand();
        
        if (player.isBusted()) {
            System.out.println("あなたの手札がバーストしました！ ディーラーの勝ちです。");
        } 
        else if (dealer.isBusted()) {
            System.out.println("ディーラーの手札がバーストしました！ あなたの勝ちです！");
        } 
        else if (player.calculateHandValue() > dealer.calculateHandValue()) {
            System.out.println("あなたの勝ちです！");
        } 
        else if (player.calculateHandValue() < dealer.calculateHandValue()) {
            System.out.println("ディーラーの勝ちです！");
        } 
        else {
            System.out.println("引き分けです");
        }
    }
}