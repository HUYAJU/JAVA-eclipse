import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.SystemColor;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

class myThread extends Thread
{
	public void run() {
		
			try {
				Thread.sleep(5000000);			 
				
			} catch (InterruptedException e) {
				e.printStackTrace();
						
		}
	}
	
}

public class Lottery extends JFrame {

	private JPanel contentPane;
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;
	private JTextField s4;
	private JTextField s5;
	private JTextField s6;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;
	private JTextField r4;
	private JTextField r5;
	private JTextField r6;
	private JTextField r7;

	/**
	 * Launch the application.
	 */
  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery frame = new Lottery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

//自行選號--宣告變數	
	TreeSet<Integer> selectN = new TreeSet<Integer>(); 
	TreeSet<Integer> selectR = new TreeSet<Integer>(); 
	Iterator<Integer> selectTemp = selectN.iterator();
	TreeSet<Integer> result= new TreeSet<Integer>();
    Integer[] selectn = new Integer [6];
    String str="";
	int i7;
    String[] chosen = new String[result.size()];//list裡已選號碼

	public Lottery() {
		setResizable(false);
		setTitle("\u5927!\u6A02!\u900F!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("~\u6B61\u8FCE\u5149\u81E8\u5927\u6A02\u900F\u7CFB\u7D71~");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("標楷體", Font.BOLD, 20));
		contentPane.add(label, BorderLayout.NORTH);
		
		
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("新細明體", Font.PLAIN, 16));
		panel.setMaximumSize(new Dimension(3000, 3000));
		panel.setPreferredSize(new Dimension(6, 6));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 7, 0, 0));
		

		
		JButton btn[]= new JButton[49];	
		for(int i=0;i<49;i++) {			
	     for (int x = 0; x < 49; x++) {
	  
	     //產生JButton實體物件
	     btn[x] = new JButton();
	     String I = Integer.toString(i++);
	     I=String.format("%02d", i);
	     btn[x].setText(I);  	 
	     btn[x].setFont(new Font("Arial Black", Font.BOLD, 22));
	     btn[x].setBorder(UIManager.getBorder("CheckBox.border"));
	     btn[x].setBackground(Color.YELLOW);	  
	     btn[x].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     panel.add(btn[x]);  
	     
//按鈕事件	    
	   
		btn[x].addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {	

			for (int j = 0; j < 49; j++) {	
			 if (e.getSource() == btn[j]) {					 
				 if(btn[j].getBackground()==Color.YELLOW)
				 {
					 if(selectN.size()<6) {
				 btn[j].setBackground(Color.RED);
				 selectN.add(Integer.parseInt(btn[j].getText()));
					 }
					 else {JOptionPane.showMessageDialog(null,"~選擇號碼請勿超過六個~");}
				 }
				 else if(btn[j].getBackground()==Color.RED)
				 {
			     btn[j].setBackground(Color.YELLOW);	
			     selectN.remove(Integer.parseInt(btn[j].getText()));
				 }				 
			 }		
			}			
			selectN.toArray(selectn); 
		    if(selectn[0]!=null)
			s1.setText(String.format("%02d", selectn[0]));	
	        else
	        s1.setText("");
		    if(selectn[1]!=null)
				s2.setText(String.format("%02d", selectn[1]));	
		        else
		        s2.setText("");
		    
		    if(selectn[2]!=null)
				s3.setText(String.format("%02d", selectn[2]));	
		        else
		        s3.setText("");
		    
		    if(selectn[3]!=null)
				s4.setText(String.format("%02d", selectn[3]));	
		        else
		        s4.setText("");
		    
		    if(selectn[4]!=null)
				s5.setText(String.format("%02d", selectn[4]));	
		        else
		        s5.setText("");
		    
		    if(selectn[5]!=null)
				s6.setText(String.format("%02d", selectn[5]));	
		        else
		        s6.setText("");		    		
		    }
    
	  });			
         }
	       }
	
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[73px,grow][grow,left][grow,left][grow,left][grow,left][grow,left][grow,left][41.00,grow]", "[31px][][41.00,grow][grow][31.00][150px:125.00px:150px,grow][38.00]"));
		
		JLabel label_1 = new JLabel("\u60A8\u9078\u64C7\u7684\u865F\u78BC");
		label_1.setFont(new Font("標楷體", Font.BOLD, 18));
		panel_2.add(label_1, "cell 0 0,grow");
		
		s1 = new JTextField();
		s1.setHorizontalAlignment(SwingConstants.CENTER);
		s1.setBackground(Color.WHITE);
		s1.setEditable(false);
		s1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel_2.add(s1, "cell 1 0,grow");
		s1.setColumns(2);
		
		s2 = new JTextField();
		s2.setHorizontalAlignment(SwingConstants.CENTER);
		s2.setBackground(Color.WHITE);
		s2.setEditable(false);
		s2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		s2.setColumns(2);
		panel_2.add(s2, "cell 2 0,grow");
		
		s3 = new JTextField();
		s3.setHorizontalAlignment(SwingConstants.CENTER);
		s3.setBackground(Color.WHITE);
		s3.setEditable(false);
		s3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		s3.setColumns(2);
		panel_2.add(s3, "cell 3 0,grow");
		
		s4 = new JTextField();
		s4.setHorizontalAlignment(SwingConstants.CENTER);
		s4.setBackground(Color.WHITE);
		s4.setEditable(false);
		s4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		s4.setColumns(2);
		panel_2.add(s4, "cell 4 0,grow");
		
		s5 = new JTextField();
		s5.setHorizontalAlignment(SwingConstants.CENTER);
		s5.setBackground(Color.WHITE);
		s5.setEditable(false);
		s5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		s5.setColumns(2);
		panel_2.add(s5, "cell 5 0,grow");
		
		s6 = new JTextField();
		s6.setHorizontalAlignment(SwingConstants.CENTER);
		s6.setBackground(Color.WHITE);
		s6.setEditable(false);
		s6.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		s6.setColumns(2);
		panel_2.add(s6, "cell 6 0,grow");
		
		JLabel label_2 = new JLabel("  \u958B\u734E\u865F\u78BC");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("標楷體", Font.BOLD, 18));
		panel_2.add(label_2, "cell 0 1,alignx trailing");
		
		r1 = new JTextField();
		r1.setHorizontalAlignment(SwingConstants.CENTER);
		r1.setBackground(Color.WHITE);
		r1.setEditable(false);
		r1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r1.setColumns(2);
		panel_2.add(r1, "cell 1 1,growx");
		
		r2 = new JTextField();
		r2.setHorizontalAlignment(SwingConstants.CENTER);
		r2.setBackground(Color.WHITE);
		r2.setEditable(false);
		r2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r2.setColumns(2);
		panel_2.add(r2, "cell 2 1,growx");
		
		r3 = new JTextField();
		r3.setHorizontalAlignment(SwingConstants.CENTER);
		r3.setBackground(Color.WHITE);
		r3.setEditable(false);
		r3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r3.setColumns(2);
		panel_2.add(r3, "cell 3 1,growx");
		
		r4 = new JTextField();
		r4.setHorizontalAlignment(SwingConstants.CENTER);
		r4.setBackground(Color.WHITE);
		r4.setEditable(false);
		r4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r4.setColumns(2);
		panel_2.add(r4, "cell 4 1,growx");
		
		r5 = new JTextField();
		r5.setHorizontalAlignment(SwingConstants.CENTER);
		r5.setBackground(Color.WHITE);
		r5.setEditable(false);
		r5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r5.setColumns(2);
		panel_2.add(r5, "cell 5 1,growx");
		
		r6 = new JTextField();
		r6.setHorizontalAlignment(SwingConstants.CENTER);
		r6.setBackground(Color.WHITE);
		r6.setEditable(false);
		r6.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r6.setColumns(2);
		panel_2.add(r6, "cell 6 1,growx");
		
		r7 = new JTextField();
		r7.setEditable(false);
		r7.setHorizontalAlignment(SwingConstants.CENTER);
		r7.setBackground(new Color(255, 204, 255));
		r7.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		r7.setColumns(2);
		panel_2.add(r7, "cell 7 1,growx");
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, "flowy,cell 0 2 8 1,grow");
//電腦選號
		JButton button_46 = new JButton("\u96FB\u8166\u9078\u865F");
		button_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new myThread() 
				{
					public void run()
					{ 					
					for(int k=0;k<=30;k++){				
						for(int a=0;a<49;a++)
						btn[a].setBackground(Color.YELLOW);
						selectN.clear();									
						do {
							selectN.add((int)(Math.random()*(49-1+1)+1));
						    }
							while(selectN.size()!=6);								 					    						 							
						
						selectN.toArray(selectn);
						
					    s1.setText(String.format("%02d", selectn[0]));	
					    s2.setText(String.format("%02d", selectn[1]));					    
					    s3.setText(String.format("%02d", selectn[2]));					    
					    s4.setText(String.format("%02d", selectn[3]));					    
					    s5.setText(String.format("%02d", selectn[4]));					    
					    s6.setText(String.format("%02d", selectn[5]));
					    for(int j=0;j<6;j++)
					    btn[selectn[j]-1].setBackground(Color.RED);	
					    try {
							myThread.sleep(50);						
					    } 
					catch (InterruptedException e) {
						e.printStackTrace();
					}}}						
				}.start();
			}});
		button_46.setPreferredSize(new Dimension(130, 30));
		button_46.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		panel_1.add(button_46);
