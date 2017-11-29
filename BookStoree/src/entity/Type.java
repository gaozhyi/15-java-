package entity;

@SuppressWarnings("serial")
public class Type implements java.io.Serializable {


	private Integer typeId;
	private String typeName;

	public Type() {
	}

	public Type(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}