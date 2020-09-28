package app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundExceptions(EntityNotFoundException exc) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message", exc.getMessage());
        modelAndView.setViewName("errors/error");

        return modelAndView;
    }

    @ExceptionHandler(NoResultException.class)
    public ModelAndView handleNoResultExceptions(NoResultException exc) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message", exc.getMessage());
        modelAndView.setViewName("errors/error");

        return modelAndView;
    }
}
