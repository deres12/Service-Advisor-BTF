package model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AEntity<PK extends Serializable> {

	public abstract PK getOid();

	@Override
	public String toString() {
		return "[getOid()=" + getOid() + "]";
	}

}
