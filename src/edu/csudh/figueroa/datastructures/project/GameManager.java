package edu.csudh.figueroa.datastructures.project;

public class GameManager {

    public final int DEFAULT_ROUNDS = 10;
    private CardHandler<Card> playableDeck;
    private CardHandler<Card> firstPlayerDeck;
    private CardHandler<Card> secondPlayerDeck;
    private CardHandler<Card> discardedDeck = new CardHandler<>();
    private final int DEFAULT_CARD_COUNT = 52;

    private int[][] scoreBoard;

    public GameManager(int shuffleCount) {
        playableDeck = new CardHandler<>(shuffleCount);
        firstPlayerDeck = new CardHandler<>();
        secondPlayerDeck = new CardHandler<>();
        discardedDeck = new CardHandler<>();
        scoreBoard = new int[2][10]; // 2 players for 10 rounds
        dealCards();
        StartGame();
    }

    private void StartGame() {
        int roundsPlayed = 0;
        while(roundsPlayed < DEFAULT_ROUNDS) {
            System.out.printf("ROUND %d: \n", roundsPlayed+1);

            //current scoreboard & top card on card pile
            if(discardedDeck.size() == 0) {
                System.out.printf("Target Card: %s", "No target card to match.\n");
            }
            else {
                System.out.printf("Target Card: %s\n", discardedDeck.get(0));
            }

            // player 1 begins
            System.out.printf("Player One places a card: %s\n", firstPlayerDeck.get(roundsPlayed));
            if(discardedDeck.size() < 0) {
                if (compare(firstPlayerDeck.get(roundsPlayed))) {
                    discardedDeck.add(0, firstPlayerDeck.get(roundsPlayed));
                    scoreBoard[0][roundsPlayed] = discardedDeck.size();
                    winnerUpdate(roundsPlayed);
                }
            }
            else {
                discardedDeck.add(0, firstPlayerDeck.get(roundsPlayed));
            }



            //current scoreboard & top card on card pile
            if(discardedDeck.size() == 0) {
                System.out.printf("\nTarget Card: %s", "No target card to match.");
            }
            else {
                System.out.printf("\nTarget Card: %s", discardedDeck.get(0));
            }

            // player 2 begins
            System.out.printf("\nPlayer Two places a card: %s\n", secondPlayerDeck.get(roundsPlayed));
            if(discardedDeck.get(0) != null) {
                    discardedDeck.add(0, secondPlayerDeck.get(roundsPlayed));
                    scoreBoard[1][roundsPlayed] = discardedDeck.size();
                    winnerUpdate(roundsPlayed);
            }
            else {
                discardedDeck.add(0, secondPlayerDeck.get(roundsPlayed));
            }
            roundsPlayed++;
        }
    }


    private void winnerUpdate(int roundsPlayed) {
        System.out.printf("********     WE HAVE A WINNER!!     ********\n");
        System.out.printf("%d cards were added to your score board for round %d\n", discardedDeck.size(), roundsPlayed+1);
        discardedDeck.nukeLinkedList();
    }

    private boolean compare(Card card) {
        return card.equals(this.discardedDeck.get(0));
    }

    private void dealCards() {
        int split = DEFAULT_CARD_COUNT / 2;
        int counter = 0;
        while (counter < split) {
            this.firstPlayerDeck.add(0, (Card) playableDeck.get(counter++));
        }
        while (counter < DEFAULT_CARD_COUNT) {
            this.secondPlayerDeck.add(0, (Card) playableDeck.get(counter++));
        }
    }
}
