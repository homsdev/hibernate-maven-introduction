package com.homsdev.DemoHibernate;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	private String mName;
	private String lName;
	private String fName;

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Override
	public String toString() {
		return "AlienName [mName=" + mName + ", lName=" + lName + ", fName=" + fName + "]";
	}

}
