package entity;

@SuppressWarnings("serial")
public class Sex implements java.io.Serializable {

	private Integer sexId;
	private String sexType;

	public Sex() {
	}

	public Sex(String sexType) {
		this.sexType = sexType;
	}

	public Integer getSexId() {
		return this.sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	public String getSexType() {
		return this.sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}

}