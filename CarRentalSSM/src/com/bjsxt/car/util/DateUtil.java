package com.bjsxt.car.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * creat by gaoyu 2017��11��16��
 */
public class DateUtil {
	/**
	 * ĳһ���µ�һ������һ��
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, String> getDate(int year, int month) {
		// ��ʽ������
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// ��ȡ���ܵ����
		String dateStr = "" + year + "-" + month + "-" + 1;
		System.out.println("Ԥ��ʱ����" + dateStr);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("ʱ���쳣");
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 0);
		Date theDate = calendar.getTime();
		// ���µ�һ��
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first);
		day_first = str.toString();

		// �������һ��
		calendar.add(Calendar.MONTH, 1); // ��һ����
		calendar.set(Calendar.DATE, 1); // ����Ϊ���µ�һ��
		calendar.add(Calendar.DATE, -1); // �ټ�һ�켴Ϊ�ϸ������һ��
		String day_last = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last);
		day_last = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", day_first);
		map.put("last", day_last);
		return map;
	}

}
