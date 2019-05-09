package code.json;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.vo.User;

//����JSON
@Controller
@RequestMapping("/json")
public class HandleJsonController {
	/*����JSON��ע�⣺
	 *	@ResponseBody��������Ӧ���Ѷ���ת��ΪJSON�ַ���
	 *		���������ϣ�ֻ��Ե�ǰ������JSON����
	 *		�������ϣ���Ե�ǰ�������еķ�����JSON����
	 *
	 *	@Restcontroller��@Controller + @ResponseBody
	 *
	 *	@RequestBody�������������ڶ�ȡHTTP��������ݣ���JSON��ʽ���������ݷ�װ�ɶ���
	 *
	 *һ����������ݸ�ʽ��
	 *	application/x-www-form-urlencoded����ͳ��key-value��ʽ�����������ǳ����㣬����ҪRequestBody�����ԣ�����Ҳ����
	 *	application/multipart���ļ��ϴ�������SpringMVCװ�����ģʽ�����ܴ����ļ��ϴ���Ҳ�ܴ�����ͨ������
	 *	application/json��������JSON��ʽ�ģ���ʱ�ͱ���ʹ��RequestBody*/
	//�ѵ�������/Mapת��ΪJSON��ʽ
	@RequestMapping("/test1")
	@ResponseBody
	public User test1() {
		User u = new User();
		u.setUsername("tom");
		u.setAge(18);
		return u;
	}

	//�Ѷ������ת��ΪJSON��ʽ
	@RequestMapping("/test2")
	@ResponseBody
	public List<User> test2() {
		User u = new User();
		u.setUsername("tom");
		u.setAge(18);
		return Arrays.asList(u,u,u);
	}

	//����һ��String,����@ResponseBody���ص��ַ������ᵱ�����߼���ͼ���ƣ����ǵ���JSON��ʽ������
	@RequestMapping(value="/test3",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String test3() {		
		return "success���bb";
	}
}
