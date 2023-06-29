package com.bjsxt.car.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bjsxt.car.pojo.Renttable;

/**
 * ������
 * 
 * */
public class MyUtil {
	
	public static final String RF ="\r\n";
	/**
	 * ��õ�ǰʱ��
	 * @return
	 */
	public static String getCurrentDate(){
		Date date1 = new Date();
		String date2 = formatDate(date1);
		return date2;
	}
	/**
	 * ��ʽ��ʱ�䣬����������ת��ΪString����
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String cd = df.format(date);
		
		return cd;
	}
	/**
	 * ����һ��18Ϊ�������
	 * @param args
	 */
	public static Long getRandomId(){
		Long random = (long) (Math.random()*1000000000000000000L);
		return random;
	}
	/**
	 * 
	 * ��̬��������
	 * @return
	 */
	public static String getSires(List<Renttable> list){
		StringBuilder sb = new StringBuilder();
		/**
		 * {
			        minPointSize: 10,
			        innerSize: '20%',
			        zMin: 0,
			        name: 'countries',
		 */
		sb.append(" [{");
		sb.append("minPointSize: 10,"+RF);
		sb.append("innerSize: '20%',"+RF);
		sb.append("zMin: 0,"+RF);
		sb.append("name: 'countries',"+RF);
		sb.append("data: [");
		
		for (Renttable renttable : list) {
			sb.append("{name: '");
			String carNum = renttable.getCars().getCarNumber();
			sb.append(carNum);
			sb.append("', y: ");
			sb.append(renttable.getCarrentcount());
			sb.append(", z: ");
			sb.append(renttable.getCountPrice());
			sb.append("},");
			
		}
		sb.append("]");
		//String a = "data: [{name: '"+renttable.getCars().getCarNumber()+"', y: "+renttable.getCarrentcount()+", z: "+renttable.getCountPrice()+"}]";
		String sire = sb.toString();
		String s = sire.substring(0, sire.lastIndexOf(","));
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s);
		sb1.append("]");
		sb1.append("}]");
		return sb1.toString();	           
	}
	
	
	public static void main(String[] args) {
		
	}
}
