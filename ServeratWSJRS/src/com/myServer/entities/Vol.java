package com.myServer.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Vol implements Serializable {

	private String idVol;
	private String typeVol;
	private Timestamp departTime;
	private Timestamp arriveTime;
	private String departAero;
	private String arriveAero;
	private double prix;
	private String agenceName;

	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timestamp getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Timestamp departTime) {
		this.departTime = departTime;
	}

	public Timestamp getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getDepartAero() {
		return departAero;
	}

	public void setDepartAero(String departAero) {
		this.departAero = departAero;
	}

	public String getArriveAero() {
		return arriveAero;
	}

	public void setArriveAero(String arriveAero) {
		this.arriveAero = arriveAero;
	}

	public String getAgenceName() {
		return agenceName;
	}

	public void setAgenceName(String agenceName) {
		this.agenceName = agenceName;
	}

	public Vol(String idVol, String typeVol, Timestamp departTime,
			Timestamp arriveTime, String departAero, String arriveAero,
			double prix, String agenceName) {
		super();
		this.idVol = idVol;
		this.typeVol = typeVol;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.departAero = departAero;
		this.arriveAero = arriveAero;
		this.prix = prix;
		this.agenceName = agenceName;
	}

	public String getIdVol() {
		return idVol;
	}

	public void setIdVol(String idVol) {
		this.idVol = idVol;
	}

	public String getTypeVol() {
		return typeVol;
	}

	public void setTypeVol(String typeVol) {
		this.typeVol = typeVol;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
