package top.seacolo.util;

import java.util.Date;

/**
 * 生成唯一字符的工具类，可以生成唯一ID通过UUID+时间的long组合而成从而获得唯一数值
 */
public class RandomIdUtil {
	
	/**
	 * 随机数a-z，A-Z，0-9的数组
	 */
	private static String[] randomBuffer = new String[]{"a","b","c","d","e","f",
			"g","h","i","j","k","l","m","n","o","p","q","r",
			"s","t","u","v","w","x","y","z","A","B","C","D",
			"E","F","G","H","I","J","K","L","M","N","O","P",
			"Q","R","S","T","U","V","W","X","Y","Z","1","2",
			"3","4","5","6","7","8","9","0"};
	/**
	 * 构造方法私有化，不能初始化对象
	 */
	private RandomIdUtil(){
		
	}
	
	/**
	 * 得到唯一ID值的方法,获取到时间的long的值，再加上math随机函数中获取随机位置的数，一直添加到二十位为止。
	 * @return
	 */
	public static String getID(){
		StringBuffer sb = new StringBuffer(new Date().getTime()+"");
		while(sb.length()<20){
			sb.append(randomBuffer[(int)(Math.random()*randomBuffer.length)]);
		}
		return sb.toString();
	}
}
