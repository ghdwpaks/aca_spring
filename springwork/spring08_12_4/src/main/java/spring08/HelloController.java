package spring08;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Model model, String name) {
		model.addAttribute("now", new Date());
		model.addAttribute("name", name);
		return "hello";
	}

}
