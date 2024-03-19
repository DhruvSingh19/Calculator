import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.Math;

class Main implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberbutton = new JButton[10];
    JButton[] operandbutton = new JButton[13];

    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,
            negButton,sinButton,cosButton,tanButton,powButton;
    JPanel panel;

    Font font = new Font("Sanserif",Font.BOLD,20);

    double num1 = 0,num2 = 0,result = 0,count = 0;

    char operator;
    String angle,newangle;
    Main(){
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,540);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,400,50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        powButton = new JButton("^");

        operandbutton[0] = addButton;
        operandbutton[1] = subButton;
        operandbutton[2] = mulButton;
        operandbutton[3] = divButton;
        operandbutton[4] = decButton;
        operandbutton[5] = equButton;
        operandbutton[6] = delButton;
        operandbutton[7] = clrButton;
        operandbutton[8] = negButton;
        operandbutton[9] = sinButton;
        operandbutton[10] = cosButton;
        operandbutton[11] = tanButton;
        operandbutton[12] = powButton;

        for(int i = 0;i<13;i++){
            operandbutton[i].addActionListener(this);
            operandbutton[i].setFont(font);
        }

        for(int i = 0;i<10;i++){
            numberbutton[i] = new JButton(String.valueOf(i));
            numberbutton[i].addActionListener(this);
            numberbutton[i].setFont(font);
        }

        sinButton.setBounds(360,100,70,67);
        cosButton.setBounds(360,177,70,67);
        tanButton.setBounds(360,254,70,67);
        powButton.setBounds(360,331,75,67);
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,5,10,10));

        panel.add(numberbutton[1]);
        panel.add(numberbutton[2]);
        panel.add(numberbutton[3]);
        panel.add(addButton);
        panel.add(numberbutton[4]);
        panel.add(numberbutton[5]);
        panel.add(numberbutton[6]);
        panel.add(subButton);
        panel.add(numberbutton[7]);
        panel.add(numberbutton[8]);
        panel.add(numberbutton[9]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberbutton[0]);
        panel.add(equButton);
        panel.add(decButton);

        frame.add(powButton);
        frame.add(tanButton);
        frame.add(cosButton);
        frame.add(sinButton);
        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Main calc = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for(int i = 0;i<10;i++){
            if(event.getSource() == numberbutton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(event.getSource() == decButton){
            String mystr = textField.getText();
            for(int i = 0;i<mystr.length();i++){
                if(mystr.charAt(i) == '.'){
                    count += 1;
                }
            }
            if(count == 0)
                textField.setText(textField.getText().concat("."));
            else
                textField.setText("Decimal Point Error");
        }
        if(event.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(event.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(event.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(event.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(event.getSource() == sinButton){

            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(num1);
            textField.setText(" "+result);
        }
        if (event.getSource() == cosButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(num1);
            textField.setText(" "+result);
        }
        if (event.getSource() == tanButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(num1);
            textField.setText(" "+result);
        }
        if (event.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if(event.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    try{
                    result = num1/num2;
                    }
                    catch (ArithmeticException e){
                        textField.setText("Divide By Zero Error "+e);
                    }
                    break;
                case '^':
                    result = Math.pow(num1,num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(event.getSource() == clrButton){
            textField.setText("");
            count = 0;
        }
        if(event.getSource() == delButton){
            String operation = textField.getText();
            textField.setText(operation.substring(0,operation.length()-1));
        }
        if(event.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp = temp*(-1);
            textField.setText(String.valueOf(temp));
        }

    }
}