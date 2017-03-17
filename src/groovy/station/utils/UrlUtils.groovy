package station.utils;

//import java.io.FileNotFoundException;
//import java.io.OutputStream;
//import java.io.StringWriter;
//import java.net.ConnectException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;
//
//import org.apache.commons.io.IOUtils;

public class UtilService {
//
//	public static final String CONTENT_LENGTH = "Content-Length";
//	public static final String HEADER_VALUE_APP_JSON = "application/json";
//	public static final String HEADER_CONTENT_TYPE = "Content-Type";
//	public static final String REQUEST_METHOD_POST = "POST";
//
//	
//	public Response urlCall(String targetString) {
//		String responseBody;
//		ResponseBuilder httpResponseBuilder;
//		Integer statusCode;
//		HttpURLConnection conn = null;
//		try {
//			URL targetURL = new URL(targetString);
//			conn = (HttpURLConnection) targetURL.openConnection();
//			conn.setReadTimeout(60000);
//			conn.connect();
//			statusCode = conn.getResponseCode();
//			// if response is with error code
//
//			StringWriter writer = new StringWriter();
//			if (statusCode >= 400) {
//				IOUtils.copy(conn.getErrorStream(), writer, StandardCharsets.UTF_8.name());
//			} else {
//				IOUtils.copy(conn.getInputStream(), writer, StandardCharsets.UTF_8.name());
//			}
//			responseBody = writer.toString();
//
//			httpResponseBuilder = Response.status(statusCode).entity(responseBody);
////			for (String r : conn.getHeaderFields().keySet()) {
////				if (StringUtils.isNotEqual(r, CONTENT_LENGTH)) {
////					httpResponseBuilder.header(r, conn.getHeaderFields().get(r).get(0));
////				}
////			}
//
//		} catch (Exception exception) {
//			throw new RuntimeException(	"Problems on connection with target server!");
//		} finally {
//			if (conn != null) {
//				conn.disconnect();
//			}
//		}
//		return httpResponseBuilder.build();
//	}
//
//	public Response postRequestWithJSONContent(String url, String jsonContent) {
//		String responseBody;
//		ResponseBuilder httpResponseBuilder;
//		Integer statusCode;
//		HttpURLConnection conn = null;
//		try {
//			URL targetURL = new URL(url);
//			conn = (HttpURLConnection) targetURL.openConnection();
//			conn.setDoOutput(true);
//			conn.setRequestMethod(REQUEST_METHOD_POST);
//			conn.setRequestProperty(HEADER_CONTENT_TYPE, HEADER_VALUE_APP_JSON);
//
//			OutputStream os = conn.getOutputStream();
//			os.write(jsonContent.getBytes());
//			os.flush();
//
//			statusCode = conn.getResponseCode();
//			StringWriter writer = new StringWriter();
//			if (statusCode >= 400) {
//				IOUtils.copy(conn.getErrorStream(), writer, StandardCharsets.UTF_8.name());
//			} else {
//				IOUtils.copy(conn.getInputStream(), writer, StandardCharsets.UTF_8.name());
//			}
//			responseBody = writer.toString();
//			httpResponseBuilder = Response.status(statusCode).entity(responseBody);
//		} catch (Exception exception) {
//		} finally {
//			if (conn != null) {
//				conn.disconnect();
//			}
//		}
//		return httpResponseBuilder.build();
//	}

}
