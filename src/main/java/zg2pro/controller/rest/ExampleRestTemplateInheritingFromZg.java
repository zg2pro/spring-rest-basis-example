package zg2pro.controller.rest;

import com.github.zg2pro.spring.rest.basis.template.Zg2proRestTemplate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

/**
 *
 * @author zg2pro
 */
@Service
public class ExampleRestTemplateInheritingFromZg extends Zg2proRestTemplate {

    public ExampleRestTemplateInheritingFromZg() {
        super();
        //json reply should be application/json but we get a text/plain
        for (HttpMessageConverter<?> hmc : this.getMessageConverters()) {
            if (hmc.getClass().isAssignableFrom(MappingJackson2HttpMessageConverter.class)) {
                MappingJackson2HttpMessageConverter mjhc = (MappingJackson2HttpMessageConverter) hmc;
                List<MediaType> lmt = new ArrayList<>(mjhc.getSupportedMediaTypes());
                lmt.add(MediaType.TEXT_PLAIN);
                mjhc.setSupportedMediaTypes(lmt);
            }
        }
    }

}
