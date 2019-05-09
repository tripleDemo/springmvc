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
	//1.处理简单类型请求参数
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
	
	//获取请求参数，保证请求参数名称和Controller方法的形式参数(入参)同名
	//如果请求参数名称和形参名称不同--->@RequestParam
	@RequestMapping("/test2")
	public void test2(@RequestParam("name") String username,@RequestParam(value="age",required=false) Integer age) {
		System.out.println("username="+username);
		System.out.println("age="+age);
	}
	
	//RESTfull风格传参
	//    /delete?id=110
	//    /delete/110
	//@PathVariable:可以将URL中占位符绑定到方法的形参中
	@RequestMapping("/delete/{id}")
	public void test3(@PathVariable("id")Long id) {
		System.out.println(id);
	}
	
	//2.处理复合类型请求参数
	//接收一个参数有多个值的情况
	//批量删除	/batchDelete?ids=10&ids=20&ids=30
	//使用数组：可以直接接收:public void batchDelete(Long[] ids){}
	
	///batchDelete?ids[0]=10&ids[1]=20&ids[2]=30//该网页无法正常运作？？？
	//使用List：不能直接接收，可以在对象中存在一个集合
	@RequestMapping("/batchDelete")
	public void batchDelete(FormBean fb) {
		System.out.println(fb.getIds());
	}
	//操作一个参数有多个值的情况，一般直接使用数组接收就可以了，或者使用JavaBean对象来封装数据
	
	//把数据直接封装到JavaBean对象
	@RequestMapping("/test4")
	public void test4(User u) {
		System.out.println(u);
	}
}
