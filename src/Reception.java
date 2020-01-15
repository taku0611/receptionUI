

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 数字チェックとメッセージダイアログ
 */
public class Reception extends JFrame {

    private static final String btnNumberCheck_title = "住所を確認する";
    private static final String btnNumberCheck_code = "Integer Check";
    private static final String window_title = "配達依頼";
    private static final int tf01_size = 20;
    private static final int tf02_size = 20;
    private static final int tf03_size = 20;

    static JTextField textClientname = new JTextField("", Reception.tf01_size);
    static JTextField textReceivername = new JTextField("", Reception.tf02_size);
    static JTextField textAddress = new JTextField("", Reception.tf03_size);

    private JLabel labelClientname = new JLabel("Enter Client_name: ");
    private JLabel labelReceivername = new JLabel("Enter Receiver_name:");
    private JLabel labelAddress = new JLabel("Enter Address: ");

    /**
     * コンストラクタ（部品をセットしてウィンドウ表示）
     */
    public Reception() {

        // フレームを作成
        final JFrame frame = new JFrame(Reception.window_title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ボタンを追加
        final JButton btnNumberCheck = new JButton(Reception.btnNumberCheck_title);
        btnNumberCheck.setActionCommand(Reception.btnNumberCheck_code);
        btnNumberCheck.addActionListener(new PushButtonActionListener());

        // ボタンとテキストフィールドをレイアウト
        final JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelClientname, constraints);

        constraints.gridx = 1;
        newPanel.add(textClientname, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelReceivername, constraints);

        constraints.gridx = 1;
        newPanel.add(textReceivername, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelAddress, constraints);

        constraints.gridx = 1;
        newPanel.add(textAddress, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        newPanel.add(btnNumberCheck, constraints);

        // フレームを表示

        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "配達依頼"));
        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }

    /**
     * ボタンクリック時処理
     */

    public class PushButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final String strnum = "0123456789";
            final String str1to16 = "12345678910111213141516";
            final String title="ErrorMessage";

            if (e.getActionCommand() == Reception.btnNumberCheck_code) {
                final String str = Reception.this.textAddress.getText();

                if (str.length() == 0) {
                    JLabel label = new JLabel("数字を入力してください");
                    label.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, label,title,JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (strnum.indexOf(str.substring(i, i + 1)) == -1) {
                        JLabel label = new JLabel("数字を入力してください");
                        label.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(null, label,title,JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }


                if (str.length() != 1 && str.length() != 2) {
                    JLabel label = new JLabel("正しい住所を入力してください");
                    label.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, label,title,JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (str1to16.indexOf(str) == -1) {
                    JLabel label = new JLabel("正しい住所を入力してください");
                    label.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, label,title,JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
    }






    /*
    private class PushButtonActionListener implements ActionListener {
        private static final String message02 = "正しい住所を入力してください";
        private static final String message01 = "数字を入力してください";
        private static final String ErrorDialog_title = "Error Message";
        JFrame frame = null;

        public PushButtonActionListener(final JFrame af) {
            this.frame = af;
        }

        public void actionPerformed(final ActionEvent e) {
            final String strnum = "0123456789";
            final String str1to16 = "12345678910111213141516";

            /**
             * 数字チェックの場合

            if (e.getActionCommand() == Reception.btnNumberCheck_code) {
                final String str = Reception.this.textAddress.getText();
                if (str.length() == 0) {
                    final ErrDialog dia = new ErrDialog(this.frame,
                            PushButtonActionListener.ErrorDialog_title,
                            PushButtonActionListener.message01);

                    return;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (strnum.indexOf(str.substring(i, i + 1)) == -1) {
                        final ErrDialog dia = new ErrDialog(this.frame,
                                PushButtonActionListener.ErrorDialog_title,
                                PushButtonActionListener.message01);
                        return;
                    }
                }

                /**
                 * 1〜16の場合


                if (str.length() != 1 && str.length() != 2) {
                    final ErrDialog dia = new ErrDialog(this.frame,
                            PushButtonActionListener.ErrorDialog_title,
                            PushButtonActionListener.message02);
                    return;
                }

                if (str1to16.indexOf(str) == -1) {
                    final ErrDialog dia = new ErrDialog(this.frame,
                            PushButtonActionListener.ErrorDialog_title,
                            PushButtonActionListener.message02);
                    return;
                }
            }
        }

    }
    */


    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reception().setVisible(true);
            }
        });
    }

}