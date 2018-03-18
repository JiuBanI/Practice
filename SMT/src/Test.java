import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

import util.Utils;

public class Test {
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 InetAddress ia = null;
		 try {
		 ia = ia.getLocalHost();
		
		 String localname = ia.getHostName();
		 String localip = ia.getHostAddress();
		 System.out.println("本机名称是：" + localname);
		 System.out.println("本机的ip是 ：" + localip);
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

//		int a[] = new int[10];
//		for (int i = 0; i < a.length; i++) {
//			if (i == 0) {
//				a[i] = (int) (10 * (Math.random() + 0.1));
//				System.out.print(a[i]);
//				continue;
//			}
//
//			a[i] = (int) (10 * (Math.random()));
//			System.out.print(a[i]);
//		}
		
//		System.out.println(Utils.randomAccount());
	}
}
