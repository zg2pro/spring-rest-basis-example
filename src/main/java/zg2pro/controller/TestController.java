package zg2pro.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zg2pro.controller.rest.ExampleRestTemplateInheritingFromZg;

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
        return restTemplate.getForObject("http://www.google.fr", String.class);
    }

}
