package main.metamodel;

public class Transition{
	private String eventName;
	private State state;
	private Condition condition; 
	private Operation operation; 

	public String getEvent() {
		return eventName;
	}

	public void setEvent(String eventName) {
		this.eventName = eventName; 
	}
	public State getTarget() {
		return state;
	}
	public void setTarget(State target) {
		this.state = target; 
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public boolean hasSetOperation() {
		return hasOperation() && operation.getType() == OperationType.SET; 
	}

	public boolean hasIncrementOperation() {
		return hasOperation() && operation.getType() == OperationType.INCREMENT; 
	}

	public boolean hasDecrementOperation() {
		return hasOperation() && operation.getType() == OperationType.DECREMENT;
	}

	public Object getOperationVariableName() {
		return hasOperation() ? operation.getVariableName() : null;
	}

	public boolean isConditional() {
		return this.condition != null;
	}

	public Object getConditionVariableName() {
		return isConditional() ? condition.getVariableName() : null;
	}

	public Integer getConditionComparedValue() {
		return isConditional() ? condition.getValue() : null;
	}

	public boolean isConditionEqual() {
		return isConditional() && condition.getType() == ConditionType.EQUAL;
	}

	public boolean isConditionGreaterThan() {
		return isConditional() && condition.getType() == ConditionType.GREATERTHAN;
	}

	public boolean isConditionLessThan() {
		return isConditional() && condition.getType() == ConditionType.LESSTHAN;
	}

	public boolean hasOperation() {
		return this.operation != null;
	}

}
