package fixer.io;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class CurrencyClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://api.fixer.io/");

		System.out.println("As json string");
		System.out.println(target.path("latest").request(MediaType.APPLICATION_JSON).get(String.class));

		Response response = target.path("latest").request(MediaType.APPLICATION_JSON).get();

		ExchangeRates exchangeRates = response.readEntity(ExchangeRates.class);
		System.out.println("\nAs POJOs rates:");
		System.out.println("base " + exchangeRates.getBase() + ", date " + exchangeRates.getDate());
		System.out.println(exchangeRates.getRates().keySet().size());

	}
}
