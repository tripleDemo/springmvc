package code.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.vo.User;

@Controller
@RequestMapping("/request")
public class HandleModelAttributeController {
	/*ModelAttribute注解：
	 * 1.给共享的model数据设置key名，贴在形参上，也可以贴在方法上
	 * 		针对符合类型参数，缺省情况下就会放到model中共享，缺省的key就是类型首字母小写
	 * 		也可以在参数上贴ModelAttribute，设置一个model的key名*/
	@RequestMapping("/test11")
	public String test11(@ModelAttribute("myUser") User u) {
		System.out.println(u);
		return "welcome";
	}
	
	//当Controller方法返回一个对象的时候，缺省会把当前请求的URL作为逻辑视图名称，并共享当前返回对象
	//一般的返回一个JavaBean对象的时候，一般用于JSON操作，必须依赖JSON库(jackson)
	@RequestMapping("/test12")
	//@ResponseBody
	public User test12(User u) {
		System.out.println(u);
		return u;
	}
	
	/* 2.可以标注一个非请求处理的方法，被标注的方法每次在请求处理方法之前都会优先被执行
	 * (存放多个请求需要共享的数据)(一般很少用)*/
	@ModelAttribute
	public void abc(Model model) {
		System.out.println("abc........");
		//model.addAttribute.......
	}
}
