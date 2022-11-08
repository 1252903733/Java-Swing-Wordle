
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
	
	
JButton textfield[]=new JButton[30];//����30�����	
public int frequency =0;//������ǲ²�Ĵ���
public int k=-1;//����ִ�б�ǵڼ������  
public JPanel Themainpanel;//��Ҫ�����������
public JButton explain;
public JButton ok;//����һ��ȷ��ѡ���
ArrayList<String> data=new ArrayList<>();//����һ����̬�����ַ���
public String choosedata;//����һ����ѡ����ַ���
public JLabel Promptfortext;//����һ����ʾ�����
public JTextField inputfield ;//����һ�������
public JTextField Accordingtotheword;//����һ����ʾѡ�����ĸ���
public JButton showandhide;//����һ����ʾ�������صİ�ť
public JLabel title;//���������ʾ
public JButton random_drawing;//�����ȡ


public void content_generation()
{
	
	Themainpanel = new JPanel();//��Ҫ�������
	ok=new JButton("affirm ");//����һ��ȷ����ťaffrim
	inputfield =new JTextField("");//����һ������� Ĭ�ϸտ�ʼΪ��
	Accordingtotheword=new JTextField("");//����һ����ʾѡ���
	Promptfortext=new JLabel("Please enter the guess word:");//��ʾ�����Ϣ
	showandhide=new JButton("hide");//Ĭ�ϸտ�ʼΪhide
	title=new JLabel("WORDLE");
	explain=new JButton("explain");
	random_drawing=new JButton("random drawing");
}

public Guesstheword()//��ʼ��
{
init();//��ʼ������  �ú�����Ҫ��ȡtxt ͬʱ�����ȡһЩ
content_generation();//�ú�����ʼÿ���������ʾ������
int i;//����i i������������
Themainpanel.setLayout(null);//Ĭ��λ��  �ı��ݴ�СҲ����ı���λ��
Accordingtotheword.setEditable(false);//Ĭ����ʾ��ѡ��Ĳ��ܱ༭
this.setLayout(new BorderLayout());//���õ�ǰ����
Promptfortext.setSize(200, 30);////������ʾ��ʾ�����Ĵ�С
Promptfortext.setLocation(0, 20);//������ʾ��ʾ������λ��
Themainpanel.add(Promptfortext);//����ʾ�������ӵ���Ҫ���������
inputfield .setSize(100,30);//���������Ĵ�С
inputfield .setLocation(180, 20);//����������λ��
Themainpanel.add(inputfield );//���������ӵ���Ҫ�������

random_drawing.setSize(130,30);
random_drawing.setLocation(280,20);
Themainpanel.add(random_drawing);


ok.setSize(100,30);//����ok��ť�Ĵ�С
ok.setLocation(420,20);//����oK��ť��λ��
Themainpanel.add(ok);//��ok��ť��ӵ���Ҫ���������
explain.setSize(100,30);//���ý��Ͱ�ť�Ĵ�С
explain.setLocation(500,20);//���ý��Ͱ�ť��λ��
Themainpanel.add(explain);
title.setForeground(Color.red);
Font f=new Font("΢���ź�",Font.BOLD,40);
title.setFont(f);
title.setSize(600,50);
title.setLocation(230, 80);



Themainpanel.add(title);
showandhide.setSize(80,30);//������ʾ���ذ�ť�Ĵ�С
showandhide.setLocation(620,20);//������ʾ���ذ�ť��λ��
Themainpanel.add(showandhide);//����ʾ���ذ�ť��λ����ӵ���Ҫ���������
Accordingtotheword.setSize(80,30);//����ѡ����ʾ����С
Accordingtotheword.setLocation(700,20);//����ѡ����ʾ���λ��
Themainpanel.add(Accordingtotheword);//��ѡ����ʾ�ı����뵽��Ҫ���������
for(i=0;i<30;i++)//froѭ������
{
textfield[i]=new JButton("");//ÿ�����Ϊ��
textfield[i].setSize(90,90);//ÿ�����Ĵ�СΪ 50   50
textfield[i].setBackground(Color.white);
textfield[i].setLocation(i%5*100+95, i/5*100+95+60);//ÿ������λ��  ʵ�ʾ���x y����
textfield[i].setBorder(BorderFactory.createLineBorder(Color.gray, 2));
Themainpanel.add(textfield[i]);//��ÿ�������ӵ���Ҫ���������
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
	
		title.setFont(new Font("΢���ź�",Font.BOLD,60));
		
		
    }

	@Override
	public void mouseExited(MouseEvent e){
		title.setFont(new Font("΢���ź�",Font.BOLD,40));
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
		 
		
		 frequency =0;//�������±��Ϊ0
		 k=-1;//k���±��Ϊ-1��ʾ��0��ʼ
		 int i;
		 for(i=0;i<30;i++)//froѭ������
		 {
			 
			 textfield[i].setBackground(Color.white); 
			 textfield[i].setText("");//����ÿ�����Ϊ��ǰ��ĸ
					
		 }

		
    }


	
});





