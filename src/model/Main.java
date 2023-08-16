package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * It is the Game class.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch 
 * @version 1.0
 */
public class Main
{
    private ArrayList<Player> players;
    private Deck decks; // the Deck
    private ArrayList<Card> deck;
    private Pile pile;
    private ArrayList<Card> cardPile;
    private static final int IC = 7; //Initial count
    private static final int PC = 4; //Player count
    private Player playingPlayer;
    private int inc; //Add Card
    private static final int NC = 1; //No Card
    private static final String WILD = "wild";
    private static final String WILDFOUR = "wild_four";
    private Flow flow;

    /**
     * Main function that allows us to play.
     * 
     * @param ids is the name of the player 
     */
    public Main(ArrayList<String> ids) {
        Deck deck = new Deck();
        deck.fillDeck();
        this.decks = deck;
        this.deck = this.decks.showDeck();
        players = new ArrayList<Player>();
        for (String id: ids) {
            Player player = new Player(id);
            player.draw(this.deck, IC);
            players.add(player);
        }
        this.players = players;
        Pile pile = new Pile(this.deck);
        this.pile = pile;
        this.cardPile = this.pile.pile();
        Random rand = new Random();
        this.playingPlayer = players.get(rand.nextInt(PC));
        this.flow = new Flow(players, this.playingPlayer);
        this.inc = 0;
    }

    /**
     * Moves the cards from the players to the pile.
     * 
     * @param index of the cards in player's hand.
     * @return the next player to play
     */
    public Player playCard(int index) {
        Card card = this.playingPlayer.getHand().get(index);
        Card topCard = this.pile.topCard();
        GameLogic logic = new GameLogic(topCard.getColor(), topCard.getValue());

        if (logic.correctCard(card, this.inc)) {
            if (wildCard()) {
                resetWild();
            }
            this.playingPlayer.play(index, this.cardPile);
            Handler handle = new Handler(card, this.flow);
            ActionCards execute = handle.getCMD();
            this.inc = execute.incrementer(this.inc, topCard);
            this.playingPlayer = execute.nextPlayer();
        } 
        return this.playingPlayer;
    }

    /**
     * In case the players has no cards.
     * 
     * @return current player
     */
    public Player noCard() {
        MoveCard move = new MoveCard(this.deck);
        shuffleCards();
        if (inc > 0) {
            move.dtp(this.playingPlayer.getHand(), inc);
            this.inc = 0;
        } else {
            move.dtp(this.playingPlayer.getHand(), NC);
        }
        this.playingPlayer = this.flow.normal();
        return this.playingPlayer;
    }

    /**
     * Determine if the player can play.
     * 
     * @param topCard is the card on the pile
     * @return if the card tha the player want to play is valid or not
     */
    public Boolean canPlay(Card topCard) {
        ArrayList<Card> hand = this.playingPlayer.getHand();
        GameLogic logic = new GameLogic(topCard.getColor(), topCard.getValue());
        for (Card card: hand) {
            if (logic.canPlay(card, this.inc)) {
                return true;
            }
        } 
        return false;
    }

    /**
     * it shuffle the cards.
     */
    public void shuffleCards() {
        if (inc > this.deck.size() || NC > this.deck.size()) {
            MoveCard movePile = new MoveCard(this.cardPile);
            movePile.ptd(this.deck);
            this.decks.shuffle();
        }
    }

    /**
     * It is the index of the top card on the pile.
     * 
     * @return the index of the top card on the pile
     */
    public int topIndex() {
        return this.pile.numPile() - 1;
    }

    /**
     * It changes the color of the WILD cards to n.
     *
     */
    private void resetWild() {
        Card card = new Card("n_" + topCard().getValue());
        this.cardPile.remove(topIndex());
        this.cardPile.add(card);
    }

    /**
     * It shows the card of the deck.
     * 
     * @return the list of the cards of the deck
     */
    public ArrayList<Card> accessDeck() {
        return this.decks.showDeck();
    }

    /**
     * return the incrementer.
     * 
     * @return the incrementer.
     */
    public int returnAC() {
        return this.inc;
    }

    /**
     * Determine if it is a WILD cards or not.
     * 
     * @return if the card is a WILD card or not
     */
    public Boolean wildCard() {
        return WILD.equals(this.pile.topCard().getValue())
            || WILDFOUR.equals(this.pile.topCard().getValue());
    }

    /**
     * Determine the top card on the pile.
     * 
     * @return the top card
     */
    public Card topCard() {
        return this.pile.topCard();
    }

    /**
     * Determine the player that is playing.
     * 
     * @return the player that is playing
     */
    public Player playingP() {
        return this.playingPlayer;
    }

    /**
     * Number of cards the player hads.
     * 
     * @return the number of cards player hads.
     */
    public int handSize() {
        return this.playingPlayer.cardCount();
    }

    /**
     * Determine the WILD card color.
     * 
     * @param color the color of the WILD card
     *
     */
    public void wildColor(String color) {
        Card topCard = this.pile.topCard();
        WildCard wild = new WildCard(topCard, this.flow);
        topCard = wild.colorWild(color);
        this.cardPile.remove(topIndex());
        this.cardPile.add(topCard);
    }

    /**
     * list of the players.
     * 
     * @return the list of the players
     */
    public ArrayList<Player> players() {
        return this.players;
    }
}
