package hello;

import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class LombokLoggingController {
    
    @RequestMapping("/lombok")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("A INFO Message");
        log.warn("A WARN Message");
        log.error("A ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

}

