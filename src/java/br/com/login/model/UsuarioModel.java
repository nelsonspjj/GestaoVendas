package br.com.login.model;

public class UsuarioModel {
	
	private int usuarioId;
	private String login;
	private String email;
	private String senha;
	
	public int getUsuarioId(){
		return usuarioId;
	}
	
	public void setUsuarioId(int usuarioId){
		this.usuarioId = usuarioId;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getSenha(){
		return senha;
	}
	public void setSenha(String senha){
		this.senha = senha;
	}
}
