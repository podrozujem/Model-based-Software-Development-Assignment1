package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import main.metamodel.*;

public class StateMachine {
	private Machine machine = new Machine();
    private State currentState;
    private Transition currentTransition;

    public StateMachine() {
        machine.setStates(new ArrayList<>());
        machine.setIntegers(new HashMap<>());
    }
    
	public Machine build() {
		Map<String, State> stateLookup = machine.getStates().stream()
                .collect(Collectors.toMap(State::getName, state -> state));

        machine.getStates().forEach(state -> state.getTransitions().forEach(transition -> {
            State targetState = stateLookup.get(transition.getTarget().getName());
            if (targetState != null) {
                transition.setTarget(targetState);
            }
        }));

        return machine;
	}

	public StateMachine state(String name) {
		State newState = new State();
        newState.setName(name);
        newState.setTransitions(new ArrayList<>());
        machine.getStates().add(newState);
        this.currentState = newState;
        return this;
	}

	public StateMachine initial() {
		machine.setInitialState(currentState);
        return this;
	}

	public StateMachine when(String eventName) {
		Transition newTransition = new Transition();
        newTransition.setEvent(eventName);
        currentState.getTransitions().add(newTransition);
        this.currentTransition = newTransition;
        return this;
	}

	public StateMachine to(String stateName) {
		State newState = new State();
        newState.setName(stateName);
        currentTransition.setTarget(newState);
        return this;
	}

	public StateMachine integer(String name) {
		machine.getIntegers().put(name, 0);
        return this;
	}

	public StateMachine set(String variableName, int value) {
		currentTransition.setOperation(new Operation(variableName, value, OperationType.SET));
        return this;
	}

	public StateMachine increment(String variableName) {
		currentTransition.setOperation(new Operation(variableName, null, OperationType.INCREMENT));
        return this;
	}

	public StateMachine decrement(String variableName) {
		currentTransition.setOperation(new Operation(variableName, null, OperationType.DECREMENT));
        return this;
	}

	public StateMachine ifEquals(String variableName, int value) {
		currentTransition.setCondition(new Condition(variableName, value, ConditionType.EQUAL));
        return this;
	}

	public StateMachine ifGreaterThan(String variableName, int value) {
		currentTransition.setCondition(new Condition(variableName, value, ConditionType.GREATERTHAN));
        return this;
	}

	public StateMachine ifLessThan(String variableName, int value) {
		currentTransition.setCondition(new Condition(variableName, value, ConditionType.LESSTHAN));
        return this;
	}

}
