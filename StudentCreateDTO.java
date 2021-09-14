package com.bhargavi.Assignment;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Student")

public class StudentCreateDTO {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator = "auto")
	private int id;
	private String sName;
	private String sStream;
	private double sPer;
    private int sPhone;
	private int sAge;
    private String sAddr;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsStream() {
		return sStream;
	}
	public void setsStream(String sStream) {
		this.sStream = sStream;
	}
	public double getsPer() {
		return sPer;
	}
	public void setsPer(double sPer) {
		this.sPer = sPer;
	}
	public int getsPhone() {
		return sPhone;
	}
	public void setsPhone(int sPhone) {
		this.sPhone = sPhone;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	
}
