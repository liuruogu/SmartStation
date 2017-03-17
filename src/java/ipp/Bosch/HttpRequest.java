package ipp.Bosch; /**
 * Created by liu on 15/03/2017.
 */
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;


public class HttpRequest {

    private static String connectTo(String ip, String rcpCommand) {

        Document doc = null;

        String getCommand = "http://" + ip + rcpCommand;

        try {
            doc = Jsoup.connect(getCommand).get();

        } catch (IOException e1) {
            System.out.println("Cannot connect to camera with ip address '" + ip + "'");
            return "";
        }

        return  RCPPayloadDecoder.decodeMessage(doc);

    }

    public static void main(String[] args) throws Exception {

        String CamCount  = connectTo("100.103.1.203", "/rcp.xml?command=0x0b4a&type=P_OCTET&direction=READ&num=1");
        String numOfpeople = CamCount.substring(60, 74);
        System.out.println(numOfpeople);

    }
}
