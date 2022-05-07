import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;



public class TournamentMatch extends RecursiveTask<Wizard> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Wizard> winnerList;   //feel free to modify if required
    static List<String> statements = new ArrayList<String>();

    /* Feel free to modify the constructor if required */
    public TournamentMatch(List<Wizard> winnerList){
        this.winnerList = winnerList;
    }
    /* Feel free to modify getWinnerList if required */
    public List<Wizard> getWinnerList(){ 
        return this.winnerList;
    }
    public List<String> getStatements(){ 
        return this.statements;
    }
    
    public void addStatement(String s, int index) {
    	this.statements.add(index, s);
    	return;
    }
/*This is the compute() function which would called by the ForkJoinPool in the main method.
*/
    protected Wizard compute(){
    	if (winnerList.size() == 2) {
    		return playDuel(winnerList.get(0), winnerList.get(1));
    	}
    	else {
    		int mid = winnerList.size() / 2;
    		TournamentMatch t1 = new TournamentMatch(winnerList.subList(0, mid));
    		TournamentMatch t2 = new TournamentMatch(winnerList.subList(mid, winnerList.size()));
    		t1.fork();
    		t2.fork();
    		return playDuel(t1.join(), t2.join());
    	}
    	/*
    	for (int i = 0; i < winnerList.size()-1; i ++) {
    		statements.add(winnerList.get(i).getWizardName() + ": " + winnerList.get(i).getWizardSpell() + " vs " + winnerList.get(i+1).getWizardName() + ": " + winnerList.get(i+1).getWizardSpell());
        	winnerList.add(i, playDuel(winnerList.remove(i), winnerList.remove(i+1)));
        	statements.add("Winner: " + winnerList.get(i).getWizardName());
    	}
    	TournamentMatch t = new TournamentMatch(winnerList);
    	t.fork();
    	return t.join();
    	*/
    	
    	
    }


/*playDuel() gives the result of the match 
Rules of duel:

Paper beats Rock
Scissors beats Paper
Rock beats Scissors

In case of a tie, the wizard with the top rank wins (rank 1 > rank 2)
*/
    private Wizard playDuel(Wizard w1, Wizard w2){
        String spell1 = w1.getWizardSpell();
        String spell2 = w2.getWizardSpell();
        statements.add(w1.getWizardName() + ": " + spell1 + " vs " + w2.getWizardName() + ": " + spell2);
        if (spell1.equalsIgnoreCase(spell2)) {
        	if (w1.getWizardRank() < w2.getWizardRank()) {
        		statements.add("Winner: " + w1.getWizardName());
        		return w1;
        	}
        	else {
        		statements.add("Winner: " + w2.getWizardName());
        		return w2;
        	}
        }
        if (spell1.equalsIgnoreCase("Paper")) {
        	if (spell2.equalsIgnoreCase("Scissors")) {
        		statements.add("Winner: " + w2.getWizardName());
        		return w2;
        	}
        	else {//if (spell2.equalsIgnoreCase("Rock")) {
        		statements.add("Winner: " + w1.getWizardName());
        		return w1;
        	}
        }
        else if (spell1.equalsIgnoreCase("Scissors")) {
        	if (spell2.equalsIgnoreCase("Paper")) {
        		statements.add("Winner: " + w1.getWizardName());
        		return w1;
        	}
        	else {//if (spell2.equalsIgnoreCase("Rock")) {
        		statements.add("Winner: " + w2.getWizardName());
        		return w2;
        	}
        }
        else {
        	if (spell2.equalsIgnoreCase("Scissors")) {
        		statements.add("Winner: " + w1.getWizardName());
        		return w1;
        	}
        	else {//if (spell2.equalsIgnoreCase("Paper")) {
        		statements.add("Winner: " + w2.getWizardName());
        		return w2;
        	}
        }
    }   
}
