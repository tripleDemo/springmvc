package code.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//������
@Controller
public class HelloController {
	@RequestMapping("hello")
	public ModelAndView sayHello() {
		System.out.println("saying.........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		mv.addObject("msg", "ʹ��ע�ⷽʽ����SpringMVC");
		return mv;
	}
	
	@RequestMapping("hello2")
	public ModelAndView sayHello2() {
		System.out.println("saying.........2");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		mv.addObject("msg", "ʹ��ע�ⷽʽ����SpringMVC2");
		return mv;
	}
}
