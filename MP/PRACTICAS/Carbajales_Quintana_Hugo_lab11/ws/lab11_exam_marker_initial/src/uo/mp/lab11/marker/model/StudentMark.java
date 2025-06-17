package uo.mp.lab11.marker.model;

import java.util.Objects;

public class StudentMark{
	private String id;
	private Double mark;
	
	/** 
	 * @param id
	 * @param mark If is < 0, attribute mark is set to zero.  
	 * @throws IllegalArgumentException if 
	 * 			- id is null or blank
	 */
	public StudentMark(String id, double mark) {
		this.id = id;
		this.mark = mark;
	}

	public double getMark() {
		return this.mark;
	}

	public String getStudentId() {
		return this.id;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(id, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentMark other = (StudentMark) obj;
		return Objects.equals(id, other.id) && Objects.equals(mark, other.mark);
	}
	



}
