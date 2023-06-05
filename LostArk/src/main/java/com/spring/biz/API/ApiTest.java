package com.spring.biz.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiTest {
	
	
	public static JsonNode LostArk(String url) {
		APIURL key = new APIURL();
		
		final String RequestUrl = url;
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet get = new HttpGet(RequestUrl);
		
		JsonNode returNode = null;
		
		get.addHeader("Authorization", "Bearer " + key.getToken());
		try {
            final HttpResponse response = client.execute(get);
            final int responseCode = response.getStatusLine().getStatusCode();
            
            ObjectMapper mapper = new ObjectMapper();
            returNode = mapper.readTree(response.getEntity().getContent());
            
            System.out.println("\nSending 'GET' request to URL : " + RequestUrl);
            System.out.println("Response Code : " + responseCode);
 
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
        }
		return returNode;
		
	}
}
