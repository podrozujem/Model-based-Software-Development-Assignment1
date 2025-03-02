package main.metamodel;

public class Condition{
	private String variableName; 
	private Integer value; 
	private ConditionType type;
	
	public Condition(String variableName, Integer value, ConditionType type) {
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

	public ConditionType getType() {
		return type;
	}

	public void setType(ConditionType type) {
		this.type = type;
	} 
	
	

}