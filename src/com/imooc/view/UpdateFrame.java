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
	// 女神基本信息
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

	// 构造方法
	public UpdateFrame(String fname, DefaultTableModel tm, JTable tb) {
		this.tm = tm;
		this.tb = tb;
		this.title = fname;
		// 设置窗口标题
		this.setTitle(fname);
		// 调用初始化窗口
		this.init();
		this.addPanel();
		// 设置窗口可见
		this.setVisible(true);

	}

	// 初始化
	public void init() {
		// 设置窗口大小
		this.setSize(400, 400);
		// 设置窗口位置
		this.setLocation(100, 50);
		// 设置窗口关闭
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 给面板添加控件
	public void addPanel() {
		if (title.equals("修改")) {
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
		// 创建面板
		JPanel p = new JPanel();
		p.setLayout(null);
		// id输入框
		JLabel lbid = new JLabel("id：");
		lbid.setBounds(30, 10, 80, 30);
		final JTextField tfid = new JTextField("" + id);
		tfid.setBounds(130, 10, 180, 30);
		// 姓名输入框
		JLabel lbuser_name = new JLabel("姓名：");
		lbuser_name.setBounds(30, 50, 80, 30);
		final JTextField tfcode = new JTextField(user_name);
		tfcode.setBounds(130, 50, 180, 30);
		// 性别输入框
		JLabel lbsex = new JLabel("性别：");
		lbsex.setBounds(30, 90, 80, 30);
		final JTextField tfname = new JTextField(sex);
		tfname.setBounds(130, 90, 180, 30);
		// 年龄输入框
		JLabel lbage = new JLabel("年龄：");
		lbsex.setBounds(30, 130, 80, 30);
		JTextField tfsex = new JTextField("" + age);
		tfsex.setBounds(130, 130, 180, 30);
		// 手机输入框
		JLabel lbphone = new JLabel("手机：");
		lbphone.setBounds(30, 170, 80, 30);
		JTextField tfphone = new JTextField(mobile);
		tfphone.setBounds(130, 170, 180, 30);
		// 出生日期
		JLabel lbbirthday = new JLabel("出生日期：");
		lbbirthday.setBounds(30, 210, 80, 30);
		JTextField tfbirthday = new JTextField(birthday);
		tfbirthday.setBounds(130, 210, 180, 30);

		// 保存按钮
		JButton btnsave = new JButton("保存");
		btnsave.setBounds(130, 270, 100, 30);

		// 给按钮添加点击事件
		btnsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 重新获得新增或修改的女神信息
				id = Integer.parseInt(tfid.getText());
				user_name = tfcode.getText();
				sex = Integer.parseInt(tfname.getText());
				
				GoddessDao gd = new GoddessDao();
				//创建一个女神对象
				Goddess g = new Goddess();
			}
		});
	}
}
