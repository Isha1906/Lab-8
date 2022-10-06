/*--Teacher class which represent Teacher table--*/

package com.test;

import java.util.*;            //importing list from util package

import javax.persistence.*;     //importing all the necessary api to perfrom 1:m mapping


@Entity                      //@Entity annotation represent Teacher class as an Teacher entity(table)
public class Teacher {
	
	
	@Id                      //@Id annotation specifies tId as primary column
	@PrimaryKeyJoinColumn    //@PrimaryKeyJoinColumn sepcifies tid to use as a foreign key in another table to map or join 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tId;
	
	private String tname;         //tName means Teacher_Name
	
	@OneToMany(cascade=CascadeType.ALL)        //@OneToMany is used to specifies 1:m association with another table/entity
	private List<Course> crs=new ArrayList<>();

	public int gettId() {                      //created getter setter method for tId,tName,crs
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<Course> getCrs() {
		return crs;
	}

	public void setCrs(List<Course> crs) {
		this.crs = crs;
	}
	

}
