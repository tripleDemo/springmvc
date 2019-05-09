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
	/*ModelAttributeע�⣺
	 * 1.�������model��������key���������β��ϣ�Ҳ�������ڷ�����
	 * 		��Է������Ͳ�����ȱʡ����¾ͻ�ŵ�model�й���ȱʡ��key������������ĸСд
	 * 		Ҳ�����ڲ�������ModelAttribute������һ��model��key��*/
	@RequestMapping("/test11")
	public String test11(@ModelAttribute("myUser") User u) {
		System.out.println(u);
		return "welcome";
	}
	
	//��Controller��������һ�������ʱ��ȱʡ��ѵ�ǰ�����URL��Ϊ�߼���ͼ���ƣ�������ǰ���ض���
	//һ��ķ���һ��JavaBean�����ʱ��һ������JSON��������������JSON��(jackson)
	@RequestMapping("/test12")
	//@ResponseBody
	public User test12(User u) {
		System.out.println(u);
		return u;
	}
	
	/* 2.���Ա�עһ����������ķ���������ע�ķ���ÿ������������֮ǰ�������ȱ�ִ��
	 * (��Ŷ��������Ҫ���������)(һ�������)*/
	@ModelAttribute
	public void abc(Model model) {
		System.out.println("abc........");
		//model.addAttribute.......
	}
}
