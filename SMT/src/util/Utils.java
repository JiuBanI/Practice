package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	public static void main(String[] args) {
		getDateNow();
	}

	public static String randomAccount() {

		String account = "";
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				account += (int) (10 * (Math.random() + 0.1));
				continue;
			}

			account += (int) (10 * (Math.random()));
		}
		return account;
	}

	public static String getDateNow() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");// ���Է�����޸����ڸ�ʽ

		String hehe = dateFormat.format(now);
		// System.out.println(hehe);
		//
		// Calendar c = Calendar.getInstance();// ���Զ�ÿ��ʱ���򵥶��޸�
		//
		// int year = c.get(Calendar.YEAR);
		// int month = c.get(Calendar.MONTH);
		// int date = c.get(Calendar.DATE);
		// int hour = c.get(Calendar.HOUR_OF_DAY);
		// int minute = c.get(Calendar.MINUTE);
		// int second = c.get(Calendar.SECOND);
		// System.out.println(year + "-" + month + "-" + date + "-" + hour + "-"
		// + minute + "-" + second);
		return hehe;
	}

}
