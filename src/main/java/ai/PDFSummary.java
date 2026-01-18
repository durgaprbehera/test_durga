package ai;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PDFSummary {
    public static String OPENAI_API_KEY = "PASTE YOUR KEY";

    public static void main(String[] args) {
        try {
            String requestBody = """
                        {
                        "model": "gpt-5",
                        "input": [
                            {
                                "role": "user",
                                "content": [
                                    {
                                        "type": "input_text",
                                        "text": "Analyze the file and provide a summary of the key points."
                                    },
                                    {
                                        "type": "input_file",
                                        "file_url": "https://themodernfirm.com/wp-content/uploads/2017/12/Sample-Fillable-PDF.pdf"
                                    }
                                ]
                            }
                        ]
                    }""";

            // 3. Create HTTP request
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openai.com/v1/responses"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + OPENAI_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

            // 4. Send request
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 5. Print response
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:");
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
