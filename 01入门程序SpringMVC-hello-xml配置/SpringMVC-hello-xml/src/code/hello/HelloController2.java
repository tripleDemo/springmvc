package code.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//������
public class HelloController2 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hello...........");
		ModelAndView mv = new ModelAndView();
		//������ͼ����
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		//���ù�������
		mv.addObject("msg","���SpringMVC2");
		return mv;
	}
	
}
