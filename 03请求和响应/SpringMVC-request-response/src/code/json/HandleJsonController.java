package code.json;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.vo.User;

//处理JSON
@Controller
@RequestMapping("/json")
public class HandleJsonController {
	/*处理JSON的注解：
	 *	@ResponseBody：处理响应，把对象转换为JSON字符串
	 *		贴到方法上：只针对当前方法做JSON处理
	 *		贴到类上：会对当前类中所有的方法做JSON处理
	 *
	 *	@Restcontroller：@Controller + @ResponseBody
	 *
	 *	@RequestBody：处理请求，用于读取HTTP请求的内容，把JSON格式的请求数据封装成对象
	 *
	 *一般的请求数据格式：
	 *	application/x-www-form-urlencoded：传统的key-value格式，处理起来非常方便，不需要RequestBody都可以，贴上也可以
	 *	application/multipart：文件上传的请求，SpringMVC装饰设计模式，既能处理文件上传，也能处理普通表单数据
	 *	application/json：参数是JSON格式的，此时就必须使用RequestBody*/
	//把单个对象/Map转换为JSON格式
	@RequestMapping("/test1")
	@ResponseBody
	public User test1() {
		User u = new User();
		u.setUsername("tom");
		u.setAge(18);
		return u;
	}

	//把多个对象转换为JSON格式
	@RequestMapping("/test2")
	@ResponseBody
	public List<User> test2() {
		User u = new User();
		u.setUsername("tom");
		u.setAge(18);
		return Arrays.asList(u,u,u);
	}

	//返回一个String,贴上@ResponseBody返回的字符串不会当做是逻辑视图名称，而是当做JSON格式的数据
	@RequestMapping(value="/test3",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String test3() {		
		return "success你好bb";
	}
}