explain.addActionListener(new ActionListener() {//��Ӱ�ť��������¼�
@Override
public void actionPerformed(ActionEvent e) {

	JFrame ff=new JFrame("explain");
	 ff.setSize(400, 400);
    
     ff.add(new JLabel("<html>"
     		+ "<body>"
     		+ "<p>1.���û���6�γ����ڲ³�5����ĸ�ĵ���;</p>"
     		+ "<p>2.��������Ǽ�����ӵ����б������ѡ���;</p>"
     		+ "<p>3.�û���ÿ�γ��Ժ󶼻�õ�����;</p>"
     		+ "<p>4.�û����벻��5����ĸ���������֣���������;;</p>"
     		+ "<p>5.�ж��û����벻��Ӣ�ĵ��ʲ���������;����������;;</p>"
     		+ "<p>6.�����6�β²��ڲ�����ȷ���ʸ�����ʤ����;</p>"
     		+ "<p>7.����ܹ���6�ε�û�в���Ŀ�굥�ʸ���ʧ�ܷ���;</p>"
     		+ "<p>8.�������ַ���������ѯ������Ƿ�����һ��;</p>"
     		+ "<p>9.�û���ÿ�γ��Ժ󶼻�õ�����;</p>"
     		+ "<body>"
     		+ "</html>"));
     ff.setVisible(true);
}
});




