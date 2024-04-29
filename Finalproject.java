import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel reset_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton reset_button = new JButton();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean isDraw = false;
    int count=0;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);
        frame.getContentPane().setBackground(new Color(255, 192, 203));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(255, 192, 203));
        textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("DialogInput", Font.BOLD, 88));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe Game");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        reset_panel.setLayout(new BorderLayout());
        reset_panel.setBounds(0,800,800,100);


        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(255, 192, 203));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("DialogInput", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(88,51,24));
            buttons[i].setBorder(BorderFactory.createBevelBorder(1, new Color(225, 192, 130),new Color(75, 0, 130), Color.yellow, Color.white));
            buttons[i].addActionListener(this);
        }

        reset_button.setBackground(new Color(225, 192, 203));
        reset_button.setForeground(new Color(225, 16, 203));
        reset_button.setFont(new Font("DialogInput", Font.BOLD, 77));
        reset_button.setHorizontalAlignment(JLabel.CENTER);
        reset_button.setText("New Game");
        reset_button.addActionListener(this);
        reset_button.setFocusable(false);


        title_panel.add(textfield);
        reset_panel.add(reset_button);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(reset_panel, BorderLayout.SOUTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset_button) {
            reset();
            }   
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        count ++;
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.darkGray);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        count ++;
                        check();
                        
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //check X win conditions
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
        // Draw conditions
        if ((count == 9) && (textfield.getText() != "O wins") && (textfield.getText() != "X wins")) {
            drawMatch();
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.white);
        buttons[b].setBackground(Color.white);
        buttons[c].setBackground(Color.white);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins >_< ");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(170, 51, 106));
        buttons[b].setBackground(new Color(170, 51, 106));
        buttons[c].setBackground(new Color(170,51,106));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins >_<");
    }
    public void drawMatch() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Draw");
    }
    public void reset() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(""); 
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(88,51,24)); 
        }
        firstTurn(); 
        count = 0;  
    }

}
public class Finalproject
{

    public static void main(String[] args) {

        TicTacToe tictactoe = new TicTacToe();

    }
}
