//package com.package_2;  

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.*;

public class UI extends JFrame implements ActionListener {

	// �������
	JButton jb1, jb2, jb3 = null;
	JPanel jp1, jp2, jp3, jp4 = null;
	JLabel jlb1, jlb2, jlb3, jlb4, jlb5 = null;
	JTextField jtf1, jtf2 = null;
	JTextArea jta1 = null;

	String filePath = "d:/�ı���.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI ui = new UI();
	}

	// ���캯��
	public UI() // ��������Ϊvoid!!!!!���򵯲����½���
	{
		// �������
		jb1 = new JButton("��ȡ");
		jb1.addActionListener(this);
		jb2 = new JButton("д��");
		jb2.addActionListener(this);
		jb3 = new JButton("����3");
		jb3.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		jlb1 = new JLabel("hello");
		jlb2 = new JLabel("world");

		jtf1 = new JTextField(100);
		// jtf2=new JTextField(15);
		jta1 = new JTextArea(5, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);

		jp2.add(jb1);
		// jp2.add(jtf2); //��ȡ�ļ�
		jp2.add(jta1); // ��ȡ�ļ�
		// System.out.println("��ȡ�ɹ���");

		jp3.add(jb2); // д��
		// jp3.add(jlb4);

		// jp4.add(jtf1);
		jp4.add(jb3);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);

		// ���ò��ֹ�����
		this.setLayout(new GridLayout(4, 4, 20, 20)); // 4��4��
		this.setTitle("����2");
		this.setSize(600, 400);
		this.setLocation(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "д��") {
			dispose();
			WriterTo wt = new WriterTo();
		} else if (e.getActionCommand() == "��ȡ") {
			// readTxt(filePath);
			String s2 = readToString(filePath);
			jta1.setText(s2);
		} else if (e.getActionCommand() == "����3") {
			dispose();
			GUIRWFile rw = new GUIRWFile();
		}

	}

	// ���ж�
	public void readTxt(String filePath) {

		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				String AllTxt = "";
				System.out.println("��ʼ��ӡ");
				while ((lineTxt = br.readLine()) != null) {
					// System.out.println(lineTxt);//
					AllTxt = AllTxt + lineTxt;
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
	}

	// ��ȡ�ı���
	public String readToString(String filePath) {
		String encoding = "UTF-8"; // ��ֹ��������
		// String encoding ="GBK"; //��ֹ��������
		File file = new File(filePath);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			String s1 = new String(filecontent, encoding);
			in.close();
			System.out.println("��ȡ���������ǣ�" + s1);
			// jta1.setText(s1);//
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}

}
