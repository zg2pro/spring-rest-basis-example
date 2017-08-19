package zg2pro.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zg2pro.controller.rest.ExampleRestTemplateInheritingFromZg;

class ExampleJson {

    private String messageTest;
    private String name;

    public String getMessageTest() {
        return messageTest;
    }

    public void setMessageTest(String messageTest) {
        this.messageTest = messageTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 *
 * @author zg2pro
 */
@Controller
public class TestController {

    @Inject
    private ExampleRestTemplateInheritingFromZg restTemplate;

    @RequestMapping("/")
    public @ResponseBody
    String index() {
        ExampleJson ej = restTemplate.getForObject(
                "https://raw.githubusercontent.com/zg2pro/spring-rest-basis-example/master/src/test/java/json/mock/example.json",
                ExampleJson.class
        );
        return ej.getMessageTest() + "<br/><br/>" + ej.getName();
    }

}
