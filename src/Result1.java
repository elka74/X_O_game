
import javax.swing .*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.Border;


    public class Result1 extends JFrame {

        private BattleMap battleMap;

        public Result1(BattleMap battleMap) {
            this.battleMap = battleMap;
            setBounds(600, 430, 515, 200);
            setResizable(false);

                JLabel label_O;
                label_O = new JLabel(Logic.s1(), JLabel.RIGHT);
                label_O.setVerticalAlignment(JLabel.CENTER);
                label_O.setHorizontalAlignment(JLabel.CENTER);
                label_O.setFont(new Font("Verdana", Font.BOLD, 20));
                label_O.setPreferredSize(new Dimension(515, 100));
                label_O.setForeground(new Color(29, 120, 7));
                label_O.setOpaque(true);
                label_O.setBackground(new Color(180, 185, 127));
                Border border_O = BorderFactory.createLineBorder(Color.YELLOW);
                label_O.setBorder(border_O);
                add(label_O);
                // label_O.setVisible(false);


        }
    }

