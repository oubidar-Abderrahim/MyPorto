package com.myServer.entities;

public class Reservation {
	
	private int id; 
	private double prix ;
	private Vol vol ;
	private int idUser ;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(int id, double prix, Vol vol, int idUser) {
		super();
		this.id = id;
		this.prix = prix;
		this.vol = vol;
		this.idUser = idUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	

}
