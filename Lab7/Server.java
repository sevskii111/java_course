package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Server {

	public static void main(String[] args) {
		int port = 8080;

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (!serverSocket.isClosed()) {
				System.out.println("Server started! Port: " + serverSocket.getLocalPort());
				Socket client = serverSocket.accept();
				System.out.println("New connection! " + serverSocket.getInetAddress() + " port " + client.getPort());
				System.out.print("Connection accepted.");
				new ClientHandler(client).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Wrong open server socket!");
		}
	}
}

class ClientHandler extends Thread {

	private Socket client;

	ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

				PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
			String urlStr = in.readLine();
			System.out.println("Accepted request: " + urlStr);

			urlStr = urlStr.split(" ")[1];
			System.out.println("URL: " + urlStr);

			HttpURLConnection httpConnection = (HttpURLConnection) (new URL(urlStr)).openConnection();

			BufferedReader webReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			String webPage;

			out.println("HTTP/1.1 " + httpConnection.getResponseCode());
			for (var header : httpConnection.getHeaderFields().entrySet()) {
				out.println(header.getKey() + ": " + header.getValue().get(0));
			}
			out.println();
			while ((webPage = webReader.readLine()) != null) {
				out.println(webPage);
				out.flush();
			}

			client.close();

			System.out.println("Closing connections & channels - DONE.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
