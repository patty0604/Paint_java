package painting;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;

//利用按鈕選取顏色
public class Painting extends JFrame implements MouseMotionListener,ActionListener
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting p = new Painting();
	}

	
	int x = -1, y = -1;//畫筆的初始座標值，先設負值
	Color colr = Color.BLACK ; //設初始顏色為黑色
	public Painting()
	{
		setTitle("Painting");
		setSize(600,600);//設定畫布大小
		setDefaultCloseOperation(EXIT_ON_CLOSE); //按X關閉視窗
		
		
		//版面配置&要設置四種顏色
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		JButton red = new JButton("red"); //紅色按鈕
		red.setBackground(Color.RED);//設置按鈕背景顏色
		JButton yellow = new JButton("yellow");//黃色按鈕
		yellow.setBackground(Color.YELLOW);
		JButton blue = new JButton("blue");//藍色按鈕
		blue.setBackground(Color.BLUE);
		JButton black = new JButton("black");//黑色按鈕
		black.setBackground(Color.BLACK);
		
		//加入所創建的Panel中
		p.add(red);
		p.add(yellow);
		p.add(blue);
		p.add(black);
		red.addActionListener(this);//觸發紅色按鈕
		yellow.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		
		c.add(p,BorderLayout.EAST);
		
		//設置滑鼠
		c.addMouseMotionListener(this);
		setVisible(true);
	}
	
	public void mouseMoved(MouseEvent e) {
		//nothing
	}
	public void actionPerformed(ActionEvent e) {
		
		String act = e.getActionCommand();
		if (act.equals("blue")) {
			colr = Color.BLUE;
		}
		else if (act.equals("red")) {
			colr = Color.RED;
		}
		else if (act.equals("yellow")) {
			colr = Color.YELLOW;
		}
		else{
			colr = Color.BLACK;
		}
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(colr);
		g.fillOval(x, y, 10, 10);
	}
	
}


	

