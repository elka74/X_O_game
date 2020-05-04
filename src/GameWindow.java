import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WIN_HEIGHT = 570;
    private static final int WIN_WIDTH  = 515;
    private static final int WIN_POS_X  = 600;
    private static final int WIN_POS_Y  = 300;

    private StartNewGameWindow startNewGameWindow;
    private BattleMap field;
    private Result result;

    public GameWindow(){
        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Крестики - нолики");
        setResizable(false);

        startNewGameWindow = new StartNewGameWindow(this);
        field = new BattleMap(this);
        add(field,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("Начало игры");
        bottomPanel.add(btnNewGame);

        btnNewGame.addActionListener(e->{
            startNewGameWindow.setVisible(true);

        });

        JButton btnExit = new JButton("Выход из игры");
        bottomPanel.add(btnExit);

        btnExit.addActionListener(e->{
            System.exit(0);
        });

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        field.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}

