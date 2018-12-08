package api;

public class ApiData {
	private String token;
	private String userId;
	private String message;
	private String editedMessage;
	private String randomId;
	private String photoId;
	private String tockenVersion;
	private String urlForSendMethod;
	private String urlForEditMethod;
	private String ulrForCheckMessageSend;
	private String urlForDeleteMethod;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEditedMessage() {
		return editedMessage;
	}

	public void setEditedMessage(String editedMessage) {
		this.editedMessage = editedMessage;
	}

	public String getRandomId() {
		return randomId;
	}

	public void setRandomId(String randomId) {
		this.randomId = randomId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getTockenVersion() {
		return tockenVersion;
	}

	public void setTockenVersion(String tockenVersion) {
		this.tockenVersion = tockenVersion;
	}

	public String getUrlForSendMethod() {
		return urlForSendMethod;
	}

	public void setUrlForSendMethod(String urlForSendMethod) {
		this.urlForSendMethod = urlForSendMethod;
	}

	public String getUrlForEditMethod() {
		return urlForEditMethod;
	}

	public void setUrlForEditMethod(String urlForEditMethod) {
		this.urlForEditMethod = urlForEditMethod;
	}

	public String getUlrForCheckMessageSend() {
		return ulrForCheckMessageSend;
	}

	public void setUlrForCheckMessageSend(String ulrForCheckMessageSend) {
		this.ulrForCheckMessageSend = ulrForCheckMessageSend;
	}

	public String getUrlForDeleteMethod() {
		return urlForDeleteMethod;
	}

	public void setUrlForDeleteMethod(String urlForDeleteMethod) {
		this.urlForDeleteMethod = urlForDeleteMethod;
	}

	@Override
	public String toString() {
		return "ApiData [token=" + token + ", userId=" + userId + ", message=" + message + ", editedMessage="
				+ editedMessage + ", randomId=" + randomId + ", photoId=" + photoId + ", tockenVersion=" + tockenVersion
				+ ", urlForSendMethod=" + urlForSendMethod + ", urlForEditMethod=" + urlForEditMethod
				+ ", ulrForCheckMessageSend=" + ulrForCheckMessageSend + ", urlForDeleteMethod=" + urlForDeleteMethod
				+ "]";
	}

}
