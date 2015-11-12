package liszli.web.controller;

import com.angryelectron.thingspeak.Channel;
import com.angryelectron.thingspeak.Entry;
import com.angryelectron.thingspeak.ThingSpeakException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");

        callThingSpeak();

        return "hello";
    }

    private void callThingSpeak() {
        try {
            Channel channel = new Channel(65040, "HTLUE2Z1G6TMHCMF");
            Entry entry = new Entry();
            entry.setField(1, "22.5");
            entry.setField(2, "28.5");
            channel.update(entry);
        } catch (ThingSpeakException e) {
            System.out.println("Error: " + e);
        } catch (UnirestException e) {
            System.out.println("Error: " + e);
        }
    }


    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", name);
        return model;
    }
}