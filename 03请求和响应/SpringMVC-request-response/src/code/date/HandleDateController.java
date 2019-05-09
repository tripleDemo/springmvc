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
	//��ǰ̨���̨���ݲ�����String-->java.util.Date
	//�����������װ��Date����
	@RequestMapping("/test1")
	public ModelAndView test1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
		System.out.println(d);
		return null;
	}

	//�����������װ��Date����
	@RequestMapping("/test2")
	public ModelAndView test2(User u) {
		System.out.println(u);
		return null;
	}
	
	//�������ÿ�ζ���Date��������@DateTimeFormat
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
