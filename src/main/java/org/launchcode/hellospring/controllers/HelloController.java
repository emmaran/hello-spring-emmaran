package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

//    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    // /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
//                "<input type = 'text' name = 'name' >" +
//                "<input type = 'submit' value = 'Greet Me!' >" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        return "Hello, " + name + "!";
        if (name == null) {
            name = "World";
        }

        return "<html>" +
                "<h1>" +
                createMessage(name, language) +
                "</h1>" +
                "</html>";

    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("french")) {
            greeting = "Bonjour";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        } else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }

        return greeting + ", " + n + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" +
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language' >" +
                "<option value = 'english' >English</option>" +
                "<option value = 'spanish' >Spanish</option>" +
                "<option value = 'french' >French</option>" +
                "<option value = 'german' >German</option>" +
                "<option value = 'italian' >Italian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}