package sonarqclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.cedarsoftware.util.io.JsonWriter;

public class SonarQClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://lx-tson01.aeat.allianz.at:9000/");
		
		System.out.println("Reading all SonarQ projects");
		String allResources = target.path("api/resources").request().get(String.class);
		System.out.println(allResources);
		
		String niceFormattedJson = JsonWriter.formatJson(allResources);
		System.out.println(niceFormattedJson);
		

		System.out.println();
		System.out.println("Reading only AEV");
		String aevResource = target.path("api/resources").queryParam("resource","1058942").request().get(String.class);
		System.out.println(aevResource);
		
		niceFormattedJson = JsonWriter.formatJson(aevResource);
		System.out.println(niceFormattedJson);
	}
	
	
}
