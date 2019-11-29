package wangzheng;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * IP 数字转换
 *
 * 额外知识前提: ip实际是32位bit数据
 *
 * @author: Xiang Mingzhe
 * @version IpLongConverter.java, v 0.1 2019/11/22 11:36 XiangMingZhe Exp $
 **/
public class IpLongConverter {

	/**
	 * IP字符串转为Long
	 *
	 * 将IP字符串4段 还原为bit位的数字
	 * @param ipStr
	 * @return
	 */
	private static Long ip2Long(String ipStr) {
		// 以特殊符号 '.','|'等为分隔符 切割需转义
		String[] ip = ipStr.split("\\.");

		Long first = Long.valueOf(ip[0]) << 24;
		Long second = Long.valueOf(ip[1]) << 16;
		Long third = Long.valueOf(ip[2]) << 8;
		Long fourth = Long.valueOf(ip[3]);

		return first + second + third + fourth;
	}

	/**
	 *
	 * @param ipLong
	 * @return
	 */
	private static String long2Ip(long ipLong) {
		// 解析第2段ip ipLong & 0x00FFFFFF目的为排除第1段ip
		return String.valueOf(ipLong >>> 24) + "."
			+ ((ipLong & 0x00FFFFFF) >>> 16) + "."
			+ ((ipLong & 0x0000FFFF) >>> 8) + "."
			+ (ipLong & 0x000000FF);
	}

	public static void main(String[] args) throws UnknownHostException {
		InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");

		String address;
		for (InetAddress inetAddress : addresses) {
			address = inetAddress.getHostAddress();
			System.out.println(String.format("===========解析[%s]===========", address));
			long ipLong= ip2Long(address);
			System.out.println("ip to long:" + ipLong);
			System.out.println("long to ip:" + long2Ip(ipLong));

		}
	}
}
