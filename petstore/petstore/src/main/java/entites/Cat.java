package entites;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

	private String chipId;

	/**
	 * 
	 */
	public Cat() {
		super();
	}

	/**
	 * @param birth
	 * @param couleur
	 */
	public Cat(Date birth, String couleur, String chipId) {
		super(birth, couleur);
		this.chipId = chipId;
	}

	/**
	 * @return the chipId
	 */
	public String getChipId() {
		return chipId;
	}

	/**
	 * @param chipId the chipId to set
	 */
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\n --> Cat [chipId=");
		builder.append(chipId);
		builder.append("]");
		return builder.toString();
	}

}