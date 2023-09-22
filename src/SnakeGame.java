import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{
    private class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    //Snake
    Tile snakeHead;

    //Food
    Tile food;
    Random random;

    //game logic
    Timer gameLoop;
    int velocityX;
    int velocityY;

    SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.BLACK);

        snakeHead = new Tile(5,5);

        food = new Tile(10,10);
        random = new Random();
        placeFood();

        velocityX = 0;
        velocityY = 0;

        gameLoop = new Timer(100, this);
        gameLoop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //Grid
        for (int i = 0; i < boardWidth/tileSize;i++){
            //(x1, y1, x2, y2)
            g.drawLine(i*tileSize,0,i*tileSize, boardHeight);
            g.drawLine(0,i*tileSize,boardWidth,i*tileSize);
        }

        //Food
        g.setColor(Color.RED);
        g.fillRect(food.x*tileSize,food.y*tileSize, tileSize, tileSize);

        //Snake
        g.setColor(Color.GREEN);
        g.fillRect(snakeHead.x*tileSize,snakeHead.y*tileSize,tileSize,tileSize);
    }

    public void placeFood(){
        food.x = random.nextInt(boardWidth/tileSize);  // 600/25=24
        food.y = random.nextInt(boardHeight/tileSize);
    }

    public void move(){
        //Snake Head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override  //don't need this
    public void keyTyped(KeyEvent e) {}

    @Override  //don't need this
    public void keyReleased(KeyEvent e) {}
}