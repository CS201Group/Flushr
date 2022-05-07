import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RunSimulationDispatcher")

public class RunSimulationDispatcher extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RunSimulationDispatcher() {
    	super();
    }
	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String ans = "";
    	final int totalWizards = 8;

            List<Wizard> wizards = new ArrayList<Wizard>();
            Wizard finalWinner = new Wizard("Muggle","Kwikspell",0); //dummy object: feel free to delete if you do not want to use it.

            wizards.add(new Wizard("Tommy Trojan", "Paper", 7));
            wizards.add(new Wizard("Tammy Trojan", "Scissors", 2));
            wizards.add(new Wizard("Tina Trojan","Paper",3));
            wizards.add(new Wizard("Timothy Trojan", "Scissors", 4));
            wizards.add(new Wizard("Telly Trojan","Rock",1));
            wizards.add(new Wizard("Tuffy Trojan", "Paper", 5));
            wizards.add(new Wizard("Tulip Trojan","Rock",6));
            wizards.add(new Wizard("Barry Bruin", "Paper", 8));


            // Shuffle the list so that there is different winner every time
            //Collections.shuffle(wizards);

            // implement ForkJoinPool here.
            // at the end print the champion
            ForkJoinPool pool = new ForkJoinPool();
            TournamentMatch task = new TournamentMatch(wizards);
            finalWinner = pool.invoke(task);
            task.addStatement("\n====Playing Level 3 duels====", 12);
            task.addStatement("\n====Playing Level 2 duels====", 8);
            task.addStatement("====Playing Level 1 duels====", 0);
            
            
            for (String str : TournamentMatch.statements) {
            		ans += str + "\n";
            }
            ans += "THE CHAMPION is: " + finalWinner.getWizardName();
            request.setAttribute("simulation", ans);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("multithreading.jsp");
    		requestDispatcher.forward(request, response);
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}
