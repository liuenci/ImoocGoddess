package com.imooc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class MainFrame extends JFrame {

	// 主面板
	private JPanel pmain;
	// 表格对象
	private JTable tb;
	// 创建表模型
	private DefaultTableModel tm;
	// 创建分割面板对象
	private JSplitPane slipt;
	// 左边滚动面板
	private JScrollPane spleft;
	// 右边滚动面板
	private JScrollPane spright;
	// 右边面板
	private JPanel pright;

	// 构造方法
	public MainFrame() throws Exception {
		init();
		
		setRightPanel();
		addPanel();
		setVisible(true);
	}

	// 初始化窗口
	public void init() {
		this.setTitle("女神禁区");
		this.setSize(700, 500);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 添加面板
	public void addPanel() {
		// 创建分割面板对象
		slipt = new JSplitPane();
		JLabel lb = new JLabel("左边面板");
		slipt.add(lb, JSplitPane.LEFT);
		// 调用右边面板
		slipt.add(pright, JSplitPane.RIGHT);
		this.add(slipt);
	}

	// 初始化右边面板，使用表格显示女神信息
	public void setRightPanel() throws Exception {
		// 创建面板对象
		pright = new JPanel();
		pright.setLayout(null);
		// 创建添加按钮
		JButton addbtn = new JButton("添加");
		addbtn.setBounds(30, 10, 80, 80);
		// 创建删除按钮
		JButton delbtn = new JButton("删除");
		delbtn.setBounds(120, 10, 80, 80);
		// 创建修改按钮
		JButton updatebtn = new JButton("修改");
		updatebtn.setBounds(210, 10, 80, 80);
		// 创建表格
		String[] title = { "id", "user_name", "sex", "age", "birthday", "email", "mobile", "create_user", "create_date",
				"update_user", "update_date" };
		// 从数据库中获取女神信息
		GoddessDao gd = new GoddessDao();
		List<Goddess> listGoddess = gd.query();
		Object[][] rows = new Object[listGoddess.size()][];
		for (int i = 0; i < rows.length; i++) {
			// 获取集合中的女神对象
			Goddess goddess = listGoddess.get(i);
			// 将对象属性转为数组存储
			Object[] obj = { goddess.getId(), goddess.getUser_name(), goddess.getSex(), goddess.getAge(),
					goddess.getBirthday(), goddess.getEmail(), goddess.getMobile(), goddess.getCreate_user(),
					goddess.getCreate_date(), goddess.getUpdate_user(), goddess.getUpdate_date() };
			rows[i] = obj;
		}
		tm = new DefaultTableModel(rows, title);
		tb = new JTable(tm);

		spright = new JScrollPane(tb);
		spright.setBounds(10, 100, 900, 400);

		// 给修改按钮添加事件
		updatebtn.addActionListener(new MouseAction());
		// 给添加按钮添加事件
		addbtn.addActionListener(new MouseAction());
		// 给删除按钮添加事件
		delbtn.addActionListener(new MouseAction());

		// 将按钮添加到面板
		pright.add(addbtn);
		pright.add(delbtn);
		pright.add(updatebtn);
		pright.add(spright);
	}

	class MouseAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int row = tb.getSelectedRow();
			String text = btn.getText();
			if (text.equals("添加")) {
				// 打开修改窗口
				new UpdateFrame("新增学生信息", tm, tb);
			} else if (text.equals("修改") && row != -1) {
				// 打开修改窗口
//				new UpdateFrame("编辑学生信息", tm, tb);
			} else if (text.equals("删除") && row != -1) {
				// 删除数据

			} else {
//				JOptionPane.showMessageDialog(null, "请选择要编辑/删除的学生！", "操作提示", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	public static void main(String[] args) throws Exception {
		new MainFrame();
	}

}
