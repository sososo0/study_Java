import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTTPHeaderViewer {
   public static Map<String,String> getHeaders(String a){

       try{
           URL url = new URL(a);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("HEAD");

           String [] headerKeys = new String[11];
           String [] headerFields = new String[11];

           String headerKey;
           String headerField;
           Map<String,String> stringMap = new HashMap<>();

           for(int i=0;i<11;i++){
               headerKeys[i] = conn.getHeaderFieldKey(i);
               headerFields[i] = conn.getHeaderField(i);

               if("Content-Type".equals(headerKeys[i])){
                   headerKey = headerKeys[i];
                   headerField= headerFields[i];
                   stringMap.put(headerKey,headerField);
                   break;
               }
           }
           return stringMap;
       }catch (IOException e){
           Map<String,String> stringMap = new HashMap<>();
           stringMap.put(e.getLocalizedMessage(),e.getMessage());
           return stringMap;
       }
   }
}
