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
		super("文本读写");
		txtMessage = new JTextArea(25, 50);
		brnOpen = new JButton("打开文件");
		btnRead = new JButton("  读取  ");
		btnWrite = new JButton("  写入  ");
		this.setLayout(new FlowLayout());
		this.add(new JLabel("文件内容："));
		this.add(txtMessage);
		this.add(brnOpen);
		this.add(btnRead);
		this.add(btnWrite);
		brnOpen.addActionListener(this);
		btnRead.addActionListener(this);
		btnWrite.addActionListener(this);
		this.setSize(600, 600);//宽和高
		this.setLocation(600, 300);//宽和高
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GUIRWFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == "打开文件"){
			fileName=fileChooser();
			 System.out.println(fileName);
		}else if (e.getActionCommand() == "  读取  "){
			txtMessage.setText(readG(fileName));
		}else if (e.getActionCommand() == "  写入  ") {
			writeG(fileName);
		}
	}
	//获得其他文件的路径
		public String fileChooser() {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif","txt");
		    //设置文件类型
		    chooser.setFileFilter(filter);
		    //打开选择器面板
		    int returnVal = chooser.showOpenDialog(new JPanel());  
		    //保存文件从这里入手，输出的是文件名
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
//		       System.out.println("你打开的文件是: " +chooser.getSelectedFile().getName());
		       System.out.println("你打开的文件路径是: " +chooser.getSelectedFile().getName());
		    }
//		    return chooser.getSelectedFile().getName();
		    return chooser.getSelectedFile().getPath();
	}
	//buffer按行读
	public String readG(String filePath){
		String Alltxt="";
		 System.out.println(filePath);
		try {
			InputStream is = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			StringBuffer buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");//这个虽然多次读，但是每次加换行就行了
			}
			Alltxt=buffer.toString();
			br.close();
			is.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "系统I/O错误！");
		}
		return Alltxt;
	}
	
	//写入
	public void writeG(String filePath){
		try {
			String msg = txtMessage.getText();
			OutputStream os = new FileOutputStream(filePath);
			PrintStream ps = new PrintStream(os);
			ps.print(msg);
			ps.close();
			os.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "系统I/O错误！");
		}
	}
	
	//全文一次读
	public String readAll(String filePath) {  
        String encoding ="UTF-8";  //防止中文乱码
//        String encoding ="GBK";  //防止中文乱码
        File file = new File(filePath);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            String s1=new String(filecontent,encoding);
            in.close();  
            System.out.println("读取到的内容是："+s1);
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
	//全文按行读
	public String readlines(String filePath) {
		String AllTxt = "";
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				System.out.println("开始打印");
				while ((lineTxt = br.readLine()) != null) {
					// System.out.println(lineTxt);//
					AllTxt = AllTxt + lineTxt +'\n';
				}
				System.out.println(AllTxt);
				// jtf2.setText(AllTxt);
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
		return AllTxt;
	}
	
	
}