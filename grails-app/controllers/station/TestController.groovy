package station

import station.utils.UtilService;
import util.UrlCall;
import ipp.Bosch.HttpRequest;
import ipp.Bosch.Util;
import java.util.concurrent.TimeUnit;

class TestController {
	
	public volatile boolean running = true;

    def index() { 
		UtilService utilService = new UtilService();
		print "zaa"
//		utilService.urlCall("http://localhost:8080/StationIOT/test/index")
		UrlCall.sendGet("http://localhost:8080/StationIOT/test/test")
		String str;
		render "zz"
	}
	
	def test() {
		print "mmm"
		
		while(running) {
			String result  = HttpRequest.connectTo("100.103.1.205", "/rcp.xml?command=0x0b4a&type=P_OCTET&direction=READ&num=1");
			int entering = Util.getSecond(result);
			int exit = Util.getFirst(result);
//			int third = Util.getThird(result);	
			System.out.println("Input: " + entering + " exit: " + exit);	
			int intensity = calculateLightState(entering, exit);		
			UrlCall.updateLightWithIntensity(intensity);
			TimeUnit.SECONDS.sleep(1);
		}
		
		System.out.println("numbers: " + entering +"||" +  exit +"||" +  third +"||");
		render "End success"
	}
	
	int getPassengerNumber(int entering, int exit) {
		return entering - exit;
	}
	
	int calculateLightState(int entering, exit) {
		int maxPassengers = 2;
		int passengerNumber = getPassengerNumber(entering, exit);
		System.out.println("Number of passengers: " + passengerNumber + "/ 3 total");
		if (passengerNumber >= 2) {
			return 0;
		} else if (passengerNumber >= 1) {
			return 10;
		} else {
			return 100;
		}
	}
//	def restart() {
//		running = false		
//		TimeUnit.SECONDS.sleep(3);
//		
//	}
}
