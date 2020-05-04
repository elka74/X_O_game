

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;

    private int cellHeight;
    private int cellWidth;
    private Result result;
    private Result1 result1;
    private Result_isFull result_isFull;
    private boolean isInit = false;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        result = new Result(this);
        result1 = new Result1(this);
        result_isFull = new Result_isFull(this);
    }



    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!Logic.gameFinished){
            Logic.setHumanXY(cellX, cellY);
        }
        if (Logic.gameFinished && Logic.checkWinLines(Logic.DOT_X)){
                result.setVisible(true);
            }
            if (Logic.gameFinished && Logic.checkWinLines(Logic.DOT_O)){
                result1.setVisible(true);
            }else if (Logic.gameFinished && Logic.isFull()){
                result_isFull.setVisible(true);
            }

        repaint();
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE ; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j]==Logic.DOT_O){
                    drawO(g,j,i);
                }
                if(Logic.map[i][j]==Logic.DOT_X){
                    drawX(g,j,i);
                }
            }
        }
    }
    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke((float) (cellWidth * 0.1)));
        g.setColor(new Color(31, 255, 45));
        g.drawOval(((cellX * cellWidth) + (cellWidth / 4)), ((cellY * cellHeight) + (cellHeight / 8)), (int) ((float) cellWidth - (cellWidth * 0.5)), (int) ((float) cellHeight - (cellHeight * 0.2)));

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke((float) (cellWidth * 0.1)));
        g.setColor(new Color(26, 250, 255));
        g.drawLine((cellX * cellWidth) + (cellWidth / 4), (cellY * cellHeight) + (cellHeight / 9),
                (cellX + 1) * cellWidth - (cellWidth / 4), (cellY + 1) * cellHeight - (cellHeight / 9));
        g.drawLine((cellX + 1) * cellWidth - (cellWidth / 4), (cellY * cellHeight) + (cellHeight / 9),
                (cellX * cellWidth) + (cellWidth / 4), (cellY + 1) * cellHeight - (cellHeight / 9));

    }

      void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        isInit = true;
        repaint();
    }


    }




