package api;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	HttpClient client = HttpClientBuilder.create().build();

	public static ApiData getUserData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/api?useSSL=false&serverTimezone=UTC";
		String login = "root";
		String password = "root";
		String query = "SELECT * FROM api.data;";
		ResultSet resultSet = getResultSet(url, login, password, query);
		return getUser(resultSet);
	}

	private static ResultSet getResultSet(String url, String login, String password, String query) throws SQLException {
		ResultSet resultSet = null;
		Connection conection = DriverManager.getConnection(url, login, password);
		Statement statement = conection.createStatement();
		resultSet = statement.executeQuery(query);
		return resultSet;
	}

	private static ApiData getUser(ResultSet resultSet) throws SQLException {
		ApiData apiData = new ApiData();
		resultSet.next();
		apiData.setToken(resultSet.getString(1));
		apiData.setUserId(resultSet.getString(2));
		apiData.setMessage(resultSet.getString(3));
		apiData.setEditedMessage(resultSet.getString(4));
		apiData.setRandomId(resultSet.getString(5));
		apiData.setPhotoId(resultSet.getString(6));
		apiData.setTockenVersion(resultSet.getString(7));
		apiData.setUrlForSendMethod(resultSet.getString(8));
		apiData.setUrlForEditMethod(resultSet.getString(9));
		apiData.setUlrForCheckMessageSend(resultSet.getString(10));
		apiData.setUrlForDeleteMethod(resultSet.getString(11));

		return apiData;
	}

	public String sendMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		ApiData apiData = getUserData();
		URIBuilder builder = new URIBuilder(apiData.getUrlForSendMethod());
		builder.setParameter("access_token", apiData.getToken()).setParameter("user_id", apiData.getUserId())
				.setParameter("message", apiData.getMessage()).setParameter("random_id", apiData.getRandomId())
				.setParameter("v", apiData.getTockenVersion());
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		String yourResponse = EntityUtils.toString(response.getEntity());
		String responseSendedMessageString = yourResponse.replaceAll("[^0-9]", "");
		return responseSendedMessageString;
	}

	public String editMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		ApiData apiData = getUserData();
		URIBuilder builder = new URIBuilder(apiData.getUrlForEditMethod());
		builder.setParameter("access_token", apiData.getToken()).setParameter("peer_id", apiData.getUserId())
				.setParameter("message", apiData.getEditedMessage()).setParameter("message_id", sendMessage())
				.setParameter("v", apiData.getTockenVersion());
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		String yourResponse = EntityUtils.toString(response.getEntity());
		String responseEditedMessageString = yourResponse.replaceAll("[^0-9]", "");
		System.out.println(responseEditedMessageString);
		return responseEditedMessageString;

	}

	public String checkMessageSend() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		ApiData apiData = getUserData();
		URIBuilder builder = new URIBuilder(apiData.getUlrForCheckMessageSend());
		builder.setParameter("access_token", apiData.getToken()).setParameter("message_ids", sendMessage())
				.setParameter("v", apiData.getTockenVersion());
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		String yourResponse = EntityUtils.toString(response.getEntity());
		return yourResponse;

	}

	public String deleteMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		ApiData apiData = getUserData();
		URIBuilder builder = new URIBuilder(apiData.getUrlForDeleteMethod());
		builder.setParameter("access_token", apiData.getToken()).setParameter("message_ids", sendMessage())
				.setParameter("v", apiData.getTockenVersion());
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		String yourResponse = EntityUtils.toString(response.getEntity());
		String responseEditedMessageString = yourResponse.replaceAll("[^0-9]", "");
		return responseEditedMessageString;
	}

	public Integer transformFromStringToInteger(String yourString) {
		return Integer.parseInt(yourString);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApiData apiData = getUserData();
		System.out.println(apiData);
	}
}
