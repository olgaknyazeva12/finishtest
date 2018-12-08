package pack;

public class MailBoxCommonPage extends Mail {

	public String yourTestEmail = "test-test-1953";
	public String yourTestPassword = "12345678asd";

	public String getYourTestEmail() {
		return yourTestEmail;
	}

	public void setYourTestEmail(String yourTestEmail) {
		this.yourTestEmail = yourTestEmail;
	}

	public String getYourTestPassword() {
		return yourTestPassword;
	}

	public void setYourTestPassword(String yourTestPassword) {
		this.yourTestPassword = yourTestPassword;
	}

	public void print() {
		System.out.println("Class MailBoxCommonPage is run successfully!");
	}

}
