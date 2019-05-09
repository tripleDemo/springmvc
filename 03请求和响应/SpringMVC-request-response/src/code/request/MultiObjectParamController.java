package code.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import code.vo.Cat;
import code.vo.Dog;

//�����������װ
@Controller
public class MultiObjectParamController {
	/*��Ҫ�ѱ����ݷ�װ���������ȥ��ʱ�����������������ͬ�����ԣ���ʱҪ�����⣬
	 * ��֪���ð���һ��������װ����һ��������ȥ
	 * �Ӳ���--->���󣬷�װ������Ҫ����������*/
	
	//����dog.��ͷ�Ĳ�����װ��dog������
	@InitBinder("dog")//�Զ������ݰ�ע�ᣬ���ڽ�������� ת������Ӧ�Ķ����������ȥ
	public void initBinderDogType(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("dog.");
	}
	@InitBinder("cat")//�Զ������ݰ�ע�ᣬ���ڽ�������� ת������Ӧ�Ķ����������ȥ
	public void initBinderCatType(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("cat.");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(Cat cat,Dog dog) {
		System.out.println(cat);
		System.out.println(dog);
		return null;
	}
}