//部分快選		
		
		JButton button_48 = new JButton("\u90E8\u5206\u5FEB\u9078");
		button_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(selectN.size()!=0) {
				if(selectN.size()<6) {						
				do {
					selectR.clear();
					for(int i=1;i<=6;i++)
						selectR.add((int)(Math.random()*(49-1+1)+1));						
				}
				while(!selectR.containsAll(selectN));
				while (selectR.size()!=6)
				selectR.add((int)(Math.random()*(49-1+1)+1));						
				
				selectN.addAll(selectR);
				selectN.toArray(selectn); 
				s1.setText(String.format("%02d", selectn[0]));	
			    s2.setText(String.format("%02d", selectn[1]));					    
			    s3.setText(String.format("%02d", selectn[2]));					    
			    s4.setText(String.format("%02d", selectn[3]));					    
			    s5.setText(String.format("%02d", selectn[4]));					    
			    s6.setText(String.format("%02d", selectn[5]));
			    for(int j=0;j<6;j++)
				    btn[selectn[j]-1].setBackground(Color.RED);	
				 }else {JOptionPane.showMessageDialog(null,"您已選了六個號碼了!");
				}
				}else{JOptionPane.showMessageDialog(null,"請先選擇至少一個號碼!");}
			}
			});
		button_48.setPreferredSize(new Dimension(130, 30));
		button_48.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		panel_1.add(button_48);
		
		JLabel label_3 = new JLabel("\u5C0D\u734E\u7D50\u679C");
		label_3.setFont(new Font("標楷體", Font.BOLD, 18));
		panel_2.add(label_3, "cell 4 4 4 1,alignx center");
		
		List list_1 = new List();
		list_1.setForeground(Color.BLUE);
		list_1.setMultipleSelections(false);
		list_1.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		panel_2.add(list_1, "flowy,cell 0 5 4 1,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 4 5 4 1,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setForeground(new Color(128, 0, 128));
		textPane.setBorder(UIManager.getBorder("PopupMenu.border"));
		textPane.setFont(new Font("標楷體", Font.BOLD, 18));
		textPane.setBackground(new Color(127, 255, 212));
		textPane.setEditable(false);
		
//確認號碼		
		
		JButton btnNewButton_3 = new JButton("\u78BA\u8A8D\u865F\u78BC");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			    if(selectN.size()<6)
			    	JOptionPane.showMessageDialog(null,"請選取六個號碼");
			    else {					    	
			    	 
			    	for(int i=0;i<6;i++)
			    	str += String.format("%02d", selectn[i])+"  ";
			    	list_1.add(str);
			    	for(int a=0;a<49;a++)
						btn[a].setBackground(Color.YELLOW);
					 selectN.clear();
					 for(int i=0;i<6;i++)
					 selectn[i]=null;
			    	    str="";
						 s1.setText("");	
						    s2.setText("");					    
						    s3.setText("");					    
						    s4.setText("");					    
						    s5.setText("");					    
						    s6.setText("");
			    }
			}
		});
		
		btnNewButton_3.setPreferredSize(new Dimension(130, 30));
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		panel_1.add(btnNewButton_3);
		
