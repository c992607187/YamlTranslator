  
import javax.swing.*;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

  
public class main2 extends JFrame implements ActionListener {  
  
    //�������  
    JButton jb1,jb2=null;  
//    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //�趨�û���������  
    final String stu_name="1";  
    final String stu_pwd="2";  
      
    String filePath = "d:/�ı���.txt";
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        main2  ms=new main2();  
    }  
    public main2()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);   
          
        jp1=new JPanel();  
        jp2=new JPanel();  
       // jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("�û�����");  
        jlb2=new JLabel("��    �룺");  
        //jlb3=new JLabel("Ȩ    �ޣ�");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        //jp3.add(jlb3);  
        //jp3.add(jrb1);  
        //jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
          
        //����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        //this.add(jp3);  
        this.add(jp4);  
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("����");  
        //���ô����С  
        this.setSize(300,200);  
        //���ô����ʼλ��  
        this.setLocation(400, 400);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="��¼")  
        {  

            login(); 
        }else if(e.getActionCommand()=="����")  
        {  
                  clear();  
        }             
          
    }  
      
    public void login()  
    {  
        if(stu_name.equals(jtf.getText())&&stu_pwd.equals(jpf.getText()))  
        {  
//          System.out.println("��¼�ɹ�");  
            JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            clear();  
            //�رյ�ǰ����  
            dispose();  
            //����һ���½���  
//            UI ui=new UI();  
            new GUIRWFile();
            
            
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
            //��������  
            clear();  
        }  
    }  

    //����ı���������  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  
          
}  
