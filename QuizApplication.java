import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class QuizApplication extends JFrame implements ActionListener
{
	JButton b1, b2, b3;
	JRadioButton rb[] = new JRadioButton[5];
	int[] m = new int[10];
	JLabel l1, l2;
	ButtonGroup bg;
	int count = 0, x = 1, y = 1, current = 0;
 	int now=0;
 	Timer timer;
	QuizApplication()
	{
		l1 = new JLabel();
		l2 = new JLabel();
		add(l1);
		add(l2);

		bg = new ButtonGroup();

		for(int i=0; i<5; i++)
		{
			rb[i] = new JRadioButton();
			add(rb[i]);
			bg.add(rb[i]);
		}
		b1 = new JButton("Previous");
		b2 = new JButton("Save & Next");
		b3 = new JButton("Review");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		add(b1);
		add(b2);
		add(b3);

		l1.setBounds(400, 20, 300, 20);
		l2.setBounds(50, 60, 600, 20);
		rb[0].setBounds(55, 90, 500, 20);
		rb[1].setBounds(55, 120, 500, 20);
		rb[2].setBounds(55, 150, 500, 20);
		rb[3].setBounds(55, 180, 500, 20);
		b1.setBounds(30, 230, 130, 30);
		b2.setBounds(180, 230, 130, 30);
		b3.setBounds(340, 230, 130, 30);

		setLocation(300, 200);
		setSize(600, 400);
		setTimer();
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		set();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			if(current > 0)
			{
				current--;
				timer.stop();
				set();
				setTimer();
			}
		}

		if(e.getActionCommand().equals("Result")) 
	{

		if(check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Congratulation!!! \n Quiz completed! Your final score is : " + count + "/" + "10");
			System.exit(0);
	}

		if (e.getActionCommand().equals("Review")) 
		{
        	JButton bk = new JButton("Review" + x);
        	bk.setBounds(480, 20 + 30 * x, 100, 30);
        	add(bk);
        	bk.addActionListener(this);
        	m[x] = current;
        	x++;
        	current++;
        	set();
        	if (current == 9)
        	{
            	b1.setEnabled(false);
            	b3.setText("Result");
        	}
        	setVisible(false);
        	setVisible(true);
    	}
    	for (int i = 0, y = 1; i < x; i++, y++) 
    	{
        	if (e.getActionCommand().equals("Review" + y)) 
        	{
            	if (check())
                	count = count + 1;
            	now = current;
            	current = m[y];
            	set();
            	((JButton) e.getSource()).setEnabled(false);
            	current = now;
        	}
    	}


		if(e.getSource() == b2)
		{
			if(check())
				count = count + 1;
			current++;
			timer.stop();
			set();
			if(current == 9)
			{
				b1.setEnabled(false);
				b3.setText("Result");
			}
			else
			{
				setTimer();
			}
		}
	}

	public void setTimer()
	{
		int sec = 10;
		timer = new Timer(1000, new ActionListener()
		{
    		int timeleft = sec;

    		public void actionPerformed(ActionEvent e)
    		{
       			if (timeleft > 0)
        		{
            		l1.setText("Time Left : " + timeleft + " Seconds");
            		timeleft--;
        		}
        		else
        		{
            		l1.setText("Time's Up!!!");
            		handleTimeOut();
        		}
    		}
		}); // Add a semicolon here

		timer.start();
	}


	public void handleTimeOut()
	{
		JOptionPane.showMessageDialog(this, "Time Out! Moving to the next Queation.");
		current++;
		set();
		if(current == 9)
		{
			b1.setEnabled(false);
			b3.setText("Result");
			timer.stop();
		}
		else 
		{
			setTimer();
		}
	}

	void set()
{
    	rb[4].setSelected(true);
        if (current == 0) {
            l2.setText("Que1: Which one among these is not a datatype");
            rb[0].setText("int");
            rb[1].setText("Float");
            rb[2].setText("boolean");
            rb[3].setText("char");
        }
		if(current == 1)
		{
			l2.setText("Ques 2 : Which of the following is not a Java feature?");
			rb[0].setText("Dynamic");
			rb[1].setText("Architecture Neutral");
			rb[2].setText("Use of pointer");  //answer
			rb[3].setText("Object-oriented");
		}
		if(current == 2)
		{
			l2.setText("Ques 3 : Which component is used to compile, debug and execute the java programs?");
			rb[0].setText("JRE");
			rb[1].setText("JIT");
			rb[2].setText("JDK");  //answer
			rb[3].setText("JVM");
		}
		if(current == 3)
		{
			l2.setText("Ques 4 : Which of the the following is not an OOPS concept in java?");
			rb[0].setText("Polymorphism");
			rb[1].setText("Inheritance");
			rb[2].setText("Compilation");  //answer
			rb[3].setText("Encapsulation");
		}
		if(current == 4)
		{
			l2.setText("Ques 5 : What is the extension of java code files?");
			rb[0].setText(".js");
			rb[1].setText(".txt");
			rb[2].setText(".class");  
			rb[3].setText(".java");  //answer
		}
		if(current == 5)
		{
			l2.setText("Ques 6 : Which of theses are selection statement in the java?");
			rb[0].setText("break");
			rb[1].setText("continue");
			rb[2].setText("for()");  
			rb[3].setText("if()");  //answer
		}
		if(current == 6)
		{
			l2.setText("Ques 7 : Expected created by try block is caaught in which block?");
			rb[0].setText("catch");  //answer
			rb[1].setText("throw");
			rb[2].setText("throws"); 
			rb[3].setText("final");
		}
		if(current == 7)
		{
			l2.setText("Ques 8 : Which of these keywords are used for the block to be examined for exceptions?");
			rb[0].setText("check");
			rb[1].setText("throw");
			rb[2].setText("catch");  
			rb[3].setText("try");   //answer
		}
		if(current == 8)
		{
			l2.setText("Ques 9 : Which one of the following is not an access modifier??");
			rb[0].setText("Protected");
			rb[1].setText("Void");   //answer
			rb[2].setText("Public");  
			rb[3].setText("private");
		}
		if(current == 9)
		{
			l2.setText("Ques 10 : What is the numerical range of a char data type in Java?");
			rb[0].setText("0 to 256");
			rb[1].setText("-128 to 127");
			rb[2].setText("0 to 65535");  //answer
			rb[3].setText("0 to 32767");
		}
		
	}


	boolean check()
	{
		if(current == 0)
			return(rb[1].isSelected());
		if(current == 1)
			return(rb[2].isSelected());
		if(current == 2)
			return(rb[2].isSelected());
		if(current == 3)
			return(rb[2].isSelected());
		if(current == 4)
			return(rb[3].isSelected());
		if(current == 5)
			return(rb[3].isSelected());
		if(current == 6)
			return(rb[0].isSelected());
		if(current == 7)
			return(rb[3].isSelected());
		if(current == 8)
			return(rb[1].isSelected());
		if(current == 9)
			return(rb[2].isSelected());
		return false;
		
	}
	public static void main(String[] args)
	{
		new QuizApplication();
	}
}