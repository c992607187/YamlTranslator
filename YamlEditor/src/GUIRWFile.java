import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUIRWFile extends JFrame implements ActionListener {
	JTextArea txtMessage;
	JButton brnOpen,btnRead, btnWrite;
	String fileName = "D:\\test.txt";

	public GUIRWFile() {
		super("�ı���д");
		txtMessage = new JTextArea(25, 50);
		brnOpen = new JButton("���ļ�");
		btnRead = new JButton("  ��ȡ  ");
		btnWrite = new JButton("  д��  ");
		this.setLayout(new FlowLayout());
		this.add(new JLabel("�ļ����ݣ�"));
		this.add(txtMessage);
		this.add(brnOpen);
		this.add(btnRead);
		this.add(btnWrite);
		brnOpen.addActionListener(this);
		btnRead.addActionListener(this);
		btnWrite.addActionListener(this);
		this.setSize(600, 600);//��͸�
		this.setLocation(600, 300);//��͸�
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GUIRWFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == "���ļ�"){
			fileName=fileChooser();
			 System.out.println(fileName);
		}else if (e.getActionCommand() == "  ��ȡ  "){
			txtMessage.setText(readG(fileName));
		}else if (e.getActionCommand() == "  д��  ") {
			writeG(fileName);
		}
	}
	//��������ļ���·��
		public String fileChooser() {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif","txt");
		    //�����ļ�����
		    chooser.setFileFilter(filter);
		    //��ѡ�������
		    int returnVal = chooser.showOpenDialog(new JPanel());  
		    //�����ļ����������֣���������ļ���
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
//		       System.out.println("��򿪵��ļ���: " +chooser.getSelectedFile().getName());
		       System.out.println("��򿪵��ļ�·����: " +chooser.getSelectedFile().getName());
		    }
//		    return chooser.getSelectedFile().getName();
		    return chooser.getSelectedFile().getPath();
	}
	//buffer���ж�
	public String readG(String filePath){
		String Alltxt="";
		 System.out.println(filePath);
		try {
			InputStream is = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			StringBuffer buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");//�����Ȼ��ζ�������ÿ�μӻ��о�����
			}
			Alltxt=buffer.toString();
			br.close();
			is.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "ϵͳI/O����");
		}
		return Alltxt;
	}
	
	//д��
	public void writeG(String filePath){
		try {
			String msg = txtMessage.getText();
			OutputStream os = new FileOutputStream(filePath);
			PrintStream ps = new PrintStream(os);
			ps.print(msg);
			ps.close();
			os.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "ϵͳI/O����");
		}
	}
	
	//ȫ��һ�ζ�
	public String readAll(String filePath) {  
        String encoding ="UTF-8";  //��ֹ��������
//        String encoding ="GBK";  //��ֹ��������
        File file = new File(filePath);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            String s1=new String(filecontent,encoding);
            in.close();  
            System.out.println("��ȡ���������ǣ�"+s1);
//            jta1.setText(s1);//
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent,encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }
	//ȫ�İ��ж�
	public String readlines(String filePath) {
		String AllTxt = "";
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				System.out.println("��ʼ��ӡ");
				while ((lineTxt = br.readLine()) != null) {
					// System.out.println(lineTxt);//
					AllTxt = AllTxt + lineTxt +'\n';
				}
				System.out.println(AllTxt);
				// jtf2.setText(AllTxt);
				br.close();
			} else {
				System.out.println("�ļ�������!");
			}
		} catch (Exception e) {
			System.out.println("�ļ���ȡ����!");
		}
		return AllTxt;
	}
	
	
}