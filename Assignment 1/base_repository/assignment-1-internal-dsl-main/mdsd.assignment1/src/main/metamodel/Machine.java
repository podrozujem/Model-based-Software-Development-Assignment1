package main.metamodel;

import java.util.List;
import java.util.Map;

public class Machine {

	private List<State> states;
	private State initialState;
	private Map<String, Integer> integers; 

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}
	
	public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

	public State getState(String name) {
		return states.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
	}

	public int numberOfIntegers() {
		// TODO Auto-generated method stub
		return integers.size();
	}

	public boolean hasInteger(String name) {
		// TODO Auto-generated method stub
		return integers.containsKey(name);
	}

	public Map<String, Integer> getIntegers() {
		return integers;
	}

	public void setIntegers(Map<String, Integer> integers) {
		this.integers = integers;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
}

