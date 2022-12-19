import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

public class TicTacToe extends JFrame{
    private JButton b[][];
    private int count;
    private boolean flag;

    public TicTacToe(){
        b = new JButton[3][3];
        setTitle("TicTacToe");
        setSize(350,350);
        setLayout(new GridLayout(3,3));
        ButtonHandler bh = new ButtonHandler();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                b[i][j] = new   JButton();
                b[i][j].addActionListener(bh);
                add(b[i][j]);
            }
        }
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("")){
                JButton b = (JButton)ae.getSource();
                if(!flag)
                    b.setText("X");
                else
                    b.setText("O");
                flag=!flag;
                count++;
                check();    
            }
        }
    }

    public void check(){
        if((b[0][0].getText().equals("X") && b[0][1].getText().equals("X") && b[0][2].getText().equals("X")) ||
                (b[1][0].getText().equals("X") && b[1][1].getText().equals("X") && b[1][2].getText().equals("X")) ||
                (b[2][0].getText().equals("X") && b[2][1].getText().equals("X") && b[2][2].getText().equals("X")) ||
                (b[0][0].getText().equals("X") && b[1][0].getText().equals("X") && b[2][0].getText().equals("X")) ||
                (b[0][1].getText().equals("X") && b[1][1].getText().equals("X") && b[2][1].getText().equals("X")) ||
                (b[0][2].getText().equals("X") && b[1][2].getText().equals("X") && b[2][2].getText().equals("X")) ||
                (b[0][0].getText().equals("X") && b[1][1].getText().equals("X") && b[2][2].getText().equals("X")) ||
                (b[0][2].getText().equals("X") && b[1][1].getText().equals("X") && b[2][0].getText().equals("X"))){
            JOptionPane.showMessageDialog(null,"Player 1 win");
            dispose();        
        }
        else if((b[0][0].getText().equals("O") && b[0][1].getText().equals("O") && b[0][2].getText().equals("O")) ||
                (b[1][0].getText().equals("O") && b[1][1].getText().equals("O") && b[1][2].getText().equals("O")) ||
                (b[2][0].getText().equals("O") && b[2][1].getText().equals("O") && b[2][2].getText().equals("O")) ||
                (b[0][0].getText().equals("O") && b[1][0].getText().equals("O") && b[2][0].getText().equals("O")) ||
                (b[0][1].getText().equals("O") && b[1][1].getText().equals("O") && b[2][1].getText().equals("O")) ||
                (b[0][2].getText().equals("O") && b[1][2].getText().equals("O") && b[2][2].getText().equals("O")) ||
                (b[0][0].getText().equals("O") && b[1][1].getText().equals("O") && b[2][2].getText().equals("O")) ||
                (b[0][2].getText().equals("O") && b[1][1].getText().equals("O") && b[2][0].getText().equals("O"))){
            JOptionPane.showMessageDialog(null,"Player 2 win");
            dispose();        
        }
        else if(count == 9){
            JOptionPane.showMessageDialog(null,"Match Tie");
            dispose();
        }
    }

    public static void main(String[] args){
        new TicTacToe();

    }
}