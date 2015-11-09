package com.offla.ws;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HolaWSClient {
	
	public static void main(String[] args) {
        Client c = Client.create();
        WebResource resource = c.resource("http://localhost:9080/offlaserver01WS/rest/holas/otherurl");
        String response = resource.get(String.class);
        System.out.println("Client say: " + response);
    }

}