//清除		
		JButton button_1 = new JButton("\u6E05\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int a=0;a<49;a++)
				btn[a].setBackground(Color.YELLOW);
				selectN.clear();
				for(int i=0;i<6;i++)
				selectn[i]=null;
				 btnNewButton_3.setEnabled(true);
				 button_46.setEnabled(true);
				button_48.setEnabled(true);
				 textPane.setText("");
	    	    str="";
			    	s1.setText("");	
				    s2.setText("");					    
				    s3.setText("");					    
				    s4.setText("");					    
				    s5.setText("");					    
				    s6.setText("");
				    r1.setText("");	
				    r2.setText("");					    
				    r3.setText("");					    
				    r4.setText("");					    
				    r5.setText("");					    
				    r6.setText("");
				    r7.setText("");
			}
		});
		button_1.setPreferredSize(new Dimension(70, 30));
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		panel_1.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3, "cell 0 3 8 1,grow");
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_4 = new JLabel("\u6295\u6CE8\u865F\u78BC");
		panel_2.add(label_4, "cell 0 4 4 1,alignx center");
		label_4.setFont(new Font("標楷體", Font.BOLD, 18));
				//刪除選號		
						JButton button_49 = new JButton("\u522A\u9664\u9078\u865F");
						button_49.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								textPane.setText("");
								list_1.removeAll();
							}
						});
						button_49.setFont(new Font("微軟正黑體", Font.BOLD, 14));
						panel_2.add(button_49, "cell 0 6 4 1,grow");
						//對獎		
								
								JButton button = new JButton("~\u55AE\u7B46\u5C0D\u734E~");
								button.addActionListener(new ActionListener() {		
									public void actionPerformed(ActionEvent arg0) {
										
										if(!result.isEmpty())
										{
											if(list_1.getSelectedItem() != null)
											{
											String str="";
											String str1="";
											String str2="";
											String str3="";
										
                                      chosen = list_1.getSelectedItem().split("[, ]+");//已選號碼					
			   							Integer[] rout = new Integer[result.size()];//開獎號
										result.toArray(rout);
										int count=0;
										int bingo=0;
										for(String a:chosen)
										{
											for(int j=0;j<=5;j++)
											if(a.equals(String.format("%02d", rout[j])))
											{
												str += a+"  ";
												count++;
											}
										}
										    for(int j=0;j<=5;j++)
											if(chosen[j].equals(String.format("%02d", i7)))
											{
												str1 += String.format("%02d", i7);
												count++;
											}
										    
//switch				    
										    if((count==3)&&(str1.length()==0))
										    {
										    	bingo=1;
										    }
										    else if((count==3)&&(str1.length()!=0))
										    {
										    	bingo=2;
										    }
										    else if((count==4)&&(str1.length()!=0))
										    {
										    	bingo=3;
										    }
										    else if((count==4)&&(str1.length()==0))
										    {
										    	bingo=4;
										    }
										    else if((count==5)&&(str1.length()!=0))
										    {
										    	bingo=5;
										    }
										    else if((count==5)&&(str1.length()==0))
										    {
										    	bingo=6;
										    }
										    else if((count==6)&&(str1.length()!=0))
										    {
										    	bingo=7;
										    }
										    else if((count==6)&&(str1.length()==0))
										    {
										    	bingo=8;
										    }
										    				    
										    switch(bingo)
										    {
										    case 1:
										    	str3 = "恭喜中普獎\n****400元獎金****";
										    	break;
										    case 2:
										    	str3 = "恭喜中柒獎 \n****400元獎金****";
										    	break;
										    case 3:
										    	str3 = "恭喜中陸獎\n****1000元獎金****";
										    	break;
										    case 4:
										    	str3 = "恭喜中伍獎\n****2000元獎金****";
										    	break;
										    case 5:
										    	str3 = "恭喜中肆獎\n****有點多獎金****";
										    	break;
										    case 6:
										    	str3 = "恭喜中參獎\n***比有點多再多一點獎金***";
										    	break;
										    case 7:
										    	str3 = "恭喜中貳獎\n****好多獎金****";
										    	break;
										    case 8:
										    	str3 = "恭喜中頭獎\n****成為億萬富翁****";
										    	break;			    
										    default:
										    	str3 = "Oops!沒中獎,沒關係~再接再厲";
										    	break;	
										    }
										    
										    
										    if(str1.length()!=0) 
										    str2=("本組中 [ "+count+" ] 個號碼："+str+" 特別號"+str1+"\n"+str3);				    
										    else 
											str2=("本組中 [ "+count+" ] 個號碼："+str+"\n"+str3);
										    
										    textPane.setText(str2);
										    
											}
											else
											{
												JOptionPane.showMessageDialog(null,"請先選擇一組對獎號碼");
											}					
								    	}
										else
										{
											JOptionPane.showMessageDialog(null,"請先搖獎喔!");
										}
									}
								});
								

								
								button.setFont(new Font("微軟正黑體", Font.BOLD, 14));
								panel_2.add(button, "cell 4 6 4 1,grow");
								

		JButton btnNewButton_4 = new JButton("~\u6416\u734E~(\u958B\u734E\u5F8C\u91CD\u65B0\u9078\u865F\u8ACB\u6309\u6E05\u9664)");
