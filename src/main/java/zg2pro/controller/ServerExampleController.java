package zg2pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MosesMeyer
 */
@Controller
public class ServerExampleController {

    @RequestMapping("/homeMadeException")
    public @ResponseBody
    String error() {
        throw new HomeMadeException("some bad thing that would occur in a business layer");
    }

}
