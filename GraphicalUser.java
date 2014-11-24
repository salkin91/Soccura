import javax.swing.*;
import java.awt.*;



public class GraphicalUser {
	
	private JFrame f;
	private JPanel p1, p2, p3, p4;
	private JLabel lab, lab2;
	
	public GraphicalUser() {
		gui();
	}
	
	public void gui() {
		
		f = new JFrame("Beta Main");
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setBackground(Color.gray);
		p2 = new JPanel();
		p2.setBackground(Color.blue);
		p3 = new JPanel();
		p3.setBackground(Color.yellow);
		p4 = new JPanel();
		p4.setBackground(Color.green);
		
		lab = new JLabel("Lista");
		p1.add(lab);
		
		
		
		
		
		
		lab2 = new JLabel("lab2");
		p2.add(lab2);
		
		
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p2, p3);
        splitPane.setResizeWeight(0.5);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, p4);
        splitPane1.setResizeWeight(0.8);
        splitPane1.setEnabled(false);
        splitPane1.setDividerSize(0);
 
        f.add(p1,BorderLayout.WEST);
        f.getContentPane().add(splitPane1);
        
        f.setVisible(true);
        	
	}
	
	
	public static void main(String[] args){
		
		new GraphicalUser();
		
	}

}