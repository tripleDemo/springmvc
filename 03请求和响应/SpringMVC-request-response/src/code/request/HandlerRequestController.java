package code.request;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import code.vo.FormBean;
import code.vo.User;

@Controller
@RequestMapping("/request")
public class HandlerRequestController {
	//1.����������������
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println(request.getParameter("username"));
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		System.out.println(this.servletContext);
	}
	
	//��ȡ�����������֤����������ƺ�Controller��������ʽ����(���)ͬ��
	//�������������ƺ��β����Ʋ�ͬ--->@RequestParam
	@RequestMapping("/test2")
	public void test2(@RequestParam("name") String username,@RequestParam(value="age",required=false) Integer age) {
		System.out.println("username="+username);
		System.out.println("age="+age);
	}
	
	//RESTfull��񴫲�
	//    /delete?id=110
	//    /delete/110
	//@PathVariable:���Խ�URL��ռλ���󶨵��������β���
	@RequestMapping("/delete/{id}")
	public void test3(@PathVariable("id")Long id) {
		System.out.println(id);
	}
	
	//2.�����������������
	//����һ�������ж��ֵ�����
	//����ɾ��	/batchDelete?ids=10&ids=20&ids=30
	//ʹ�����飺����ֱ�ӽ���:public void batchDelete(Long[] ids){}
	
	///batchDelete?ids[0]=10&ids[1]=20&ids[2]=30//����ҳ�޷���������������
	//ʹ��List������ֱ�ӽ��գ������ڶ����д���һ������
	@RequestMapping("/batchDelete")
	public void batchDelete(FormBean fb) {
		System.out.println(fb.getIds());
	}
	//����һ�������ж��ֵ�������һ��ֱ��ʹ��������վͿ����ˣ�����ʹ��JavaBean��������װ����
	
	//������ֱ�ӷ�װ��JavaBean����
	@RequestMapping("/test4")
	public void test4(User u) {
		System.out.println(u);
	}
}
