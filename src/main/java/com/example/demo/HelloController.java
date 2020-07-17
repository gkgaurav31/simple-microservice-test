package com.example.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${NAME}")
	String name;
	
	@GetMapping("/")
	public String test() {
		return "You are doing great, " + name;
	}
	
	@GetMapping("/jvm")
	public List<String> getJVMArguments() {
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		return arguments;
	}
	
}
