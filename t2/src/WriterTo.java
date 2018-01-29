import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class WriterTo extends JFrame implements ActionListener {
	JButton b;
	JTextField t;

	public WriterTo() {
		super("文本框内容写入文件");
		JLabel l = new JLabel("请输入内容：");
		t = new JTextField(20);
		b = new JButton("写入");
		b.addActionListener(this);
		this.add(l);
		this.add(t);
		this.add(b);
		this.setLayout(new FlowLayout());
		this.pack();
		this.setVisible(true);
		this.setLocation(400, 400);
	}
	
	public static void main(String[] args) {
		new WriterTo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			if (t.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入内容~", "错误",
						JOptionPane.ERROR_MESSAGE);
				t.grabFocus();
			} else {
				write(t.getText());
				JOptionPane.showMessageDialog(null, "写入成功", "提示",
						JOptionPane.INFORMATION_MESSAGE);

				dispose();
				// 创建一个新界面
				UI ui = new UI();

			}
		}
	}

	public void write(String line) {
		try {
			File f = new File("d:/文本框.txt");// 向指定文本框内写入
			FileWriter fw = new FileWriter(f);
			fw.write(line);
			fw.close();
		} catch (Exception e) {
		}
	}

	// public static void main(String[] args) {
	// new WriterTo();
	// }
}