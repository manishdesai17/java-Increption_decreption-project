import java.awt.*;
import java.io.*;
import javax.swing.*;

public class img {
    static String file_name="";
    public static void Imageincrepted(int key, String increpted, String msg) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        
        try {
            BufferedWriter out = new BufferedWriter(
                new FileWriter("image.txt", true));
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;

            for (byte b : data) {
                if (increpted == "increpted") {
                    file_name=file.getName();
                    data[i] = (byte) (b ^ key);
                    System.out.println(b);
                    i++;
                } else {
                    data[i] = (byte) (data[i] ^ key);
                    System.out.println(b);
                    i++;
                }
            }
            System.out.println("file name="+file_name);
            if(increpted=="increpted")
            {
                out.write(" ");
                out.write(file_name);
            }
            FileOutputStream f = new FileOutputStream(file);
            f.write(data);
            f.close();
            fis.close();
            out.close();
            JOptionPane.showMessageDialog(null, msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setSize(700, 700);
        jframe.setLocationRelativeTo(null);

        JPanel jp = new JPanel();
        jp.add(new JLabel("Image Increption Decription"));
        jframe.getContentPane().add(jp, BorderLayout.CENTER);
        jframe.setLayout(null);
        jp.setBounds(200, 20, 300, 40);
        // first button
        JButton button1 = new JButton("Choose file for increption");
        button1.setBounds(200, 100, 350, 30);
        button1.setFont(new Font("Arial", Font.BOLD, 13));
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setForeground(Color.black);

        // second button
        JButton button2 = new JButton("Choose file for increption");
        button2.setBounds(200, 200, 350, 30);
        button2.setFont(new Font("Arial", Font.BOLD, 13));
        button2.setBackground(Color.LIGHT_GRAY);
        button2.setForeground(Color.black);

        // first text field
        JTextField jt1 = new JTextField();
        jt1.setBounds(200, 132, 350, 29);

        // second text field
        JTextField jt2 = new JTextField();
        jt2.setBounds(200, 232, 350, 29);

        // click button 1
        button1.addActionListener(e -> {
            String t = jt1.getText();
            if (t.isEmpty()) {
                JOptionPane.showMessageDialog(null, "something wrong please,enter increpted key");
            } else {
                button1.setText("please wait....");
                int temp1 = Integer.parseInt(t);
                String in = "increpted";
                String msg = "increpted sucessfully...";
                Imageincrepted(temp1, in, msg);
                button1.setText("Choose file for increption");
            }
        });

        // click button 2
        button2.addActionListener(e -> {
            String t2 = jt2.getText();
            if (t2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "something wrong please,enter decrepted key");
            } else {
                button2.setText("please wait....");
                int temp2 = Integer.parseInt(t2);
                String in = "decrepted";
                String msg = "Decrepted sucessfully...";
                Imageincrepted(temp2, in, msg);
                button2.setText("Choose file for decreption");
            }
        });

        jframe.add(button1);
        jframe.add(jt1);
        jframe.add(button2);
        jframe.add(jt2);
        jframe.add(jp);
    }
}