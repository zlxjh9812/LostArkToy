package com.spring.biz;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.biz.API.ApiTest;
import com.spring.biz.news.NewsServies;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
@Autowired
NewsServies notice;


}
