package nl.robbystoned.soundtouch;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class SoundTouchController {
    public static void main(String[] argv) {
        powerDown();
    	//playPreset3FM();

    }

	private static void playPreset3FM() {
		try {
            String XMLData = "<ContentItem source=\"INTERNET_RADIO\" location=\"38199\" sourceAccount=\"\" isPresetable=\"true\"><itemName>NPO 3FM</itemName></ContentItem>";
            URL url = new URL("http://192.168.177.22:8090/select");
            HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
            httpConn.setRequestProperty("Content-Length", Integer.toString(XMLData.length()));
            httpConn.setDoOutput(true);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter((httpConn.getOutputStream())));
            writer.write(XMLData, 0, XMLData.length());
            writer.flush();
            writer.close();

            System.out.println(httpConn.getResponseCode());
            System.out.println(httpConn.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private static void powerDown() {
		try {
            String XMLData = "<key state=\"press\" sender=\"Gabbo\">POWER</key>";
            URL url = new URL("http://192.168.177.22:8090/key");
            HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
            httpConn.setRequestProperty("Content-Length", Integer.toString(XMLData.length()));
            httpConn.setDoOutput(true);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter((httpConn.getOutputStream())));
            writer.write(XMLData, 0, XMLData.length());
            writer.flush();
            writer.close();

            System.out.println(httpConn.getResponseCode());
            System.out.println(httpConn.getResponseMessage());
            
            XMLData = "<key state=\"release\" sender=\"Gabbo\">POWER</key>";
             url = new URL("http://192.168.177.22:8090/key");
             httpConn = (HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
            httpConn.setRequestProperty("Content-Length", Integer.toString(XMLData.length()));
            httpConn.setDoOutput(true);

             writer = new BufferedWriter(new OutputStreamWriter((httpConn.getOutputStream())));
            writer.write(XMLData, 0, XMLData.length());
            writer.flush();
            writer.close();

            System.out.println(httpConn.getResponseCode());
            System.out.println(httpConn.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}