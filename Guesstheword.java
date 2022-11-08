
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Guesstheword extends JFrame{
	
	
JButton textfield[]=new JButton[30];//定义30个表格	
public int frequency =0;//用来标记猜测的次数
public int k=-1;//用来执行标记第几个表格  
public JPanel Themainpanel;//主要窗口面板容器
public JButton explain;
public JButton ok;//定义一个确定选择键
ArrayList<String> data=new ArrayList<>();//定义一个动态数组字符串
public String choosedata;//定义一个被选择的字符串
public JLabel Promptfortext;//定义一个提示输入框
public JTextField inputfield ;//定义一个输入框
public JTextField Accordingtotheword;//定义一个显示选择的字母框框
public JButton showandhide;//定义一个显示或者隐藏的按钮
public JLabel title;//定义标题显示
public JButton random_drawing;//随机抽取


public void content_generation()
{
	
	Themainpanel = new JPanel();//主要面板容器
	ok=new JButton("affirm ");//定义一个确定按钮affrim
	inputfield =new JTextField("");//定义一个输入框 默认刚开始为空
	Accordingtotheword=new JTextField("");//定义一个显示选择框
	Promptfortext=new JLabel("Please enter the guess word:");//提示输出信息
	showandhide=new JButton("hide");//默认刚开始为hide
	title=new JLabel("WORDLE");
	explain=new JButton("explain");
	random_drawing=new JButton("random drawing");
}

public Guesstheword()//初始化
{
init();//初始化函数  该函数主要读取txt 同时随机抽取一些
content_generation();//该函数初始每个标题和提示的内容
int i;//定义i i用来遍历个数
Themainpanel.setLayout(null);//默认位置  改变容大小也不会改变其位置
Accordingtotheword.setEditable(false);//默认显示被选择的不能编辑
this.setLayout(new BorderLayout());//设置当前布局
Promptfortext.setSize(200, 30);////定义提示提示输入框的大小
Promptfortext.setLocation(0, 20);//定义提示提示输入框的位置
Themainpanel.add(Promptfortext);//将显示输入框添加道主要面板容器类
inputfield .setSize(100,30);//定义输入框的大小
inputfield .setLocation(180, 20);//定义输入框的位置
Themainpanel.add(inputfield );//将输入框添加道主要面包器类

random_drawing.setSize(130,30);
random_drawing.setLocation(280,20);
Themainpanel.add(random_drawing);


ok.setSize(100,30);//设置ok按钮的大小
ok.setLocation(420,20);//设置oK按钮的位置
Themainpanel.add(ok);//将ok按钮添加道主要面板容器类
explain.setSize(100,30);//设置解释按钮的大小
explain.setLocation(500,20);//设置解释按钮的位置
Themainpanel.add(explain);
title.setForeground(Color.red);
Font f=new Font("微软雅黑",Font.BOLD,40);
title.setFont(f);
title.setSize(600,50);
title.setLocation(230, 80);



Themainpanel.add(title);
showandhide.setSize(80,30);//设置显示隐藏按钮的大小
showandhide.setLocation(620,20);//设置显示隐藏按钮的位置
Themainpanel.add(showandhide);//将显示隐藏按钮的位置添加道主要面板容器类
Accordingtotheword.setSize(80,30);//设置选择显示框额大小
Accordingtotheword.setLocation(700,20);//设置选择显示框的位置
Themainpanel.add(Accordingtotheword);//将选择显示文本加入到主要面板容器类
for(i=0;i<30;i++)//fro循环遍历
{
textfield[i]=new JButton("");//每个表格为空
textfield[i].setSize(90,90);//每个表格的大小为 50   50
textfield[i].setBackground(Color.white);
textfield[i].setLocation(i%5*100+95, i/5*100+95+60);//每个表格的位置  实际就是x y坐标
textfield[i].setBorder(BorderFactory.createLineBorder(Color.gray, 2));
Themainpanel.add(textfield[i]);//将每个表格添加道主要面板容器类
}




//Please enter the guess word:




for(i=0;i<30;i++)
{
	int b=i;
textfield[i].addMouseListener(new MouseAdapter(){
	@Override
	public void mouseEntered(MouseEvent e){
            textfield[b].setSize(100,100);
    }

	@Override
	public void mouseExited(MouseEvent e){
            textfield[b].setSize(90,90);
    }
   
	
});
}



title.addMouseListener(new MouseAdapter(){
	@Override
	public void mouseEntered(MouseEvent e){
	
		title.setFont(new Font("微软雅黑",Font.BOLD,60));
		
		
    }

	@Override
	public void mouseExited(MouseEvent e){
		title.setFont(new Font("微软雅黑",Font.BOLD,40));
    }
   
	
});



random_drawing.addMouseListener(new MouseAdapter(){
	@Override
	public void mouseClicked(MouseEvent e){
	
		choosedata="";
		ok.setText("affirm");
		 ok.setEnabled(true);
		 choosedata= data.get((int)(Math.random()*(data.size()-2)+0)).substring(0,5);
		 System.out.println( choosedata);
		 if(showandhide.getText().equals("show"))
		 {
			  Accordingtotheword.setText(choosedata);
		 }
		 
		
		 frequency =0;//次数重新标记为0
		 k=-1;//k重新标价为-1表示从0开始
		 int i;
		 for(i=0;i<30;i++)//fro循环遍历
		 {
			 
			 textfield[i].setBackground(Color.white); 
			 textfield[i].setText("");//设置每个表格为当前字母
					
		 }

		
    }


	
});





explain.addActionListener(new ActionListener() {//添加按钮点击触发事件
@Override
public void actionPerformed(ActionEvent e) {

	JFrame ff=new JFrame("explain");
	 ff.setSize(400, 400);
    
     ff.add(new JLabel("<html>"
     		+ "<body>"
     		+ "<p>1.让用户在6次尝试内猜出5个字母的单词;</p>"
     		+ "<p>2.五个单词是计算机从单词列表中随机选择的;</p>"
     		+ "<p>3.用户在每次尝试后都会得到反馈;</p>"
     		+ "<p>4.用户输入不是5个字母或输入数字，发出警告;;</p>"
     		+ "<p>5.判断用户输入不是英文单词并发出警告;，发出警告;;</p>"
     		+ "<p>6.玩家在6次猜测内猜中正确单词给出获胜反馈;</p>"
     		+ "<p>7.玩家总共猜6次但没有猜中目标单词给出失败反馈;</p>"
     		+ "<p>8.以上两种反馈结束后询问玩家是否再玩一次;</p>"
     		+ "<p>9.用户在每次尝试后都会得到反馈;</p>"
     		+ "<body>"
     		+ "</html>"));
     ff.setVisible(true);
}
});




ok.addActionListener(new ActionListener() {//添加按钮点击触发事件
@Override
public void actionPerformed(ActionEvent e) {
	String regex = "[a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z]"; //定义一个正则表达式 表达式要求6个英文字母 不区分大小写
	if(frequency ==6)//如果frequency =6说明已经六次
	{
		 JOptionPane.showMessageDialog(null, "You've had more than six");	
		
	}
	else if(inputfield .getText().equals(""))//提示输入不能为空
	{
		 JOptionPane.showMessageDialog(null, "The input cannot be null");
		
	}
	else if(inputfield .getText().length()>5)//提示输入的长度不能大于5
	{
		 JOptionPane.showMessageDialog(null, "No more than five characters");
		
	}

	else if(inputfield .getText().length()<5)//提示输入的单词长度不能小于5
	{
		 JOptionPane.showMessageDialog(null, "Can't be less than five letters");
		
	}
	 else if(!inputfield .getText().matches(regex))//如果跟正则表达式不匹配 说明不是个英文字母
	{
		JOptionPane.showMessageDialog(null, "There must be no other non-English letters");
		
	}
	 else
	 {
		 int i=0;//i是遍历输入的每个单词的每个字母
		 frequency ++;//frequency 是表示第几次猜测
		
		 for(i=0;i<inputfield .getText().length();i++)//for循环遍历输入单词的长度
		 {
	     k++;//k是第几个表格  从0开始
		if(choosedata.charAt(i)==inputfield .getText().charAt(i))//如果在相同位置 且相同字母 标记背景为绿色
		 {
			 
			textfield[k].setBackground(Color.GREEN);
    	
		 }
		 else if(choosedata.contains(String.valueOf(inputfield .getText().charAt(i))))//如果存在高字母  但是不在该位置 标记为黄色
		 {
				textfield[k].setBackground(Color.YELLOW);
		 }
		 else//标记为灰色
		 {
			 
			 textfield[k].setBackground(Color.gray); 
			 
		 }
		
		   
		
		Font f1=new Font("微软雅黑",Font.BOLD,40);
		textfield[k].setFont(f1);
		textfield[k].setForeground(Color.black);
		textfield[k].setText(String.valueOf(inputfield .getText().charAt(i)));//设置每个表格为当前字母
			
			
			
			
		 }
		 
		 
			if(String.valueOf(inputfield .getText()).equals(choosedata))//如果输入的当前单词等于选择的单词说明判断成功 并弹出重新选择的信息
			{
				
				 JOptionPane.showMessageDialog(null, "You guessed right");	
				 ok.setText("You guessed right");
				 ok.setEnabled(false);
				 if(JOptionPane.showConfirmDialog(null, "Whether to re-implement？","ok",JOptionPane.OK_CANCEL_OPTION)==0)
				 {  
					 new Guesstheword();
				
				 }
				 else
				 {
					 
					 System.exit(0);
				 }

			}
		
			
		if(frequency !=6&&!String.valueOf(inputfield .getText()).equals(choosedata))
		{
			JOptionPane.showMessageDialog(null, "I'm sorry you guessed wrong");
			
		}
			
		if(frequency ==6&&!String.valueOf(inputfield .getText()).equals(choosedata))	//如果选择等于六次 且最后一次还是没有猜对 执行猜测失败的信息
		{
			 ok.setText("You failed");
			 ok.setEnabled(false);
			 JOptionPane.showMessageDialog(null, "Guess failure");	
			 if(JOptionPane.showConfirmDialog(null, "Whether to re-implement？","ok",JOptionPane.OK_CANCEL_OPTION)==0)
			 { 
				 new Guesstheword();
				
			 }
			 else
			 {
				 
				 System.exit(0);
			 }

		}	
				
			
			
		 
		 
		 
		 
		 
		 
		 
	 }

	
	
}



private String String(char charAt) {
	// TODO Auto-generated method stub
	return null;
}
});




showandhide.addActionListener(new ActionListener() {//添加按钮点击触发事件
@Override
public void actionPerformed(ActionEvent e) {//如果是hide 点击就变show 如果是show点击就变hide 同时根据hide或者show来进行是否显示猜测的单词
if(showandhide.getText().equals("hide"))	
{
	showandhide.setText("show");	
	Accordingtotheword.setText(choosedata);
}

else
{
	showandhide.setText("hide");
	Accordingtotheword.setText("");
}


}

});

this.add(BorderLayout.CENTER,Themainpanel);//布局
this.setTitle("Word guessing");
this.setSize(800, 800);
this.setVisible(true);
}




public void init()
{
	

    try {
        File myFile = new File("bin/word.txt");//通过字符串创建File类型对象，指向该字符串路径下的文件
        if (myFile.isFile() && myFile.exists()) { //判断文件是否存在
            InputStreamReader Reader = new InputStreamReader(new FileInputStream(myFile), "UTF-8");
            //考虑到编码格式，new FileInputStream(myFile)文件字节输入流，以字节为单位对文件中的数据进行读取
            //new InputStreamReader(FileInputStream a, "编码类型")
            //将文件字节输入流转换为文件字符输入流并给定编码格式
            BufferedReader bufferedReader = new BufferedReader(Reader);
            //BufferedReader从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
            //通过BuffereReader包装实现高效读取
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                //buffereReader.readLine()按行读取写成字符串
                System.out.println(lineTxt);
                data.add(lineTxt);
                
            }
            Reader.close();
        } else {
            System.out.println("找不到指定的文件");
        }

    } catch (Exception e1) {
        System.out.println("读取文件内容出错");
        e1.printStackTrace();
    }
    choosedata= data.get((int)(Math.random()*(data.size()-2)+0)).substring(0,5);
}

public static void main(String[] args) {
new Guesstheword();//主要窗口
}

}

