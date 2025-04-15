

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 *  implementation class GuessingGame
 */
@WebServlet("/GuessingGame")
public class GuessingGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessingGame() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer number = (Integer) session.getAttribute("number");
        Integer attempts = (Integer) session.getAttribute("attempts");

        if (number == null || attempts == null || attempts == 0) {
            number = (int) (Math.random() * 100) + 1;
            attempts = 7;
            session.setAttribute("number", number);
        }

        int guess = Integer.parseInt(request.getParameter("guess"));
        attempts--;

        String message;

        if (guess < number) {
            message = "Too low!";
        } else if (guess > number) {
            message = "Too high!";
        } else {
            message = "You win!";
            attempts = 0;
        }

        if (attempts == 0 && guess != number) {
            message = "You lose! The correct number was " + number + ".";
        }

        session.setAttribute("attempts", attempts);
        session.setAttribute("message", message);

        // Reset game if it ends
        if (attempts == 0) {
            session.removeAttribute("number");
            session.removeAttribute("attempts");
        }

        response.sendRedirect("index.jsp");
    }	

}
