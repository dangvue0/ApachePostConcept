import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;


public class SendRRC {
    public static void main(String[] args) throws Exception {

        String num = "10";
        String projname = "NEW Project";
        String projdesc = "Code Stuff";


        JSONObject jo = new JSONObject();
        jo.put("project_id", num);
        jo.put("project_name", projname);
        jo.put("project_description", projdesc);

        String payload = jo.toString();

//        String payload = """
//                {
//                    "project_id": 7,
//                    "project_name": "ProjectNEW",
//                    "project_description": "Code Stuff"
//                }
//                """;
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/v1/projects/new");
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}


