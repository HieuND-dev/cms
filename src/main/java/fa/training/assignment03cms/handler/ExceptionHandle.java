package fa.training.assignment03cms.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;
@ControllerAdvice
public class ExceptionHandle {

        @ExceptionHandler({NoSuchElementException.class, NoResourceFoundException.class})
        public String handleNotFound() {
            return "/exception/404";
        }

//    SpelEvaluationException.class

        @ExceptionHandler({Exception.class})
        public String handleException(Exception e) {
            e.printStackTrace();
            return "/exception/500";
        }


}
