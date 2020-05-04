import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.Border;


public class Result extends JFrame {

    private BattleMap battleMap;
    public  Result(BattleMap battleMap) {
        this.battleMap = battleMap;
        setBounds(600, 430, 515, 200);
        setResizable(false);

                JLabel label;
                label = new JLabel(Logic.s(), JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("Verdana", Font.BOLD, 40));
                label.setPreferredSize(new Dimension(515, 100));
                label.setForeground(new Color(29, 120, 7));
                label.setOpaque(true);
                label.setBackground(new Color(180, 185, 127));
                Border border = BorderFactory.createLineBorder(Color.YELLOW);
                label.setBorder(border);
                add(label);



    }

}

