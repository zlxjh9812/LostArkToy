package com.spring.biz;

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
	final static String Token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAyNTY4NDYifQ.AMUIJgDdv_9iLUPZDV1QGoGb-9H5oORqXz8OwvI9I8_uAnArCuggDKY1z0plYlIyyAk0nQWW7DnwGstVSwVJIp05lHhgdt-HErSfaS3EzTLpr7O4KpXIzXhnQkMsBS15jI3CpTTt8EXzvCIUlGv6IoLKJ2jwfebwy4KDmm3pa6qoZy5j_1FDlMAkj7owp1Fwa48EbD58kMUgsA2oyA0yDXUCPuEPTOkBx_eMoz1gz_rQAgHbGKH1HBuEtVqvw9UvflFGQzDbw1B3PCt3U1aaIJo2eYoySb2Iyyb8AnLzmiODOVfVLOo5ngcUYduLPyd4gAkBLf60nR57E_pg7YWPeg";
	
	public static JsonNode LostArk() {
		final String RequestUrl = "https://developer-lostark.game.onstove.com/characters/낭랑하고정아한/siblings";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet get = new HttpGet(RequestUrl);
		
		JsonNode returNode = null;
		
		get.addHeader("Authorization", "Bearer " + Token);
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
