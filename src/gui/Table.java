package gui;

import model.HUNO;
import model.Main;
import model.Player;
import model.Winner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * It is the table frame.
 *
 * @author bonetgi@usi.ch, rimh@usi.ch
 * @version 1.0
 */
public class Table extends Frame implements ActionListener
{

    private Panel panelOne;
    private Panel panelFive;
    private Button button;
    private Main main;
    private Cards card;
    private ArrayList<String> ids;
    private HashMap cards;
    private Boolean difficulty;
    private HUNO huno;
    private Winner winner;
    private int num;
    private int start;
    private static final int XAXIS = 1500;
    private static final int YAXIS = 1000;
    private static final String HUNO = "HUNO";
    private static final String QUIT = "QUIT";
    private static final String NEXT = "NEXT";
    private static final String EMPTY = "";

    /**
     * It is the constructor of the table with all the cards and the deck.
     * 
     * @param main the main 
     * @param difficulty or aggressive or easy
     * @param num the number of players
     */
    public Table(Main main, Boolean difficulty, int num) {
        super(XAXIS, YAXIS);
        this.ids = ids;
        this.difficulty = difficulty;
        this.num = num;
        this.main = main;
        winner = new Winner(main.players());
        if (winner.winner()) {
            getFrame().dispose();
            new WinPage(winner.winPlayer().playerID());
        }
        huno = new HUNO(main.players());
        card = new Cards();
        start = main.players().indexOf(main.playingP());

        

        Button button = new Button(new ImageIcon("image/deck.png"), 600, 350, 100, 200, EMPTY);
        Button buttonOne = new Button(new ImageIcon("image/quit.png"),1300, 880, 145, 75, QUIT);
        Button buttonTwo = new Button(new ImageIcon("image/next.png"), 1300, 50, 145, 75, NEXT);
        buttonTwo.setVisible(ai());
        Button buttonThree = new Button(new ImageIcon("image/huno.png"), 100, 900, 145, 75, HUNO);
        buttonThree.setVisible(huno.hunoChecker());

        panelOne = new Panel(150,600,1150,300);
        Panel panelTwo = new Panel(700, 20,100,150);
        Panel panelThree = new Panel(50,350,100, 150);
        Panel panelFour = new Panel(1350,350,100,150); 
        panelFive = new Panel(750,380,90,140);

        cardsHadsOther(panelTwo, (start + 2) % 4);
        cardsHadsOther(panelThree, (start + 3) % 4);
        cardsHadsOther(panelFour, (start + 1) % 4);

        card.fillMap();
        cards = card.getMap();
        Button topCard = new Button(new ImageIcon("" + cards.get(main.topCard().getCard())), 10,10,90,110, EMPTY);
        panelFive.add(topCard);

        cardsHand();
        getFrame().add(button); 
        getFrame().add(buttonOne);
        buttonOne.addActionListener(this);
        getFrame().add(buttonTwo);
        buttonTwo.addActionListener(this);
        getFrame().add(buttonThree);
        buttonThree.addActionListener(this);

        getFrame().add(panelOne);
        getFrame().add(panelTwo);
        getFrame().add(panelThree);
        getFrame().add(panelFour);
        getFrame().add(panelFive);
        getFrame().setLayout(null);    
        getFrame().setVisible(true);
        noCardCase();
    }

    /**
     * it shows the cards that the players has in his hand.
     */
    public void cardsHand() {
        JLabel playerInfo = new JLabel(main.playingP().playerID() + " " + main.handSize() + "cards");
        panelOne.add(playerInfo);
        for (int i = 0; i < main.handSize() ; i++) {
            String curser;
            if (main.players().indexOf(main.playingP()) < num) {
                curser = Integer.toString(i); 
            } else {
                curser = "";
            }
            Button buttonCards = new Button(new ImageIcon("" + cards.get(main.playingP().getHand().get(i).getCard())),10 + (10 * i), 680, 88, 110, curser);
            buttonCards.addActionListener(this);
            panelOne.add(buttonCards);
        } 
    }

    /**
     * the cards that the other players have in their hands.
     * 
     * @param panel is the panel where to insert the cards
     * @param position the position of the card
     */
    public void cardsHadsOther(JPanel panel, int position) {
        Button backCard = new Button(new ImageIcon("image/Icon.png"), 0, 0, 100, 100, EMPTY);
        panel.add(backCard.getButton());
        Player player = main.players().get(position);
        JLabel playerInfo = new JLabel(player.playerID() + " " + player.cardCount() + "cards");
        panel.add(playerInfo);
    }

    private Boolean ai() {
        return main.players().indexOf(main.playingP()) >= num;
    }

    private Table noCardCase() {
        if (!(this.main.canPlay(this.main.topCard()))) {
            this.main.noCard();
            getFrame().dispose();
            new Table(this.main, difficulty, num);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JFrame frame = getFrame();
        String command = event.getActionCommand();
        GuiCommand executable;
        if (command.equals(EMPTY)) {
            new Table(main, difficulty, num);
        } else if (command.equals(HUNO)) {
            huno.hunoEffect(huno.personAtHuno().playerID(), main.accessDeck());
        }
        switch (command) {
            case QUIT: executable = new GuiCommand(main, command, frame);
                break;
            case NEXT: executable = new Next(main, command, frame);
                break;
            default: executable = new Play(main, command, frame);
                break; 
        }
        executable.execute(this.difficulty, num);
    }
}
