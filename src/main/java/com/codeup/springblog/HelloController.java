package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

    @Controller
    class HelloController {

        @GetMapping("/hello")
        @ResponseBody
        public String hello() {
            return "Hello from Spring!";
        }

        @GetMapping("/goodbye")
        @ResponseBody
        public String goodbye(){
            return "Goodbye from Spring!";
        }

//        @GetMapping("")
//
//        @GetMapping("/books/{id}")
//        @ResponseBody
//        public String getBook(@PathVariable  long id){
//            return "Viewing book " + if
//        }


    }

