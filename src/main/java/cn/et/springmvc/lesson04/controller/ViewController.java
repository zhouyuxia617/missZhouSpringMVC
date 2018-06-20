package cn.et.springmvc.lesson04.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson04.entity.UserInfo;

@Controller
public class ViewController {

/**	@RequestMapping(value="/viewResover",method=RequestMethod.GET)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error) {
		//配置了视图解析器，省略前缀和后缀，配置在mvc-servlet中
		return "lesson04/result";
	}
	*/
	
	//-------------------------------------
	
	@Autowired
	MessageSource ms;
	
/**	@RequestMapping(value="nattion",method=RequestMethod.GET)
	public String reg(OutputStream os,Locale locale) throws UnsupportedEncodingException, NoSuchMessageException, IOException {
		
		os.write(ms.getMessage("key",null,locale).getBytes("UTF-8"));
		
		return null;
	}
	*/
	
	@RequestMapping(value="nattion",method=RequestMethod.GET)
	public String reg(HttpServletResponse response,OutputStream os,Locale locale) throws UnsupportedEncodingException, NoSuchMessageException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		os.write(ms.getMessage("key",null,locale).getBytes("UTF-8"));
		
		return null;
	}
	
	
	//------------------------------------------
	
	@RequestMapping(value="mid",method=RequestMethod.GET)
	public String mid() {
		return "/lesson04/reg.jsp";
	}
	
	
	@RequestMapping(value="/myreg",method=RequestMethod.POST)
	public String mid(@ModelAttribute("user") @Valid UserInfo user,BindingResult result) {
		
		//有错误就跳回去
		if(result.hasErrors()) {
			return "/lesson04/reg2.jsp";
		}
			
		return null;
	}
	
}
