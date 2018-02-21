package com.imooc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class UpdateFrame extends JFrame {
	DefaultTableModel tm;
	JTable tb;
	String title = "";
	// Ů�������Ϣ
	int row = -1;
	int id = 0;
	String user_name = "";
	int sex = 1;
	int age = 0;
	String birthday = "";
	String email = "";
	String mobile = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";

	// ���췽��
	public UpdateFrame(String fname, DefaultTableModel tm, JTable tb) {
		this.tm = tm;
		this.tb = tb;
		this.title = fname;
		// ���ô��ڱ���
		this.setTitle(fname);
		// ���ó�ʼ������
		this.init();
		this.addPanel();
		// ���ô��ڿɼ�
		this.setVisible(true);

	}

	// ��ʼ��
	public void init() {
		// ���ô��ڴ�С
		this.setSize(400, 400);
		// ���ô���λ��
		this.setLocation(100, 50);
		// ���ô��ڹر�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// �������ӿؼ�
	public void addPanel() {
		if (title.equals("�޸�")) {
			row = tb.getSelectedRow();
			id = Integer.parseInt(tm.getValueAt(row, 0).toString());
			user_name = tm.getValueAt(row, 1).toString();
			sex = Integer.parseInt(tm.getValueAt(row, 2).toString());
			age = Integer.parseInt(tm.getValueAt(row, 3).toString());
			birthday = tm.getValueAt(row, 4).toString();
			email = tm.getValueAt(row, 5).toString();
			mobile = tm.getValueAt(row, 6).toString();
			create_user = tm.getValueAt(row, 7).toString();
			create_date = tm.getValueAt(row, 8).toString();
			create_user = tm.getValueAt(row, 9).toString();
			create_date = tm.getValueAt(row, 10).toString();
		}
		// �������
		JPanel p = new JPanel();
		p.setLayout(null);
		// id�����
		JLabel lbid = new JLabel("id��");
		lbid.setBounds(30, 10, 80, 30);
		final JTextField tfid = new JTextField("" + id);
		tfid.setBounds(130, 10, 180, 30);
		// ���������
		JLabel lbuser_name = new JLabel("������");
		lbuser_name.setBounds(30, 50, 80, 30);
		final JTextField tfcode = new JTextField(user_name);
		tfcode.setBounds(130, 50, 180, 30);
		// �Ա������
		JLabel lbsex = new JLabel("�Ա�");
		lbsex.setBounds(30, 90, 80, 30);
		final JTextField tfname = new JTextField(sex);
		tfname.setBounds(130, 90, 180, 30);
		// ���������
		JLabel lbage = new JLabel("���䣺");
		lbsex.setBounds(30, 130, 80, 30);
		JTextField tfsex = new JTextField("" + age);
		tfsex.setBounds(130, 130, 180, 30);
		// �ֻ������
		JLabel lbphone = new JLabel("�ֻ���");
		lbphone.setBounds(30, 170, 80, 30);
		JTextField tfphone = new JTextField(mobile);
		tfphone.setBounds(130, 170, 180, 30);
		// ��������
		JLabel lbbirthday = new JLabel("�������ڣ�");
		lbbirthday.setBounds(30, 210, 80, 30);
		JTextField tfbirthday = new JTextField(birthday);
		tfbirthday.setBounds(130, 210, 180, 30);

		// ���水ť
		JButton btnsave = new JButton("����");
		btnsave.setBounds(130, 270, 100, 30);

		// ����ť��ӵ���¼�
		btnsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ���»���������޸ĵ�Ů����Ϣ
				id = Integer.parseInt(tfid.getText());
				user_name = tfcode.getText();
				sex = Integer.parseInt(tfname.getText());
				
				GoddessDao gd = new GoddessDao();
				//����һ��Ů�����
				Goddess g = new Goddess();
			}
		});
	}
}
