import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("Player X's turn");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);

        currentPlayer = 'X';
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().isEmpty()) {
            button.setText(Character.toString(currentPlayer));
            button.setEnabled(false);
            if (checkWin()) {
                statusLabel.setText("Player " + currentPlayer + " wins!");
                disableButtons();
            } else if (isBoardFull()) {
                statusLabel.setText("It's a draw!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                statusLabel.setText("Player " + currentPlayer + "'s turn");
            }
        }
    }

    private boolean checkWin() {
        String[][] boardValues = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardValues[i][j] = buttons[i][j].getText();
            }
        }
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!boardValues[i][0].isEmpty() && boardValues[i][0].equals(boardValues[i][1]) &&
                boardValues[i][1].equals(boardValues[i][2])) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (!boardValues[0][j].isEmpty() && boardValues[0][j].equals(boardValues[1][j]) &&
                boardValues[1][j].equals(boardValues[2][j])) {
                return true;
            }
        }
        // Check diagonals
        if (!boardValues[0][0].isEmpty() && boardValues[0][0].equals(boardValues[1][1]) &&
            boardValues[1][1].equals(boardValues[2][2])) {
            return true;
        }
        if (!boardValues[0][2].isEmpty() && boardValues[0][2].equals(boardValues[1][1]) &&
            boardValues[1][1].equals(boardValues[2][0])) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGUI game = new TicTacToeGUI();
        game.setVisible(true);
    }
}