ok.addActionListener(new ActionListener() {//��Ӱ�ť��������¼�
@Override
public void actionPerformed(ActionEvent e) {
	String regex = "[a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z]"; //����һ��������ʽ ���ʽҪ��6��Ӣ����ĸ �����ִ�Сд
	if(frequency ==6)//���frequency =6˵���Ѿ�����
	{
		 JOptionPane.showMessageDialog(null, "You've had more than six");	
		
	}
	else if(inputfield .getText().equals(""))//��ʾ���벻��Ϊ��
	{
		 JOptionPane.showMessageDialog(null, "The input cannot be null");
		
	}
	else if(inputfield .getText().length()>5)//��ʾ����ĳ��Ȳ��ܴ���5
	{
		 JOptionPane.showMessageDialog(null, "No more than five characters");
		
	}

	else if(inputfield .getText().length()<5)//��ʾ����ĵ��ʳ��Ȳ���С��5
	{
		 JOptionPane.showMessageDialog(null, "Can't be less than five letters");
		
	}
	 else if(!inputfield .getText().matches(regex))//�����������ʽ��ƥ�� ˵�����Ǹ�Ӣ����ĸ
	{
		JOptionPane.showMessageDialog(null, "There must be no other non-English letters");
		
	}
	 else
	 {
		 int i=0;//i�Ǳ��������ÿ�����ʵ�ÿ����ĸ
		 frequency ++;//frequency �Ǳ�ʾ�ڼ��β²�
		
		 for(i=0;i<inputfield .getText().length();i++)//forѭ���������뵥�ʵĳ���
		 {
	     k++;//k�ǵڼ������  ��0��ʼ
		if(choosedata.charAt(i)==inputfield .getText().charAt(i))//�������ͬλ�� ����ͬ��ĸ ��Ǳ���Ϊ��ɫ
		 {
			 
			textfield[k].setBackground(Color.GREEN);
    	
		 }
		 else if(choosedata.contains(String.valueOf(inputfield .getText().charAt(i))))//������ڸ���ĸ  ���ǲ��ڸ�λ�� ���Ϊ��ɫ
		 {
				textfield[k].setBackground(Color.YELLOW);
		 }
		 else//���Ϊ��ɫ
		 {
			 
			 textfield[k].setBackground(Color.gray); 
			 
		 }
		
		   
		
		Font f1=new Font("΢���ź�",Font.BOLD,40);
		textfield[k].setFont(f1);
		textfield[k].setForeground(Color.black);
		textfield[k].setText(String.valueOf(inputfield .getText().charAt(i)));//����ÿ�����Ϊ��ǰ��ĸ
			
			
			
			
		 }
		 
		 
			if(String.valueOf(inputfield .getText()).equals(choosedata))//�������ĵ�ǰ���ʵ���ѡ��ĵ���˵���жϳɹ� ����������ѡ�����Ϣ
			{
				
				 JOptionPane.showMessageDialog(null, "You guessed right");	
				 ok.setText("You guessed right");
				 ok.setEnabled(false);
				 if(JOptionPane.showConfirmDialog(null, "Whether to re-implement��","ok",JOptionPane.OK_CANCEL_OPTION)==0)
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
			
		if(frequency ==6&&!String.valueOf(inputfield .getText()).equals(choosedata))	//���ѡ��������� �����һ�λ���û�в¶� ִ�в²�ʧ�ܵ���Ϣ
		{
			 ok.setText("You failed");
			 ok.setEnabled(false);
			 JOptionPane.showMessageDialog(null, "Guess failure");	
			 if(JOptionPane.showConfirmDialog(null, "Whether to re-implement��","ok",JOptionPane.OK_CANCEL_OPTION)==0)
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




showandhide.addActionListener(new ActionListener() {//��Ӱ�ť��������¼�
@Override
public void actionPerformed(ActionEvent e) {//�����hide ����ͱ�show �����show����ͱ�hide ͬʱ����hide����show�������Ƿ���ʾ�²�ĵ���
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

this.add(BorderLayout.CENTER,Themainpanel);//����
this.setTitle("Word guessing");
this.setSize(800, 800);
this.setVisible(true);
}




public void init()
{
	

    try {
        File myFile = new File("bin/word.txt");//ͨ���ַ�������File���Ͷ���ָ����ַ���·���µ��ļ�
        if (myFile.isFile() && myFile.exists()) { //�ж��ļ��Ƿ����
            InputStreamReader Reader = new InputStreamReader(new FileInputStream(myFile), "UTF-8");
            //���ǵ������ʽ��new FileInputStream(myFile)�ļ��ֽ������������ֽ�Ϊ��λ���ļ��е����ݽ��ж�ȡ
            //new InputStreamReader(FileInputStream a, "��������")
            //���ļ��ֽ�������ת��Ϊ�ļ��ַ������������������ʽ
            BufferedReader bufferedReader = new BufferedReader(Reader);
            //BufferedReader���ַ��������ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ��
            //ͨ��BuffereReader��װʵ�ָ�Ч��ȡ
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                //buffereReader.readLine()���ж�ȡд���ַ���
                System.out.println(lineTxt);
                data.add(lineTxt);
                
            }
            Reader.close();
        } else {
            System.out.println("�Ҳ���ָ�����ļ�");
        }

    } catch (Exception e1) {
        System.out.println("��ȡ�ļ����ݳ���");
        e1.printStackTrace();
    }
    choosedata= data.get((int)(Math.random()*(data.size()-2)+0)).substring(0,5);
}

public static void main(String[] args) {
new Guesstheword();//��Ҫ����
}

}

