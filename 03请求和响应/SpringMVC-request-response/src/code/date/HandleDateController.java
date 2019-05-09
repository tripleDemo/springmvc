package code.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import code.vo.User;

@Controller
@RequestMapping("/date")
public class HandleDateController {
	//从前台向后台传递参数：String-->java.util.Date
	//把请求参数封装成Date类型
	@RequestMapping("/test1")
	public ModelAndView test1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
		System.out.println(d);
		return null;
	}

	//把请求参数封装成Date类型
	@RequestMapping("/test2")
	public ModelAndView test2(User u) {
		System.out.println(u);
		return null;
	}
	
	//如果不想每次都在Date类型上贴@DateTimeFormat
	/*
	 * @InitBinder public void initBinderDateType(WebDataBinder binder) {
	 * SimpleDateFormat sdf = new SimpleDateFormat();
	 * sdf.applyPattern("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf,
	 * true)); }
	 */
	
	@RequestMapping("/test3")
	@ResponseBody
	public User test3() {
		User u = new User();
		u.setUsername("tom");
		u.setAge(18);
		u.setHiredate(new Date());
		return u;
	}
}
