/*--Course class which represent course table-- */

package com.test;

import javax.persistence.Entity;              //importing all the necessary api to perfrom 1:m mapping
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity                              //@Entity annotation represent Course class as an Teacher entity(table)
public class Course {
	
	@Id                             //@Id annotation specifies tId as primary column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cId;
	private String cName;           //cName means Course_Name
	
	
	public int getcId() {                         //generated getter and setter method for
		return cId;                               //cId and cname
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	

}
