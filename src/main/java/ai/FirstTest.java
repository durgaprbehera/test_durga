package ai;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

import java.util.List;

public class FirstTest {
    public static void main(String[] args) {

        String OPENAI_API_KEY = "PASTE YOUR KEY HERE";
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("OPENAI_API_KEY: " + System.getProperty("OPENAI_API_KEY"));

        // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID`
// environment variables
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(OPENAI_API_KEY)
                .build();

        /* ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4_1_NANO)
                .maxCompletionTokens(10)
                .addDeveloperMessage("Make sure you mention Stainless!")
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();
*/
        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4_1_MINI) // or GPT_4_1_NANO if you want cheapest
                .addUserMessage("Hi! How are you?")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);


      /*  ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Say this is a test")
                .model(ChatModel.GPT_4_1)
                .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params); */


    }
}
