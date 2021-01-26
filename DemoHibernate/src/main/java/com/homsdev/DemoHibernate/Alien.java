package com.homsdev.DemoHibernate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "alien_table")
@Cacheable//indicates that this class is cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)//Select a Strategy
public class Alien {

	@Id
	private int aid;
	private String aname;
	private String acolor;

	
	public Alien(int aid, String aname, String acolor) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.acolor = acolor;
	}
	
	public Alien() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAcolor() {
		return acolor;
	}

	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}

}
