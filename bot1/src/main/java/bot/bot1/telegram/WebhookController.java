package bot.bot1.telegram;

import bot.bot1.telegram.objects.Update;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;

@RestController
public class WebhookController {

    @RequestMapping("/mybot")
    public BotApiType getUpdate(){
        System.out.println("update");
        return null;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct start");
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        FileSystemResource value = new FileSystemResource(new File("./public_cert.pem"));
        map.add("certificate", value);
        map.add("url","https://93.170.123.172:443/mybot");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("https://api.telegram.org/bot376651530:AAH-aBiEkS_tezghZxNLTEi1ypnuXdbl-5M/setWebhook", HttpMethod.POST, requestEntity, String.class);
        System.out.println("setwebhook");
    }
}
