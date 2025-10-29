/*
  ------------------Group Members-----------------
  1.  Nabin Shah 
      Matriculation Nr. 28985
  2. Sana Pervaiz 
      Matriculation Nr. 28933
  3. Nurlan Dadashbayli
      Matriculation Nr. 29038
   
*/





import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener
{
    JButton bplus,bMinus,bmul,bdiv,bEql,bClear,bDot,bPlusMinus, b1x;
    JButton b[]=new JButton[10];
    int result,n1,n2;
    JTextField field;
    char operation;
    public Calculator()
    {
        super("simple Desktop Calulator");
        setLayout(new BorderLayout());
        JPanel pan=new JPanel();
        pan.setLayout(new GridLayout(7,3));
        for(int i=0;i<=9;i++)
        {
            b[i]=new JButton(i+"");
            pan.add(b[i]);
            b[i].addActionListener(this);
        }
        bDot=new JButton(".");
        pan.add(bDot);
        bDot.addActionListener(this);

        bClear=new JButton("C");
        pan.add(bClear);
        bClear.addActionListener(this);

        bplus=new JButton("+");
        pan.add(bplus);
        bplus.addActionListener(this);

        bMinus=new JButton("-");
        pan.add(bMinus);
        bMinus.addActionListener(this);

        bPlusMinus=new JButton("+/-");
        pan.add(bPlusMinus);
        bPlusMinus.addActionListener(this);



        bmul=new JButton("*");
        pan.add(bmul);
        bmul.addActionListener(this);

        bdiv=new JButton("/");
        pan.add(bdiv);
        bdiv.addActionListener(this);

        b1x=new JButton("1/x");
        pan.add(b1x);
        b1x.addActionListener(this);

        bEql=new JButton("=");
        pan.add(bEql);
        bEql.addActionListener(this);




        field=new JTextField(10);
        add(pan,BorderLayout.CENTER);
        add(field,BorderLayout.NORTH);
        setVisible(true);
        setSize(300,300);
    }
    public void actionPerformed(ActionEvent ae)
    {
        JButton pressed=(JButton)ae.getSource();
       /* if (pressed==bDot){
            res.setText(res.getText()+bDot);
        }*/


        if(pressed==bClear)
        {
            result=n1=n2=0;
            field.setText("");
        }
        else
        if(pressed==bEql)
        {
            n2=Integer.parseInt(field.getText());
            evaluation();
            field.setText(""+result);
        }

        else
        {
            boolean perOpf=false;
            if(pressed==bplus)
            { operation='+';
                perOpf=true;
            }
            if(pressed==bMinus)
            { operation='-';perOpf=true;}
            if(pressed==bmul)
            { operation='*';perOpf=true;}
            if(pressed==bdiv)
            { operation='/';perOpf=true;}

            if(pressed==bPlusMinus)
            { operation= '+';perOpf=true;}

            if(pressed==b1x)
            { operation='x';perOpf=true;}

            if(pressed==b1x)
            { operation='.';perOpf=true;}

            if(perOpf==false)
            {
                for(int i=0;i<10;i++)
                {
                    if(pressed==b[i])
                    {
                        String t=field.getText();
                        t+=i;
                        field.setText(t);
                    }
                }
            }
            else
            {
                n1=Integer.parseInt(field.getText());
                field.setText("");
            }
        }
    }
    int evaluation()
    {
        switch(operation)
        {
            case '+':   result=n1+n2;  
                        break;
            case '-':   result=n1-n2;
                        break;
            case '*':   result=n1*n2; 
                        break;
            case '/':   result=n1/n2;
                        break;
            case 'x':   result= 1/n1; //for 1/x
                        break;

        }
        return 0;
    }

    public static void main(String arg[])
    {
        new Calculator();
    }
}