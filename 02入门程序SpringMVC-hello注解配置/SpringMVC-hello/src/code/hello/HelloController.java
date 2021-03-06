package code.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//处理器
@Controller
public class HelloController {
	@RequestMapping("hello")
	public ModelAndView sayHello() {
		System.out.println("saying.........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		mv.addObject("msg", "使用注解方式开发SpringMVC");
		return mv;
	}
	
	@RequestMapping("hello2")
	public ModelAndView sayHello2() {
		System.out.println("saying.........2");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		mv.addObject("msg", "使用注解方式开发SpringMVC2");
		return mv;
	}
}
