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

//������
@Controller
@RequestMapping("/response")
public class HandleResponseController {
	//1.����������Ӧ����

	//����void:�ļ�����
	@RequestMapping("/test1")
	public void test1(OutputStream out) throws IOException {
		Files.copy(Paths.get("D:/1.jpg"), out);
	}

	//����ModelAndView
	@RequestMapping("/test2")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "����ModelAndView");
		mv.addObject("��value���͵�����ĸ��Ϊkey:string");
		mv.setViewName("welcome");
		return mv;
	}

	//����String���߼���ͼ���ƣ���ʱ��Ҫ���Model���͵Ĳ���һ��ʹ��
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("msg", "����ModelAndView");
		model.addAttribute("��value���͵�����ĸ��Ϊkey:string");
		return "welcome";
	}

	//2.������ת����

	//����ת�����������ַ�����ı䣬���Թ��������е�����
	//ԭ��request.getRequestDispatcher("").forward(request,response);
	@RequestMapping("/test4")
	public String test4(Model model) {
		return "forward:/hello.html";
	}
	
	//URL�ض����������ַ����ı䣬���ܹ��������е�����
	//ԭ��response.sendRedirect("");
	@RequestMapping("/test5")
	public String test5(Model model) {
		return "redirect:/hello.html";
	}
	/*������Դ��·�����⣺�Ժ������Դ��ʱ�򣬶�ʹ��/��ͷ
	 * 		������Դ��ʱ��ǰ�����/����ʾ����·�����Ӹ�·����ʼȥѰ����Դ
	 * 		������Դ��ʱ��ǰ�治��/����ʾ���·��������һ��������·����ȥѰ����Դ
	 *		/response/test5---->"redirect:/hello.html"---->localhost:/hello.html
	 *		/response/test5---->"redirect:hello.html"---->localhost:/response/hello.html
	 *��ͳ�ķ�ʽ����URL�ض����ʱ����Ϊ�����β�ͬ���������Բ��ܹ��������е����ݡ�
	 *�ڿ������е�ʱ�������Ҫ�ض�����ת�������ݡ�
	 *spring3.1��ʼ�ṩ��Flash���ԣ�ֻ��ʹ�ô�Controller�ض���Controller�����ܵ�JSP*/
	
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
