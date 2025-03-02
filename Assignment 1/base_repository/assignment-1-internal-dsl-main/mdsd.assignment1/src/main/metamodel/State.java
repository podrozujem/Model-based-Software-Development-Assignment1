package main.metamodel;

import java.util.List;

public class State {
	private String name;
	private List<Transition> Transitions;

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public List<Transition> getTransitions() {
		// TODO Auto-generated method stub
		return Transitions;
	}
	
	public void setTransitions(List<Transition> Transitions) {
		// TODO Auto-generated method stub
		this.Transitions = Transitions;
	}

	public Transition getTransitionByEvent(String eventName) {
		return Transitions.stream().filter(t -> t.getEvent().equals(eventName))
				.findFirst()
				.orElse(null);
	}
}
