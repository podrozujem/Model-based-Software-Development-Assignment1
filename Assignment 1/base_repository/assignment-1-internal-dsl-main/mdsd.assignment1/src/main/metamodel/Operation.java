package main.metamodel;

public class Operation{
	private String variableName;
	private Integer value;
    private OperationType type;



    public Operation(String variableName, Integer value, OperationType type) {
		super();
		this.variableName = variableName;
		this.value = value;
		this.type = type;
	}



	public String getVariableName() {
		return variableName;
	}



	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}



	public Integer getValue() {
		return value;
	}



	public void setValue(Integer value) {
		this.value = value;
	}



	public OperationType getType() {
		return type;
	}



	public void setType(OperationType type) {
		this.type = type;
	}


}