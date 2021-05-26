package Lab7;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

  public static void main(String[] args) {

    String uri;
    String proxyAddress;
    int port;

    try {
      uri = args[0];
      proxyAddress = args[1];
      port = Integer.parseInt(args[2]);
    } catch (Exception e) {
      throw new IllegalArgumentException("Please specify arguments in following format: uri proxy_address proxy_port");
    }

    HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(new InetSocketAddress(proxyAddress, port)))
        .build();

    HttpRequest req;
    try {
      req = HttpRequest.newBuilder(new URI(uri)).build();
    } catch (Exception e) {
      throw new IllegalArgumentException("uri is invalid");
    }

    try {
      HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
      System.out.println(res.body());
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Can't connect to target server using proxy");
    }

  }
}
