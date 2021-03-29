package edu.csudh.figueroa.datastructures.project;

public class Card {

    private int value;
    private String suit;
    private String cardLabel;

    // Developer defined card
    public Card(int value, String suit) {
        setValue(value);
        setSuit(suit);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        setCardLabel();

    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCardLabel() {
        return this.cardLabel;
    }

    public void setCardLabel() {
        switch(this.value) {
            case 1 :
                this.cardLabel = "Ace of";
                break;
            case 13 :
                this.cardLabel = "King of";
                break;
            case 12 :
                this.cardLabel = "Queen of";
                break;
            case 11 :
                this.cardLabel = "Jack of";
                break;
            default :
                this.cardLabel = this.value + " of";
                break;
        }
    }

    public String toString() {
        String s = "[" + getCardLabel() + getSuit() + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return getSuit().equals(card.getSuit());
    }

}
