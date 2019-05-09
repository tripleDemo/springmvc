package code.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//����������������Ϣ
@Controller
@RequestMapping("/other")
@SessionAttributes("errorMsg")
public class OtherController {
	@RequestMapping("/test1")
	public ModelAndView test1(@RequestHeader("User-Agent") String userAgent,@CookieValue("JSESSIONID") String cName) {
		System.out.println("test1.............");
		System.out.println("userAgent="+userAgent);
		System.out.println("cName="+cName);
		return null;
	}
	
	@RequestMapping("/test2")
	public String test2(Model model) {
		System.out.println("test2.............");
		model.addAttribute("errorMsg","������Ϣ");
		return "redirect:/abc.jsp";
	}
}
