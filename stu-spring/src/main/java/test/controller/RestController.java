package test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/RestController")
public class RestController {
	/*@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String test(@PathVariable Integer id){
		System.out.println("RestController.test()"+id);
		return "index2";
	}*/
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String test2(@PathVariable Integer id){
		System.out.println("RestController.test2()"+id);
		return "index2";
	}
}
