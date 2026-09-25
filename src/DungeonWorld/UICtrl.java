package DungeonWorld;

import javax.swing.*;

public abstract class UICtrl {
    protected JFrame frame;
    public UICtrl(){
        frame = new JFrame();
        frame.setTitle("Chungus UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
