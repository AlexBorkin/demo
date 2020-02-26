package demo;

import com.oracle.webservices.internal.api.databinding.Databinding;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer
{

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/results").setViewName("results");


    }


    @GetMapping("/")
    public String showForm(Person person)
    {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "form";
        }
        else
        {
            return "redirect:/results";
        }

    }
}
