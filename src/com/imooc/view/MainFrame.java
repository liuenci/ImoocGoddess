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

	// �����
	private JPanel pmain;
	// ������
	private JTable tb;
	// ������ģ��
	private DefaultTableModel tm;
	// �����ָ�������
	private JSplitPane slipt;
	// ��߹������
	private JScrollPane spleft;
	// �ұ߹������
	private JScrollPane spright;
	// �ұ����
	private JPanel pright;

	// ���췽��
	public MainFrame() throws Exception {
		init();
		
		setRightPanel();
		addPanel();
		setVisible(true);
	}

	// ��ʼ������
	public void init() {
		this.setTitle("Ů�����");
		this.setSize(700, 500);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ������
	public void addPanel() {
		// �����ָ�������
		slipt = new JSplitPane();
		JLabel lb = new JLabel("������");
		slipt.add(lb, JSplitPane.LEFT);
		// �����ұ����
		slipt.add(pright, JSplitPane.RIGHT);
		this.add(slipt);
	}

	// ��ʼ���ұ���壬ʹ�ñ����ʾŮ����Ϣ
	public void setRightPanel() throws Exception {
		// ����������
		pright = new JPanel();
		pright.setLayout(null);
		// ������Ӱ�ť
		JButton addbtn = new JButton("���");
		addbtn.setBounds(30, 10, 80, 80);
		// ����ɾ����ť
		JButton delbtn = new JButton("ɾ��");
		delbtn.setBounds(120, 10, 80, 80);
		// �����޸İ�ť
		JButton updatebtn = new JButton("�޸�");
		updatebtn.setBounds(210, 10, 80, 80);
		// �������
		String[] title = { "id", "user_name", "sex", "age", "birthday", "email", "mobile", "create_user", "create_date",
				"update_user", "update_date" };
		// �����ݿ��л�ȡŮ����Ϣ
		GoddessDao gd = new GoddessDao();
		List<Goddess> listGoddess = gd.query();
		Object[][] rows = new Object[listGoddess.size()][];
		for (int i = 0; i < rows.length; i++) {
			// ��ȡ�����е�Ů�����
			Goddess goddess = listGoddess.get(i);
			// ����������תΪ����洢
			Object[] obj = { goddess.getId(), goddess.getUser_name(), goddess.getSex(), goddess.getAge(),
					goddess.getBirthday(), goddess.getEmail(), goddess.getMobile(), goddess.getCreate_user(),
					goddess.getCreate_date(), goddess.getUpdate_user(), goddess.getUpdate_date() };
			rows[i] = obj;
		}
		tm = new DefaultTableModel(rows, title);
		tb = new JTable(tm);

		spright = new JScrollPane(tb);
		spright.setBounds(10, 100, 900, 400);

		// ���޸İ�ť����¼�
		updatebtn.addActionListener(new MouseAction());
		// ����Ӱ�ť����¼�
		addbtn.addActionListener(new MouseAction());
		// ��ɾ����ť����¼�
		delbtn.addActionListener(new MouseAction());

		// ����ť��ӵ����
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
			if (text.equals("���")) {
				// ���޸Ĵ���
				new UpdateFrame("����ѧ����Ϣ", tm, tb);
			} else if (text.equals("�޸�") && row != -1) {
				// ���޸Ĵ���
//				new UpdateFrame("�༭ѧ����Ϣ", tm, tb);
			} else if (text.equals("ɾ��") && row != -1) {
				// ɾ������

			} else {
//				JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�༭/ɾ����ѧ����", "������ʾ", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	public static void main(String[] args) throws Exception {
		new MainFrame();
	}

}
