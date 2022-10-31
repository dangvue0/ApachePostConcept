import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SendPostJson {
    public static void main(String[] args) throws Exception {

        // Sending get request
        URL url = new URL("http://localhost:8080");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+"eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiZGFuZyIsImV4cCI6MTY2NzI0MzQ0MywiaWF0IjoxNjY3MTU3MDQzfQ.ddKf8EXRvPm9iHFBIExeHa0fkEJHWe3YVk1NO1NpTn-Y2Aqonfe2cjle13G9M4GlmY91DkcNqBivtT1mzUO65a6Qn7baGGiA5pvG-Kte4b2EWyi6oMOrpinOjEVs3HTImf2ongsxS_Es6QJ9FpNlUvBjS9voNKRSENWDoDdXsNfD5uITiifbjOazAAp8j4pkkBi4w5NWFWBmET20hXbVJW9Lpzx01_CwbHDmhS6CCkbb6pJRJBUOTGTY43O8cyWCEeDuHqPq8hIBFOp7vXM9mWv_Biaktxn7-ftSveT_FmOSTRKSVUH_eqMXZ_C6B1kx1MB2z3JHROeyOhIAUdfexA");
        //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T

        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        in.close();
        // printing result from response
        System.out.println("Response:-" + response.toString());



    }

    


    public void Post () throws Exception {

//        String num = "2323";

//        String projname = "NEW Project123123";
//        String projdesc = "Code Stuff";
//
//
//        JSONObject jo = new JSONObject();
//        jo.put("project_id", num);
//        jo.put("project_name", projname);
//        jo.put("project_description", projdesc);
//
//        String payload = jo.toString();

        String payload = """
                {
                    "project_id": 2000,
                    "project_name": "ProjectNEW12",
                    "project_description": "Code Stuff"
                }
                {
                    "project_id": 11,
                    "project_name": "ProjectNEW11",
                    "project_description": "Code Stuff"
                }
                """;
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/v1/projects/new");
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
    }

}

