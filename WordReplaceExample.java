import javax.swing.*;
import java.awt.event.*;

public class WordReplaceExample extends JFrame {

    private JTextField textField;

    private static final String[] WORDS = {
            "Apple", "Ball", "Cat", "Dog", "Elephant",
            "Fish", "Giraffe", "Horse", "Ice Cream", "Jellyfish",
            "Kangaroo", "Lion", "Monkey", "Noodle", "Octopus",
            "Penguin", "Queen", "Rabbit", "Sunflower", "Tiger",
            "Umbrella", "Van", "Watermelon", "Xylophone", "Yellow",
            "Zebra"
    };

    public WordReplaceExample() {
        super("Word Replace Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = Character.toLowerCase(e.getKeyChar());
                if (Character.isAlphabetic(c)) {
                    String word = WORDS[c - 'a'];
                    textField.setText(word.substring(0, 1) + word.substring(1).toLowerCase());
                    e.consume();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordReplaceExample().setVisible(true));
    }
}
