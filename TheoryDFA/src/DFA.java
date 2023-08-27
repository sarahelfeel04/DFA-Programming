import java.util.ArrayList;

public class DFA {
	
	ArrayList<String> states;
	ArrayList<String> alphabet;
	ArrayList<Transition> transitions;
	String startState;
	ArrayList<String> acceptStates;
	
	public DFA(ArrayList<String> states , ArrayList<String> alphabet , ArrayList<Transition> transitions , 
	String startState , ArrayList<String> acceptStates) {
		
		this.states = states;
		this.alphabet = alphabet; 
		this.transitions = transitions;
		this.startState = startState;
		this.acceptStates = acceptStates;
		
	}
	
	 public void display() {
		
		System.out.println(  "states"  );
		System.out.println(  this.states  );
		System.out.println(  "alphabet"  );
		System.out.println(  this.alphabet  );
		
		System.out.println(  "transition states"  );
		for( Transition trans : this.transitions) {
			trans.printTransition();
		}
		
		System.out.println(  "startState"  );
		System.out.println(  this.startState  );
		System.out.println(  "acceptStates"  );
		System.out.println(  this.acceptStates  );

		
		
	}	
	
	
// modify the code inside this method
public  String isLanguageDFA( String input) {
    String [] characters = new String [input.length()];
    
    if (input.length()==0 && acceptStates.contains(startState))
    	return "accepted";
    
    if (input.length()==0 && !(acceptStates.contains(startState)))
    	return "rejected";
    
	for (int i=0; i<input.length(); i++) {
		characters[i]= ""+input.charAt(i);
		
		if (alphabet.contains(characters[i])==false) {
			return "InvalidString";
		}
	}
	
	String currentStart=this.startState;
	String characterInput;
	String nextState=this.startState;
	
	for (int i=0; i<characters.length; i++) {
		characterInput = characters[i];
		
		for (int j=0; j<transitions.size(); j++) {
			
			if (transitions.get(j).currentState.equals(currentStart) && transitions.get(j).input.equals(characterInput) ) {
		          currentStart=transitions.get(j).nextState;
		          break;
				}
			}
			
		}
		
	
	if (this.acceptStates.contains(currentStart))
		return "accepted";
	else
		return "rejected";
		

}


public DFA mergeDFA(  DFA secondDFA  ,  boolean isUnion) {
	DFA dfa1=this;
	DFA dfa2 = secondDFA;
	
	ArrayList<String> newStates = new ArrayList <String>();
	ArrayList<String> newAlphabet=this.alphabet;
	ArrayList<Transition> newTransitions=new ArrayList <Transition>();
	String newStartState;
	ArrayList<String> newAcceptStates=new ArrayList <String>();
	
	
	newStartState = "{"+dfa1.startState+","+ dfa2.startState+"}";
	newStates.add(newStartState);
	

	for (int i=0; i<newStates.size(); i++) {
		
		
		String[] splittedStates = newStates.get(i).substring(1, newStates.get(i).length() - 1).split(",");
		String state1 = splittedStates[0];
        String state2 = splittedStates[1];
        
       
        if (isUnion&& (dfa1.acceptStates.contains(state1)||dfa2.acceptStates.contains(state2))) {
       	 newAcceptStates.add(newStates.get(i));
        }
    	else if (isUnion==false && dfa1.acceptStates.contains(state1)&&dfa2.acceptStates.contains(state2)) {
       	 newAcceptStates.add(newStates.get(i));
        }
        
        
	     for (int j=0; j<newAlphabet.size(); j++) {
	    	 String nextState1 = getNextState(state1, newAlphabet.get(j), this.transitions);
             String nextState2 = getNextState(state2, newAlphabet.get(j), secondDFA.transitions);
             String mergedNextState = "{" + nextState1 + "," + nextState2 + "}";
             newTransitions.add(new Transition(newStates.get(i), newAlphabet.get(j), mergedNextState));

             
             if (!newStates.contains(mergedNextState)) {
                 newStates.add(mergedNextState);
                 
             }
             
	     }
		
		
	}
	

	 return new DFA(newStates, new ArrayList<>(this.alphabet), newTransitions, newStartState, newAcceptStates);
}

public String getNextState(String state, String symbol, ArrayList<Transition> transitions) {
	
	
    for (Transition transition : transitions) {
        if (transition.currentState.equals(state) && transition.input.equals(symbol)) {
            return transition.nextState;
        }
    }
    return "";
}

	public static void main(String[] args) {
		// TODO Auto-generated method stube

	}

}
