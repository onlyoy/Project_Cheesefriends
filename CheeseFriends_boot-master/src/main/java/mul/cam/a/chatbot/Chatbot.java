package mul.cam.a.chatbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Base64;

public class Chatbot {

	
	public static String stt(String filepath) {
		
		String clientId = "anls63hiqa";             // Application Client ID";
        String clientSecret = "BKfYMfxob5Kag92V3QohiF15SJAxMInZLvT6capM";     // Application Client Secret";

        StringBuffer response = null;
        
        try {
            String imgFile = filepath;
            File voiceFile = new File(imgFile);

            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;            
            
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                
                // 결과출력
                //System.out.println(response.toString());                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
		
        return response.toString();
	}
	
	private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	IOException {
	StringBuilder sb = new StringBuilder();
	sb.append("--").append(boundary).append("\r\n");
	sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
	sb.append(jsonMessage);
	sb.append("\r\n");

	out.write(sb.toString().getBytes("UTF-8"));
	out.flush();

	if (file != null && file.isFile()) {
		out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
		StringBuilder fileString = new StringBuilder();
		fileString
			.append("Content-Disposition:form-data; name=\"file\"; filename=");
		fileString.append("\"" + file.getName() + "\"\r\n");
		fileString.append("Content-Type: application/octet-stream\r\n\r\n");
		out.write(fileString.toString().getBytes("UTF-8"));
		out.flush();

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[8192];
			int count;
			while ((count = fis.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			out.write("\r\n".getBytes());
		}

		out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
	}
	out.flush();
}

public static String chatBot(String voiceMessage) {
	  
	String apiURL = "https://obetlqvk4y.apigw.ntruss.com/custom/v1/9899/ede4e9b096018971eb88a494081e3715985cfaead1502449b66368d2a58480e1";
	String secretKey = "UXhZSUFKeVRlVEppS0hYUlp6TldmUE9sTEZDaE9YYlM=";

    String chatbotMessage = "";

    try {
        //String apiURL = "https://ex9av8bv0e.apigw.ntruss.com/custom_chatbot/prod/";

        URL url = new URL(apiURL);

        String message = getReqMessage(voiceMessage);
        System.out.println("##" + message);

        String encodeBase64String = makeSignature(message, secretKey);

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;UTF-8");
        con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

        // post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(message.getBytes("UTF-8"));
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();

        BufferedReader br;

        if(responseCode==200) { // Normal call
            System.out.println(con.getResponseMessage());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            con.getInputStream()));
            String decodedString;
            while ((decodedString = in.readLine()) != null) {
                chatbotMessage = decodedString;
            }
            //chatbotMessage = decodedString;
            in.close();

        } else {  // Error occurred
            chatbotMessage = con.getResponseMessage();
        }
    } catch (Exception e) {
        System.out.println(e);
    }

    //System.out.println(chatbotMessage);
    
    return chatbotMessage;
}

public static String makeSignature(String message, String secretKey) {

    String encodeBase64String = "";

    try {
        byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

        SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

        return encodeBase64String;

    } catch (Exception e){
        System.out.println(e);
    }

    return encodeBase64String;

}

public static String getReqMessage(String voiceMessage) {

    String requestBody = "";

    try {

        JSONObject obj = new JSONObject();

        long timestamp = new Date().getTime();

        System.out.println("##"+timestamp);

        obj.put("version", "v2");
        obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

        obj.put("timestamp", timestamp);

        JSONObject bubbles_obj = new JSONObject();

        bubbles_obj.put("type", "text");

        JSONObject data_obj = new JSONObject();
        data_obj.put("description", voiceMessage);

        bubbles_obj.put("type", "text");
        bubbles_obj.put("data", data_obj);

        JSONArray bubbles_array = new JSONArray();
        bubbles_array.put(bubbles_obj);

        obj.put("bubbles", bubbles_array);
        obj.put("event", "send");

        requestBody = obj.toString();

    } catch (Exception e){
        System.out.println("## Exception : " + e);
    }

    return requestBody;

}
	    
}
