package calc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	private double result(int a, int b, Action action) {
		return switch(action) {
		case ADD: yield a+b;
		case SUB: yield a-b;
		case MULTI: yield a*b;
		case DIV: yield (double)a/b;
		};
	}

	@GetMapping("/") 
	public String hello() {
		return "first/hello";
	}
	
	@GetMapping("/calc")
	public String calculator(@RequestParam int a, @RequestParam int b,
						@RequestParam Action action, Model model) {
		
		model.addAttribute("result", result(a, b, action));
		
		return "first/calculator";
	}
}