package edu.csudh.figueroa.datastructures.project;

public class CardHandler<E> extends SingleLinkedList<E>{

    private final int DEFAULT_CARD_COUNT = 52;

    public CardHandler() {
        super();
    }

    public CardHandler(int shuffleCount) {
        super();
        deckBuilder();
        cutAndShuffle(shuffleCount);
    }

    private void deckBuilder() {
        int cardValue = 1;
        int index = 0;
        String suit;
        for(int i = 0; i < DEFAULT_CARD_COUNT/13; i++) {
            for(int j = 0; j < DEFAULT_CARD_COUNT/4; j++) {
                if(i == 0) {
                    if(cardValue == DEFAULT_CARD_COUNT/4 + 1) {
                        cardValue = 1;
                    }
                    suit = " Spades";
                    Card card = new Card(cardValue++, suit);

                    add(index, (E) card);

                }
                else if(i == 1) {
                    if(cardValue == DEFAULT_CARD_COUNT/4 + 1) {
                        cardValue = 1;
                    }
                    suit = " Hearts";
                    Card card = new Card(cardValue++, suit);
                    add(index, (E) card);
                }
                else if (i == 2) {
                    if(cardValue == DEFAULT_CARD_COUNT/4 + 1) {
                        cardValue = 1;
                    }
                    suit = " Clubs";
                    Card card = new Card(cardValue++, suit);
                    add(index, (E) card);
                }
                else if (i == 3) {
                    if(cardValue == DEFAULT_CARD_COUNT/4 + 1) {
                        cardValue = 1;
                    }
                    suit = " Diamonds";
                    Card card = new Card(cardValue++, suit);
                    add(index, (E) card);
                }
            }
        }
    }

    private void cutAndShuffle(int shuffleCount) {
        // shuffle the cards a random amount of time (defined by shuffleCount)
        while(shuffleCount != 0) {
            // cut the cards before shuffle
            SingleLinkedList<Card> cutOne = new SingleLinkedList<>();
            SingleLinkedList<Card> cutTwo = new SingleLinkedList<>();

            int split = DEFAULT_CARD_COUNT / 2;
            int counter = 0;
            while (counter < split) {
                cutOne.add(0, (Card) get(counter++));
            }
            while (counter < DEFAULT_CARD_COUNT) {
                cutTwo.add(0, (Card) get(counter++));
            }

            // reset the original LL to receive shuffled content
            nukeLinkedList();

            // shuffle cards after being cut
            counter = 0;
            while (counter < split) {
                add(0, (E) cutOne.get(counter));
                add(0, (E) cutTwo.get(counter));
                counter++;
            }
            shuffleCount--;
        }
    }
}
