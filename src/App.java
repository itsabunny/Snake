import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 600; // set the width of the board
        int boardHeight = boardWidth; // make the board a square

        JFrame frame = new JFrame("Snake"); // create a frame
        frame.setVisible(true); // make the frame visible
        frame.setSize(boardWidth, boardHeight); // set the size of the frame
        frame.setLocationRelativeTo(null); // center the frame
        frame.setResizable(false); // make the frame not resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the program when the frame is closed

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight); // create a new SnakeGame object
        frame.add(snakeGame); // add the SnakeGame object to the frame
        frame.pack(); // pack the frame to fit the SnakeGame object
        snakeGame.requestFocus();
    }
}
