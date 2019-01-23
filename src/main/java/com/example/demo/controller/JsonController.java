package com.example.demo.controller;


import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@RequestMapping("/api/")
@RestController
public class JsonController {
	@PostMapping(value = "receive")
	public ResponseEntity<String> receive(@RequestBody String requestJson,HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		System.out.println("request: " + requestJson);
		JsonObject json = gson.fromJson(requestJson, JsonObject.class);
		json.addProperty("2", "hien2");
		Set<Entry<String, JsonElement>> entrySet = json.entrySet();
		for (Entry<String, JsonElement> ele: entrySet) {
			System.out.println(ele.getKey() + ", " + ele.getValue());
		}
		
		String jsonStr = gson.toJson(json);
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}
}
