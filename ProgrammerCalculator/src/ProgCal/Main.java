package ProgCal;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {
    static String input = "";
    static boolean isWhiteMode = false;

    public void main(String[] args) {
        JTextField output;
        JFrame frame = new JFrame("Learning Calculator");
        frame.setSize(456, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(28, 28, 28));


        //Output
        output = new JTextField("0");
        output.setBounds(10, 10, 421, 80);
        output.setFont(new Font("Segoe UI", Font.BOLD, 25)); //Font, and Size
        
        output.setBackground(new Color(18, 18, 18));//Text Field Background
        output.setForeground(Color.WHITE);  //Font Color
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setBorder(BorderFactory.createEmptyBorder(25, 15, 15, 15));
        frame.add(output);
        frame.setLocationRelativeTo(null); //To center the frame when run.

        JButton Theme = new JButton("◑"); 
        Theme.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
        Theme.setFocusPainted(false);
        Theme.setBounds(10+15, 5, 50, 20);
        Theme.setBackground(new Color(74, 85, 92));
        Theme.setForeground(Color.WHITE);
        Theme.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        Theme.setBorder(new RoundedBorder(40));
        frame.add(Theme);

        //Color Settings
        Color NUMBERSCOLOR = new Color(42, 43, 43);
        Color OtherButtons = new Color(74, 74, 74);
        Color HEXOCTDECBIN = new Color(98, 110, 64);
        Color LogicalOP = new Color(74, 85, 92);
        Color AC_AND_EQUAL = new Color(64, 148, 0);

        //Color When Whilte Mode
        Color NUMBERSCOLORWhite = new Color(232, 232, 229);
        Color OtherButtonsWhite = new Color(204, 204, 204);
        Color HEXOCTDECBINWhite = new Color(255, 254, 197);
        Color LogicalOPWhite = new Color(212, 238, 245);
        Color AC_AND_EQUALWhite = new Color(208, 255, 219);



        //Buttons
        JButton AC_Button = new JButton("AC");
        AC_Button.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        AC_Button.setFocusPainted(false);
        AC_Button.setBounds(10, 100, 82, 82);
        AC_Button.setBackground(AC_AND_EQUAL);
        AC_Button.setForeground(Color.WHITE);
        AC_Button.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(AC_Button);

        JButton Parenthesis = new JButton("()");
        Parenthesis.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Parenthesis.setFocusPainted(false);
        Parenthesis.setBounds(95, 100, 82, 82);
        Parenthesis.setBackground(OtherButtons);
        Parenthesis.setForeground(Color.WHITE);
        Parenthesis.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Parenthesis);

        JButton MoveBackward = new JButton("←");
        MoveBackward .setFont(new Font("Segoe UI", Font.PLAIN, 24));
        MoveBackward.setFocusPainted(false);
        MoveBackward.setBounds(180, 100, 82, 82);
        MoveBackward.setBackground(OtherButtons);
        MoveBackward.setForeground(Color.WHITE);
        MoveBackward.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(MoveBackward);

        JButton MoveForward = new JButton("→");
        MoveForward.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        MoveForward.setFocusPainted(false);
        MoveForward.setBounds(265, 100, 82, 82);
        MoveForward.setBackground(OtherButtons);
        MoveForward.setForeground(Color.WHITE);
        MoveForward.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(MoveForward);

        JButton Percent = new JButton("%ρ");
        Percent.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Percent.setFocusPainted(false);
        Percent.setBounds(350, 100, 82, 82);
        Percent.setBackground(OtherButtons);
        Percent.setForeground(Color.WHITE);
        Percent.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Percent);

        JButton NUM7 = new JButton("7");
        NUM7.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM7.setFocusPainted(false);
        NUM7.setBounds(10, 185, 82, 82);
        NUM7.setBackground(NUMBERSCOLOR);
        NUM7.setForeground(Color.WHITE);
        NUM7.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM7);

        JButton NUM8 = new JButton("8");
        NUM8.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM8.setFocusPainted(false);
        NUM8.setBounds(95, 185, 82, 82);
        NUM8.setBackground(NUMBERSCOLOR);
        NUM8.setForeground(Color.WHITE);
        NUM8.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM8);

        JButton NUM9 = new JButton("9");
        NUM9.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM9.setFocusPainted(false);
        NUM9.setBounds(180, 185, 82, 82);
        NUM9.setBackground(NUMBERSCOLOR);
        NUM9.setForeground(Color.WHITE);
        NUM9.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM9);

        JButton NUM4 = new JButton("4");
        NUM4.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM4.setFocusPainted(false);
        NUM4.setBounds(10, 270, 82, 82);
        NUM4.setBackground(NUMBERSCOLOR);
        NUM4.setForeground(Color.WHITE);
        NUM4.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM4);

        JButton NUM5 = new JButton("5");
        NUM5.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM5.setFocusPainted(false);
        NUM5.setBounds(95, 270, 82, 82);
        NUM5.setBackground(NUMBERSCOLOR);
        NUM5.setForeground(Color.WHITE);
        NUM5.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM5);

        JButton NUM6 = new JButton("6");
        NUM6.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM6.setFocusPainted(false);
        NUM6.setBounds(180, 270, 82, 82);
        NUM6.setBackground(NUMBERSCOLOR);
        NUM6.setForeground(Color.WHITE);
        NUM6.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM6);

        JButton NUM1 = new JButton("1");
        NUM1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM1.setFocusPainted(false);
        NUM1.setBounds(10, 355, 82, 82);
        NUM1.setBackground(NUMBERSCOLOR);
        NUM1.setForeground(Color.WHITE);
        NUM1.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM1);

        JButton NUM2 = new JButton("2");
        NUM2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM2.setFocusPainted(false);
        NUM2.setBounds(95, 355, 82, 82);
        NUM2.setBackground(NUMBERSCOLOR);
        NUM2.setForeground(Color.WHITE);
        NUM2.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM2);

        JButton NUM3 = new JButton("3");
        NUM3.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM3.setFocusPainted(false);
        NUM3.setBounds(180, 355, 82, 82);
        NUM3.setBackground(NUMBERSCOLOR);
        NUM3.setForeground(Color.WHITE);
        NUM3.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM3);

        JButton NUM0 = new JButton("0");
        NUM0.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NUM0.setFocusPainted(false);
        NUM0.setBounds(10, 440, 82, 82);
        NUM0.setBackground(NUMBERSCOLOR);
        NUM0.setForeground(Color.WHITE);
        NUM0.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NUM0);

        JButton Decimal = new JButton(".");
        Decimal.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Decimal.setFocusPainted(false);
        Decimal.setBounds(95, 440, 82, 82);
        Decimal.setBackground(NUMBERSCOLOR);
        Decimal.setForeground(Color.WHITE);
        Decimal.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Decimal);

        JButton BackSpace = new JButton("⌫");
        BackSpace.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
        BackSpace.setFocusPainted(false);
        BackSpace.setBounds(180, 440, 82, 82);
        BackSpace.setBackground(OtherButtons);
        BackSpace.setForeground(Color.WHITE);
        BackSpace.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(BackSpace);

        JButton Multiplication = new JButton("×");
        Multiplication.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Multiplication.setFocusPainted(false);
        Multiplication.setBounds(265, 185, 82, 82);
        Multiplication.setBackground(OtherButtons);
        Multiplication.setForeground(Color.WHITE);
        Multiplication.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Multiplication);

        JButton Division = new JButton("÷");
        Division.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Division.setFocusPainted(false);
        Division.setBounds(350, 185, 82, 82);
        Division.setBackground(OtherButtons);
        Division.setForeground(Color.WHITE);
        Division.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Division);

        JButton Addition = new JButton("+");
        Addition.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Addition.setFocusPainted(false);
        Addition.setBounds(265, 185+85, 82, 82);
        Addition.setBackground(OtherButtons);
        Addition.setForeground(Color.WHITE);
        Addition.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Addition);

        JButton Subraction = new JButton("-");
        Subraction.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Subraction.setFocusPainted(false);
        Subraction.setBounds(265+85, 185+85, 82, 82);
        Subraction.setBackground(OtherButtons);
        Subraction.setForeground(Color.WHITE);
        Subraction.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Subraction);

        JButton Modulo = new JButton("%ᵐ");
        Modulo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Modulo.setFocusPainted(false);
        Modulo.setBounds(265+85, 185+85+85, 82, 82);
        Modulo.setBackground(OtherButtons);
        Modulo.setForeground(Color.WHITE);
        Modulo.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Modulo);

        JButton BTNEqual = new JButton("=");
        BTNEqual.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        BTNEqual.setFocusPainted(false);
        BTNEqual.setBounds(265+85, 185+85+85+85, 82, 82+85);
        BTNEqual.setBackground(AC_AND_EQUAL);
        BTNEqual.setForeground(Color.WHITE);
        BTNEqual.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(BTNEqual);

        JButton Exponent = new JButton("x⁰"); //https://www.i2symbol.com/symbols/superscript
        Exponent.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Exponent.setFocusPainted(false);
        Exponent.setBounds(265, 185+85+85, 82, 82);
        Exponent.setBackground(OtherButtons);
        Exponent.setForeground(Color.WHITE);
        Exponent.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Exponent);

        JButton Sqrt = new JButton("√"); 
        Sqrt.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        Sqrt.setFocusPainted(false);
        Sqrt.setBounds(265, 185+85+85+85, 82, 82);
        Sqrt.setBackground(OtherButtons);
        Sqrt.setForeground(Color.WHITE);
        Sqrt.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(Sqrt);

        JButton HEX = new JButton("HEX"); 
        HEX.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        HEX.setFocusPainted(false);
        HEX.setBounds(10, 185+85+85+85+85, 82, 82);
        HEX.setBackground(HEXOCTDECBIN);
        HEX.setForeground(Color.WHITE);
        HEX.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(HEX);

        JButton OCT = new JButton("OCT"); 
        OCT.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        OCT.setFocusPainted(false);
        OCT.setBounds(10+85, 185+85+85+85+85, 82, 82);
        OCT.setBackground(HEXOCTDECBIN);
        OCT.setForeground(Color.WHITE);
        OCT.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(OCT);

        JButton DEC = new JButton("DEC"); 
        DEC.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        DEC.setFocusPainted(false);
        DEC.setBounds(10+85+85, 185+85+85+85+85, 82, 82);
        DEC.setBackground(HEXOCTDECBIN);
        DEC.setForeground(Color.WHITE);
        DEC.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(DEC);

        JButton BIN = new JButton("BIN"); 
        BIN.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        BIN.setFocusPainted(false);
        BIN.setBounds(10+85+85+85, 185+85+85+85+85, 82, 82);
        BIN.setBackground(HEXOCTDECBIN);
        BIN.setForeground(Color.WHITE);
        BIN.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(BIN);

        JButton XOR = new JButton("^"); 
        XOR.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        XOR.setFocusPainted(false);
        XOR.setBounds(10, 185+85+85+85+85+85, 82, 82);
        XOR.setBackground(LogicalOP);
        XOR.setForeground(Color.WHITE);
        XOR.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(XOR);

        JButton AND = new JButton("&"); 
        AND.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        AND.setFocusPainted(false);
        AND.setBounds(10+85, 185+85+85+85+85+85, 82, 82);
        AND.setBackground(LogicalOP);
        AND.setForeground(Color.WHITE);
        AND.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(AND);
        
        JButton NOT = new JButton("!"); 
        NOT.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        NOT.setFocusPainted(false);
        NOT.setBounds(10+85+85, 185+85+85+85+85+85, 82, 82);
        NOT.setBackground(LogicalOP);
        NOT.setForeground(Color.WHITE);
        NOT.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(NOT);

        JButton GreaterLessthan = new JButton(">\n<"); 
        GreaterLessthan.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        GreaterLessthan.setFocusPainted(false);
        GreaterLessthan.setBounds(10+85+85+85+85, 185+85+85+85+85+85, 82, 82);
        GreaterLessthan.setBackground(LogicalOP);
        GreaterLessthan.setForeground(Color.WHITE);
        GreaterLessthan.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(GreaterLessthan);

        JButton LogicalEqual = new JButton("="); 
        LogicalEqual.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        LogicalEqual.setFocusPainted(false);
        LogicalEqual.setBounds(10+85+85+85, 185+85+85+85+85+85, 82, 82);
        LogicalEqual.setBackground(LogicalOP);
        LogicalEqual.setForeground(Color.WHITE);
        LogicalEqual.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(LogicalEqual);



        

        Theme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isWhiteMode){
                    Theme.setText("◑");
                    frame.getContentPane().setBackground(new Color(28, 28, 28));
                    output.setBackground(new Color(18, 18, 18)); //Text Field
                    output.setForeground(Color.WHITE);
                    AC_Button.setBackground(AC_AND_EQUAL);
                    AC_Button.setForeground(Color.white);
                    BTNEqual.setBackground(AC_AND_EQUAL);
                    BTNEqual.setForeground(Color.white);
                    Parenthesis.setBackground(OtherButtons);
                    Parenthesis.setForeground(Color.WHITE);
                    MoveBackward.setBackground(OtherButtons);
                    MoveBackward.setForeground(Color.WHITE);
                    Percent.setBackground(OtherButtons);
                    Percent.setForeground(Color.WHITE);
                    NUM7.setBackground(NUMBERSCOLOR);
                    NUM7.setForeground(Color.WHITE);
                    NUM8.setBackground(NUMBERSCOLOR);
                    NUM8.setForeground(Color.WHITE);
                    NUM9.setBackground(NUMBERSCOLOR);
                    NUM9.setForeground(Color.WHITE);
                    NUM4.setBackground(NUMBERSCOLOR);
                    NUM4.setForeground(Color.WHITE);
                    NUM5.setBackground(NUMBERSCOLOR);
                    NUM5.setForeground(Color.WHITE);
                    NUM6.setBackground(NUMBERSCOLOR);
                    NUM6.setForeground(Color.WHITE);
                    NUM1.setBackground(NUMBERSCOLOR);
                    NUM1.setForeground(Color.WHITE);
                    NUM2.setForeground(Color.WHITE);
                    NUM2.setBackground(NUMBERSCOLOR);
                    NUM3.setForeground(Color.WHITE);
                    NUM3.setBackground(NUMBERSCOLOR);
                    NUM0.setForeground(Color.WHITE);
                    NUM0.setBackground(NUMBERSCOLOR);
                    Decimal.setForeground(Color.WHITE);
                    Decimal.setBackground(NUMBERSCOLOR);
                    BackSpace.setBackground(OtherButtons);
                    BackSpace.setForeground(Color.WHITE);
                    Parenthesis.setBackground(OtherButtons);
                    Parenthesis.setForeground(Color.WHITE);
                    MoveBackward.setBackground(OtherButtons);
                    MoveBackward.setForeground(Color.WHITE);
                    MoveForward.setBackground(OtherButtons);
                    MoveForward.setForeground(Color.WHITE);
                    Percent.setBackground(OtherButtons);
                    Percent.setForeground(Color.WHITE);
                    BackSpace.setBackground(OtherButtons);
                    BackSpace.setForeground(Color.WHITE);
                    Multiplication.setBackground(OtherButtons);
                    Multiplication.setForeground(Color.WHITE);
                    Division.setBackground(OtherButtons);
                    Division.setForeground(Color.WHITE);
                    Addition.setBackground(OtherButtons);
                    Addition.setForeground(Color.WHITE);
                    Subraction.setBackground(OtherButtons);
                    Subraction.setForeground(Color.WHITE);
                    Exponent.setBackground(OtherButtons);
                    Exponent.setForeground(Color.WHITE);
                    Sqrt.setBackground(OtherButtons);
                    Sqrt.setForeground(Color.WHITE);
                    Modulo.setBackground(OtherButtons);
                    Modulo.setForeground(Color.WHITE);
                    HEX.setBackground(HEXOCTDECBIN);
                    HEX.setForeground(Color.WHITE);
                    OCT.setBackground(HEXOCTDECBIN);
                    OCT.setForeground(Color.WHITE);
                    DEC.setBackground(HEXOCTDECBIN);
                    DEC.setForeground(Color.WHITE);
                    BIN.setBackground(HEXOCTDECBIN);
                    BIN.setForeground(Color.WHITE);
                    XOR.setBackground(LogicalOP);
                    XOR.setForeground(Color.WHITE);
                    AND.setBackground(LogicalOP);
                    AND.setForeground(Color.WHITE);
                    NOT.setBackground(LogicalOP);
                    NOT.setForeground(Color.WHITE);
                    GreaterLessthan.setBackground(LogicalOP);
                    GreaterLessthan.setForeground(Color.WHITE);
                    LogicalEqual.setBackground(LogicalOP);
                    LogicalEqual.setForeground(Color.WHITE);

                    isWhiteMode = false;
                } else {
                    isWhiteMode = true;
                    Theme.setText("☀︎");
                    Theme.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));

                    frame.getContentPane().setBackground(new Color(223, 224, 222));
                    output.setBackground(new Color(191, 194, 190));
                    output.setForeground(Color.BLACK);
                    AC_Button.setBackground(AC_AND_EQUALWhite);
                    AC_Button.setForeground(Color.black);
                    BTNEqual.setBackground(AC_AND_EQUALWhite);
                    BTNEqual.setForeground(Color.black);
                    Parenthesis.setBackground(OtherButtonsWhite);
                    Parenthesis.setForeground(Color.BLACK);
                    MoveBackward.setBackground(OtherButtonsWhite);
                    MoveBackward.setForeground(Color.BLACK);
                    Percent.setBackground(OtherButtonsWhite);
                    Percent.setForeground(Color.BLACK);
                    NUM7.setBackground(NUMBERSCOLORWhite);
                    NUM7.setForeground(Color.BLACK);
                    NUM8.setBackground(NUMBERSCOLORWhite);
                    NUM8.setForeground(Color.BLACK);
                    NUM9.setBackground(NUMBERSCOLORWhite);
                    NUM9.setForeground(Color.BLACK);
                    NUM4.setBackground(NUMBERSCOLORWhite);
                    NUM4.setForeground(Color.BLACK);
                    NUM5.setBackground(NUMBERSCOLORWhite);
                    NUM5.setForeground(Color.BLACK);
                    NUM6.setBackground(NUMBERSCOLORWhite);
                    NUM6.setForeground(Color.BLACK);
                    NUM1.setBackground(NUMBERSCOLORWhite);
                    NUM1.setForeground(Color.BLACK);
                    NUM2.setForeground(Color.BLACK);
                    NUM2.setBackground(NUMBERSCOLORWhite);
                    NUM3.setForeground(Color.BLACK);
                    NUM3.setBackground(NUMBERSCOLORWhite);
                    NUM0.setForeground(Color.BLACK);
                    NUM0.setBackground(NUMBERSCOLORWhite);
                    Decimal.setForeground(Color.BLACK);
                    Decimal.setBackground(NUMBERSCOLORWhite);
                    BackSpace.setBackground(OtherButtonsWhite);
                    BackSpace.setForeground(Color.BLACK);
                    Parenthesis.setBackground(OtherButtonsWhite);
                    Parenthesis.setForeground(Color.BLACK);
                    MoveBackward.setBackground(OtherButtonsWhite);
                    MoveBackward.setForeground(Color.BLACK);
                    MoveForward.setBackground(OtherButtonsWhite);
                    MoveForward.setForeground(Color.BLACK);
                    Percent.setBackground(OtherButtonsWhite);
                    Percent.setForeground(Color.BLACK);
                    BackSpace.setBackground(OtherButtonsWhite);
                    BackSpace.setForeground(Color.BLACK);
                    Multiplication.setBackground(OtherButtonsWhite);
                    Multiplication.setForeground(Color.BLACK);
                    Division.setBackground(OtherButtonsWhite);
                    Division.setForeground(Color.BLACK);
                    Addition.setBackground(OtherButtonsWhite);
                    Addition.setForeground(Color.BLACK);
                    Subraction.setBackground(OtherButtonsWhite);
                    Subraction.setForeground(Color.BLACK);
                    Exponent.setBackground(OtherButtonsWhite);
                    Exponent.setForeground(Color.BLACK);
                    Sqrt.setBackground(OtherButtonsWhite);
                    Sqrt.setForeground(Color.BLACK);
                    Modulo.setBackground(OtherButtonsWhite);
                    Modulo.setForeground(Color.BLACK);
                    HEX.setBackground(HEXOCTDECBINWhite);
                    HEX.setForeground(Color.BLACK);
                    OCT.setBackground(HEXOCTDECBINWhite);
                    OCT.setForeground(Color.BLACK);
                    DEC.setBackground(HEXOCTDECBINWhite);
                    DEC.setForeground(Color.BLACK);
                    BIN.setBackground(HEXOCTDECBINWhite);
                    BIN.setForeground(Color.BLACK);
                    XOR.setBackground(LogicalOPWhite);
                    XOR.setForeground(Color.BLACK);
                    AND.setBackground(LogicalOPWhite);
                    AND.setForeground(Color.BLACK);
                    NOT.setBackground(LogicalOPWhite);
                    NOT.setForeground(Color.BLACK);
                    GreaterLessthan.setBackground(LogicalOPWhite);
                    GreaterLessthan.setForeground(Color.BLACK);
                    LogicalEqual.setBackground(LogicalOPWhite);
                    LogicalEqual.setForeground(Color.BLACK);
                }
            }
        });
        

        
        AC_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("0");
            }
        });

        BTNEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = output.getText();
                answer = Solve.PEMDAS(answer);
                output.setText(answer);
            }
        });

        HEX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = output.getText();
                output.setText(Solve.PEMDAS("Ans"+answer));
            }
        });

        frame.setVisible(true);
    }

class RoundedBorder implements javax.swing.border.Border {
    private int radius;
    RoundedBorder(int radius) { this.radius = radius; }
    
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius + 2);
    }
    public boolean isBorderOpaque() { return true; }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
}
