import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class PostJSON2 {
    public static void main(String args[]) throws IOException, InterruptedException {
        Base64.Encoder encoder = Base64.getEncoder();
        String query_url = "https://bfhldevapigw.healthrx.co.in/bfl-api-challenge/challenge-final";
        JSONObject obj = new JSONObject();
        String name="Ishan Gupta";
        String email="ishan.19bce7467@vitap.ac.in";
        String Regno="19BCE7467";

        obj.put("b_email", encoder.encodeToString(email.getBytes()));
        obj.put("b_name", encoder.encodeToString(name.getBytes()));
        obj.put("b_reg_no", encoder.encodeToString(Regno.getBytes()));
        obj.put("email", email);
        obj.put("name", name);
        obj.put("personal_code","GRAPHQL");
        obj.put("reg_no", Regno);


        var request = HttpRequest.newBuilder()
                .uri(URI.create(query_url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(obj.toJSONString()))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
