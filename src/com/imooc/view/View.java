package com.imooc.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

public class View {

	private static final String CONTEXT="��ӭ����Ů�������\n" +
			"������Ů������Ĺ����б�\n" +
			"[MAIN/M]:���˵�\n" +
			"[QUERY/Q]:�鿴ȫ��Ů�����Ϣ\n" +
			"[GET/G]:�鿴ĳλŮ�����ϸ��Ϣ\n" +
			"[ADD/A]:���Ů����Ϣ\n" +
			"[UPDATE/U]:����Ů����Ϣ\n" +
			"[DELETE/D]:ɾ��Ů����Ϣ\n" +
			"[SEARCH/S]:��ѯŮ����Ϣ(�����������ֻ�������ѯ)\n" +
			"[EXIT/E]:�˳�Ů�����\n" +
			"[BREAK/B]:�˳���ǰ���ܣ��������˵�";

	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";

	public static void main(String[] args) {
		
		System.out.println(CONTEXT);
		//��ô���ֳ���һֱ����
		
		Scanner scan=new Scanner(System.in);
		Goddess goddess=new Goddess();
		GoddessAction action=new GoddessAction();
		String prenious=null;
		Integer step=1;
		while(scan.hasNext()){
			String in=scan.next().toString();
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("���ѳɹ��˳�Ů�������");
				break;
			}else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<Goddess> list=action.query();
					for (Goddess go : list) {
						System.out.println(go.getId()+",������"+go.getUser_name());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(prenious)){
				prenious=OPERATION_ADD;
				//����Ů��
				
				if(1==step){
					System.out.println("������Ů��ģ�������");
				}else if(2==step){
					goddess.setUser_name(in);
					System.out.println("������Ů��ģ������");
				}else if(3==step){
					goddess.setAge(Integer.valueOf(in));
					System.out.println("������Ů��ģ����գݣ���ʽ�磺yyyy-MM-dd");
				}else if(4==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("������Ů��ģ������");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("������ĸ�ʽ��������������");
						step=3;
					}
				}else if(5==step){
					goddess.setEmail(in);
					System.out.println("������Ů��ģ��ֻ��ţ�");
				}else if(6==step){
					goddess.setMobile(in);
					
					try {
						action.add(goddess);
						System.out.println("����Ů��ɹ�");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("����Ů��ʧ��");
					}
				}
				if(OPERATION_ADD.equals(prenious)){
					step++;					
				}
			}else{
				System.out.println("�������ֵΪ:"+in);				
			}
			
		}
	}
}
