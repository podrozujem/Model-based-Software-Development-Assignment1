package main;

import main.metamodel.*;

public class MachineInterpreter {
	private Machine machine;
    private State currentState;
    
    public void run(Machine m) {
    	this.machine = m;
        this.currentState = machine.getInitialState();
    }

    public State getCurrentState() {
    	return this.currentState;
    }

    public void processEvent(String eventName) {
        for (Transition transition : currentState.getTransitions()) {
            if(transition.getEvent() != eventName) {
                continue;
            }

            boolean isConditionMet = true;

            if(transition.isConditional()) {
                Condition condition = transition.getCondition();
                int value = getInteger(condition.getVariableName());

                switch(condition.getType()) {
                    case EQUAL:
                        isConditionMet = value == condition.getValue();
                        break;
                    case GREATERTHAN:
                        isConditionMet = value > condition.getValue();
                        break;
                    case LESSTHAN:
                        isConditionMet = value < condition.getValue();
                        break;
                }
            }

            if(!isConditionMet) {
                continue;
            }

            if(transition.hasOperation()) {
                Operation operation = transition.getOperation();
                String operationVariableName = operation.getVariableName();
                int currentValue = getInteger(operationVariableName);

                switch(operation.getType()) {
                    case SET:
                        setIntegers(operationVariableName, operation.getValue());
                        break;
                    case INCREMENT:
                        setIntegers(operationVariableName, currentValue + 1);
                        break;
                    case DECREMENT:
                        setIntegers(operationVariableName, currentValue - 1);
                        break;
                }
            }

            currentState = transition.getTarget();
            break;
        }


    }

    public int getInteger(String variableName) {
    	return machine.getIntegers().getOrDefault(variableName, 0);
    }
    
    private void setIntegers(String variableName, Integer value) {
    	machine.getIntegers().put(variableName, value);
    }

}
