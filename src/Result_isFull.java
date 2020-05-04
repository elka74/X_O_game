import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.Border;
public class Result_isFull extends JFrame {
    private BattleMap battleMap;
    public  Result_isFull(BattleMap battleMap) {
        this.battleMap = battleMap;
        setBounds(600, 430, 515, 200);
        setResizable(false);

            JLabel label_F;
            label_F = new JLabel(Logic.s2(), JLabel.RIGHT);
            label_F.setVerticalAlignment(JLabel.CENTER);
            label_F.setHorizontalAlignment(JLabel.CENTER);
            label_F.setFont(new Font("Verdana", Font.BOLD, 40));
            label_F.setPreferredSize(new Dimension(515, 100));
            label_F.setForeground(new Color(29, 120, 7));
            label_F.setOpaque(true);
            label_F.setBackground(new Color(180, 185, 127));
            Border border_F = BorderFactory.createLineBorder(Color.YELLOW);
            label_F.setBorder(border_F);
            add(label_F);
            //label_F.setVisible(false);


    }
}
