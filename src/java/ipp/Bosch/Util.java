package ipp.Bosch;

public class Util {
	
	public static int getFirst(String result) {
		return Integer.parseInt(result.substring(200, 212).replace(" ",  ""));
	}
	
	public static int getSecond(String result) {
		return Integer.parseInt(result.substring(410, 422).replace(" ",  ""));
	}

	public static int getThird(String result) {
		return Integer.parseInt(result.substring(620, 632).replace(" ",  ""));
	}

}
