package com.java.testmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JSONController {

	// 참고 사이트 :
	// http://www.journaldev.com/2651/spring-mvc-exception-handling-exceptionhandler-controlleradvice-handlerexceptionresolver-json-response-example

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) throws Exception {
		Shop shop = new Shop();

		if (name.length() > 5) {

			throw new ErrorException(5);

		} else {

			shop.setName(name);
			shop.setStaffName(new String[] { "mkyong1", "mkyong2", "mkyong2", "mkyong2", "mkyong2", "mkyong2",
					"mkyong2", "mkyong2" });
		}
		return shop;
	}

	
	// http://localhost:8080/json/test?test1=1111111111111&test2=22222222222
	@RequestMapping("/test")
	public @ResponseBody Shop getShopInJSON2(HttpServletRequest httpServletRequest) {
		Shop shop = new Shop();

		shop.setName(httpServletRequest.getParameter("test1"));
		
		shop.setStaffName(new String[] {httpServletRequest.getParameter("test2") });
		return shop;
	}

	@ExceptionHandler(ErrorException.class)
	public @ResponseBody Error errorException(Exception ex) {
		Error error = new Error();

		error.setErrorCode("0000");
		error.setErrorMsg(ex.getMessage());

		return error;
	}
}
