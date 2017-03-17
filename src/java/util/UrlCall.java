package util;
import ipp.Bosch.SSLUtilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.net.ssl.SSLSession;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UrlCall {

	private static String sendGet(String url) throws Exception {

//		String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
//		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();
	}
	
	private static String updateLightWithIntensity(int intensity) throws Exception {

		String url = "https://www.bosch-connectedbuilding.com/rest/api/v1/control/zumtobel-lms/37a19429-1d5e-4fbc-b82e-8694bce043c8/Device/bebca2a8-db43-43b2-be18-db437bfaadd5/LightingCapability/intensity/" + intensity;
//		String url = "https://www.bosch-connectedbuilding.com/rest/api/v1/control/zumtobel-lms/37a19429-1d5e-4fbc-b82e-8694bce043c8/Device/3d1884ea-f822-47fb-bbc0-9c4316ef2c25/LightingCapability/intensity/" + intensity;
		
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//		((HttpsURLConnection)con).setHostnameVerifier(new HostnameVerifier() {
//            public boolean verify(String host, SSLSession sess) {
//                return true;
//            }
//        });
//		someTest();

		testAnother(3);
		// optional default is GET
		con.setRequestMethod("PUT");

		//add request header
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Content-type", "application/json");
		con.setRequestProperty("Authorization", "Basic QkNYVEVOQU5UMDhcb2xpc2NoOkJDWDE3IVVTRVI=");
		con.setRequestProperty("SESSION", "9a9f740f-cc65-4787-852a-0ec8ed05a108;path=/;Secure;HttpOnly");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();
	}
	
	public static void someTest() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
		    new X509TrustManager() {
		        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		            return null;
		        }
		        public void checkClientTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		        public void checkServerTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		    }
		};

		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		}
	}
	
	public static void testAnother(int intensity) {
	
	}
}


