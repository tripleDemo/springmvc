package code.response;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//处理器
@Controller
@RequestMapping("/response")
public class HandleResponseController {
	//1.处理器的响应处理

	//返回void:文件下载
	@RequestMapping("/test1")
	public void test1(OutputStream out) throws IOException {
		Files.copy(Paths.get("D:/1.jpg"), out);
	}

	//返回ModelAndView
	@RequestMapping("/test2")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "返回ModelAndView");
		mv.addObject("把value类型的首字母作为key:string");
		mv.setViewName("welcome");
		return mv;
	}

	//返回String，逻辑视图名称，此时需要结合Model类型的参数一起使用
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("msg", "返回ModelAndView");
		model.addAttribute("把value类型的首字母作为key:string");
		return "welcome";
	}

	//2.请求跳转处理

	//请求转发，浏览器地址栏不改变，可以共享请求中的数据
	//原理：request.getRequestDispatcher("").forward(request,response);
	@RequestMapping("/test4")
	public String test4(Model model) {
		return "forward:/hello.html";
	}
	
	//URL重定向，浏览器地址栏会改变，不能共享请求中的数据
	//原理：response.sendRedirect("");
	@RequestMapping("/test5")
	public String test5(Model model) {
		return "redirect:/hello.html";
	}
	/*请求资源的路径问题：以后访问资源的时候，都使用/开头
	 * 		访问资源的时候前面带上/，表示绝对路径，从根路径开始去寻找资源
	 * 		访问资源的时候前面不加/，表示相对路径，从上一级上下文路径中去寻找资源
	 *		/response/test5---->"redirect:/hello.html"---->localhost:/hello.html
	 *		/response/test5---->"redirect:hello.html"---->localhost:/response/hello.html
	 *传统的方式，在URL重定向的时候，因为是两次不同的请求，所以不能共享请求中的数据。
	 *在开发中有的时候，真的需要重定向跳转后共享数据。
	 *spring3.1开始提供了Flash属性，只能使用从Controller重定向到Controller，不能到JSP*/
	
	@RequestMapping("/a")
	public String a(RedirectAttributes ra) {
		ra.addAttribute("msg1","msg1");
		ra.addFlashAttribute("msg2","msg2");
		return "redirect:/response/b";
	}
	@RequestMapping("/b")
	public ModelAndView b(String msg1,@ModelAttribute("msg2")String msg2) {
		System.out.println("msg1:"+msg1);
		System.out.println("msg2:"+msg2);
		return null;
	}
}
