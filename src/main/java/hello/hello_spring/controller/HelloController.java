package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 정적 컨텐츠
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello!!");
        return "hello"; // hello.html 템플릿을 반환
    }

    // MVC와 템플릿 엔진 / 모델과 뷰로 템플릿을 쪼개보자
    @GetMapping("/hello-mvc")
    public String helloMvs(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // HTTP 응답의 body에 문자 대신 직접 데이터를 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // 일반적으로 객체를 반환하는 방식은 api. json 형태로 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
