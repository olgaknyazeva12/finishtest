package api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

	@Test
	public void testForSendedMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		App api = new App();
		Integer compareResult = 100000000;
		Assert.assertNotEquals(compareResult, api.transformFromStringToInteger(api.sendMessage()));

	}

	@Test
	public void testForEditedMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		App api = new App();
		Assert.assertNotNull(api.editMessage());

	}

	@Test
	public void testForCheckSendMessage()
			throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		App api = new App();
		Assert.assertNotNull(api.checkMessageSend());
	}

	@Test
	public void testForDeletedMessage() throws ClientProtocolException, IOException, URISyntaxException, SQLException {
		App api = new App();
		String comparedResult = "1";
		Assert.assertNotEquals(comparedResult, api.deleteMessage());
	}
}
