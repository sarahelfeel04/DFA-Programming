import java.util.ArrayList;

public class Main {

	// modify the code inside this method
	public static DFA  generateDFA(String parse) {
		
		
		 String []s = parse.split("#");
		 String[] states = s[0].split(";");
		 String [] alphabet = s[1].split(";");
		 String [] transitions = s[2].split(";");
		 String start = s[3];
		 String []accept = s[4].split(";");
		 
		 //Transitions
		 ArrayList <Transition> transitionStates = new ArrayList <Transition>();
		 
		 for (int i=0; i<transitions.length; i++) {
			 String [] trans = transitions[i].split(",");
			 String current= trans[0];
			 String input = trans[1];
			 String next = trans[2];
			 Transition a = new Transition(current, input, next);
			 transitionStates.add(a);
		 }
		 
		 //Accept States
		 ArrayList <String> acceptStates = new ArrayList <String>();

		 for (int i=0; i<accept.length; i++) {
			 acceptStates.add(accept[i]);
		 }
		 
		 //All states
		 ArrayList <String> statesFinal = new ArrayList <String>();

		 for (int i=0; i<states.length; i++) {
			 statesFinal.add(states[i]);
		 }
		 
		 //Alphabet
		 ArrayList <String> alphabetFinal = new ArrayList <String>();

		 for (int i=0; i<alphabet.length; i++) {
			 alphabetFinal.add(alphabet[i]);
		 }
		 
		 return new DFA (statesFinal, alphabetFinal, transitionStates, start, acceptStates);
		 
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parse = "q0;q1;d#0;1#q0,0,d;q0,1,q1;q1,0,q0;q1,1,q0;d,0,d;d,1,d#q0#q0;q1";
		DFA dfa1 = generateDFA(parse);
		//dfa1.display();
		
		String s0 = "abab";
		System.out.println(dfa1.isLanguageDFA(s0));
		String s1 = "10111011";
		System.out.println(dfa1.isLanguageDFA(s1));
		String s2 = "";
		System.out.println(dfa1.isLanguageDFA(s2));
		String s3 = "10011110";
		System.out.println(dfa1.isLanguageDFA(s3));
		String s4="";
		//System.out.println(dfa1.isLanguageDFA(s4));
		String s5="";
		//System.out.println(dfa1.isLanguageDFA(s5));
		
		System.out.println();
		System.out.println();
		
		String parse2="q0;q1;d#0;1#q0,0,d;q0,1,q1;q1,0,q0;q1,1,q0;d,0,d;d,1,d#q0#q0;q1";
		DFA dfa2=generateDFA(parse2);
		parse2="s0;s1;s2;s3#0;1#s0,0,s2;s0,1,s1;s1,0,s3;s1,1,s3;s2,0,s1;s2,1,s1;s3,0,s1;s3,1,s1#s0#s2;s3";
		DFA dfa3=generateDFA(parse2);
		boolean isUnion=true;
		DFA mergedU=dfa2.mergeDFA(dfa3,isUnion);
		
		mergedU.display();
		
		isUnion=false;
		
		System.out.println();
		System.out.println();
		
        DFA mergedU2=dfa2.mergeDFA(dfa3,isUnion);
		
		mergedU2.display();
		
		
		
		
			
		
		
	}

}
