package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Test extends JFrame {

    public Test() {
        super("TextField with Floating Button");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 180);
        setLocationRelativeTo(null);

        // ── Main panel with padding ──
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // ── The text field wrapper ──
        JPanel textWrapper = new JPanel(new BorderLayout());
        textWrapper.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(new Color(120, 120, 120)),
            BorderFactory.createEmptyBorder(2, 8, 2, 2)
        ));

        JTextField txt = new JTextField("Type something...");
        txt.setBorder(null);           // remove default border
        txt.setPreferredSize(new Dimension(300, 42));
        txt.setFont(txt.getFont().deriveFont(15f));

        // Small clear / action button
        JButton btn = new JButton("×");           // or "🔍" or icon
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(Color.GRAY);
        btn.setFont(btn.getFont().deriveFont(18f));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btn.setForeground(Color.RED);
            }
            @Override public void mouseExited(MouseEvent e) {
                btn.setForeground(Color.GRAY);
            }
        });

        btn.addActionListener(e -> {
            txt.setText("");
            txt.requestFocus();
        });

        // Put button on the right
        textWrapper.add(txt, BorderLayout.CENTER);
        textWrapper.add(btn, BorderLayout.EAST);

        mainPanel.add(textWrapper, BorderLayout.NORTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }
}