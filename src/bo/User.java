package bo;

import java.io.Serializable;

public class User implements Serializable {

	private int idUser;
	private String login;
	private String password;
	private int bestScore;
	
	public User() {}
	
	public User( String login, String password, int bestScore ) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin( String login ) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}

}