//開獎
		btnNewButton_4.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				if(list_1.getItemCount()>0) {
		btnNewButton_3.setEnabled(false);
		button_46.setEnabled(false);
		button_48.setEnabled(false);
					 new myThread() 
					{
					public void run()
					{ 					
					for(int k=0;k<=30;k++){
						button.setEnabled(false);						
						button_1.setEnabled(false); 
						button_49.setEnabled(false);
					for(int a=0;a<49;a++)
					btn[a].setBackground(Color.YELLOW);
					result.clear();
					r7.setText("");
										
																
					do {
					result.add((int)(Math.random()*(49-1+1)+1));
					}
					while(result.size()!=6);								 
													    						 								
					do {
					i7=(int)(Math.random()*(49-1+1)+1);	
					}
					while(result.contains(i7));	
														
					String box7 = String.format("%02d", i7);	
			        Integer[] rout = new Integer[result.size()];//開講號
				    result.toArray(rout);
														
					r1.setText(String.format("%02d", rout[0]));	
					r2.setText(String.format("%02d", rout[1]));					    
					r3.setText(String.format("%02d", rout[2]));					    
				    r4.setText(String.format("%02d", rout[3]));					    
					r5.setText(String.format("%02d", rout[4]));					    
					r6.setText(String.format("%02d", rout[5]));
					for(int j=0;j<6;j++)
					btn[rout[j]-1].setBackground(Color.CYAN);
					r7.setText(box7);	
					btn[i7-1].setBackground(Color.MAGENTA);		
					try {
					myThread.sleep(50);						
					} 
					catch (InterruptedException e) {
					e.printStackTrace();
					}																									   
					}		
					button.setEnabled(true);
					button_1.setEnabled(true);
					button_49.setEnabled(true);
					}	
													
					}.start();
	                }
					else
					{JOptionPane.showMessageDialog(null,"請先確認至少一組選號");}
                    }});
					btnNewButton_4.setMinimumSize(new Dimension(57, 40));
					btnNewButton_4.setPreferredSize(new Dimension(57, 30));
					btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					btnNewButton_4.setBorder(UIManager.getBorder("CheckBox.border"));
					btnNewButton_4.setBackground(new Color(222, 184, 135));
					btnNewButton_4.setFont(new Font("標楷體", Font.BOLD, 20));
					panel_3.add(btnNewButton_4);
														
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
	}
	

}
