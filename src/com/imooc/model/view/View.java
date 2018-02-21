package com.imooc.model.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	
	public static void main(String[] args) throws Exception {
		System.out.println(CONTEXT);
		
		Scanner s=new Scanner(System.in);
		GoddessAction action=new GoddessAction();
		
		String pervious=null;
		Integer step=1;
		Goddess go=null;
		
		while(s.hasNext()){
			String in=s.next();
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("���ѳɹ��˳�Ů�����");
				break;
			}else if(OPERATION_MAIN.equals(in.toUpperCase())
					||OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())){
				step=1;
				pervious=null;
				go=null;
				System.out.println(CONTEXT);
			}else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				List<Goddess> list=action.query();
				for (Goddess goddess : list) {
					System.out.println(goddess.toString());
				}
			}else if(OPERATION_GET.equals(in.toUpperCase())
					||OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_GET.equals(pervious)){
				pervious=OPERATION_GET;
				if(1==step){
					System.out.println("�������ѯ��Ů��ID��");
				}else if(step>1){
					Integer id=null;
					Goddess g;
					try {
						id = Integer.valueOf(in);
						try {
							g = action.get(id);
							if(g==null){
								System.out.println("��ѯŮ����Ϣʧ��");
							}else{
								System.out.println(g.toString());
							}
						} catch (Exception e) {
							System.out.println("��ѯŮ����Ϣʧ��");
						}
					} catch (Exception e) {
						System.out.println("��������ȷ��Ů��ID��");
					}
					
				}
				step++;
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(pervious)){
				pervious=OPERATION_ADD;
				if(1==step){
					System.out.println("������Ů�����Ϣ[����]��");
				}else if(2==step){
					go=new Goddess();
					go.setUser_name(in);
					System.out.println("������Ů�����Ϣ[����]��");
				}else if(3==step){
					Integer age=null;
					try {
						age = Integer.valueOf(in);
						go.setAge(age);
						System.out.println("������Ů�����Ϣ[���գ���ʽ:2014-12-12]��");
					} catch (Exception e) {
						step=2;
						System.out.println("��������ȷŮ�����Ϣ[����]��");
					}
				}else if(4==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						birthday = sf.parse(in);
						go.setBirthday(birthday);
						System.out.println("������Ů�����Ϣ[����]��");
					} catch (Exception e) {
						step=3;
						System.out.println("��������ȷŮ�����Ϣ[����]��");
					}
				}else if(5==step){
					go.setEmail(in);
					System.out.println("������Ů�����Ϣ[�ֻ���]��");
				}else if(6==step){
					go.setMobile(in);
					try {
						action.add(go);
					} catch (Exception e) {
						System.out.println("����Ů����Ϣʧ��");
					}
					System.out.println("����Ů����Ϣ�ɹ�");
					step=1;
					pervious=null;
				}
				if(OPERATION_ADD.equals(pervious)){
					step++;
				}
			}else if(OPERATION_UPDATE.equals(in.toUpperCase())
					||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(pervious)){
				pervious=OPERATION_UPDATE;
				if(1==step){
					System.out.println("������Ҫ�޸ĵ�Ů��ID��");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							go = action.get(id);
							if(go==null){
								System.out.println("��ѯŮ����Ϣʧ��");
								step=1;
							}
						} catch (Exception e) {
							System.out.println("��ѯŮ����Ϣʧ��");
							step=1;
						}
					} catch (Exception e) {
						System.out.println("��������ȷ��Ů��ID��");
						step=1;
					}
					System.out.println("�������µ�Ů����Ϣ[����]��������޸ĸ�ֵ��������-1��");
				}else if(3==step){
					if(-1!=Integer.valueOf(in)){
						go.setUser_name(in);
					}
					System.out.println("�������µ�Ů����Ϣ[����]��������޸ĸ�ֵ��������-1��");
				}else if(4==step){
					Integer age=null;
					try {
						age = Integer.valueOf(in);
						if(-1!=age){
							go.setAge(age);
						}
						System.out.println("�������µ�Ů����Ϣ[���գ���ʽ:2014-12-12]��������޸ĸ�ֵ��������-1��");
					} catch (Exception e) {
						step=3;
						System.out.println("��������ȷŮ�����Ϣ[����]��");
					}
				}else if(5==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						if(-1!=Integer.valueOf(in)){
							birthday = sf.parse(in);
							go.setBirthday(birthday);
						}
						System.out.println("�������µ�Ů����Ϣ[����]��������޸ĸ�ֵ��������-1��");
					} catch (Exception e) {
						step=4;
						System.out.println("��������ȷŮ�����Ϣ[����]��");
					}
				}else if(6==step){
					if(-1!=Integer.valueOf(in)){
						go.setEmail(in);
					}
					System.out.println("�������µ�Ů����Ϣ[�ֻ���]��������޸ĸ�ֵ��������-1��");
				}else if(7==step){
					if(-1!=Integer.valueOf(in)){
						go.setMobile(in);
					}
					try {
						action.edit(go);
					} catch (Exception e) {
						System.out.println("����Ů����Ϣʧ��");
					}
					System.out.println("����Ů����Ϣ�ɹ�");
					step=1;
					pervious=null;
				}
				if(OPERATION_UPDATE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_DELETE.equals(in.toUpperCase())
					||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_DELETE.equals(pervious)){
				pervious=OPERATION_DELETE;
				if(1==step){
					System.out.println("������Ҫɾ����Ů��ID��");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							action.del(id);
							step=1;
							System.out.println("ɾ��Ů����Ϣ�ɹ�");
						} catch (Exception e) {
							System.out.println("ɾ��Ů����Ϣʧ��");
						}
					} catch (Exception e) {
						System.out.println("��������ȷ��Ů��ID��");
						step=1;
					}
				}
				if(OPERATION_DELETE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_SEARCH.equals(in.toUpperCase())
					||OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_SEARCH.equals(pervious)){
				pervious=OPERATION_SEARCH;
				if(1==step){
					System.out.println("������Ҫ��ѯ��Ů����Ϣ��֧���������ֻ��Ų�ѯ����������������������ö��ŷָ�[user_name=xx,mobile=xx]��");
				}else if(2==step){
					if(in!=null&&in!=""){
						List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
						Map<String, Object> param=null;
						String[] strs=in.split(",");
						for (int i = 0; i < strs.length; i++) {
							String[] strs_s=strs[i].split("=");
							param=new HashMap<String, Object>();
							param.put("name", strs_s[0]);
							param.put("rela", "=");
							param.put("value", "'"+strs_s[1]+"'");
							params.add(param);
						}
						List<Goddess> list=action.query(params);
						if(list!=null&&list.size()>0){
							for (Goddess goddess : list) {
								System.out.println(goddess.toString());
							}
						}else{
							System.out.println("û�в�ѯ��Ů����Ϣ������");
						}
						step=1;
					}
				}
				if(OPERATION_SEARCH.equals(pervious)){
					step++;
				}
			}else if(OPERATION_BREAK.equals(in.toUpperCase())
					||OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())){
				System.out.println(CONTEXT);
				continue;
			}
			
		}
	}
}
