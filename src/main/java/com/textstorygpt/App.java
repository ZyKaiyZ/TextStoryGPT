package com.textstorygpt;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
public class App 
{
    public static void main( String[] args )
    {
        OpenAiService service = new OpenAiService("YOUR-OPENAI-KEY"); 

        //Text
        String input="\n";//Prompt string (do not remove \n!)
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(input)//Prompt here
                .model("text-davinci-003")
                .echo(true)
                .maxTokens(1000)
                .build();
        String res = service.createCompletion(completionRequest).getChoices().get(0).getText().toString();
        System.out.println(res.substring(res.indexOf("\n")+2, res.length()));

        //Image
        CreateImageRequest request = CreateImageRequest.builder()
                .prompt(input)//Prompt here
                .build();
        System.out.println("\nImage is located at:");
        System.out.println(service.createImage(request).getData().get(0).getUrl());
    }
}

