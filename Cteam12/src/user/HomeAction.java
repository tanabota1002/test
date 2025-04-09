package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import tool.Action;


public class HomeAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session=req.getSession();
		User user =(User)session.getAttribute("userID");
		req.setAttribute("User",user);


		req.getRequestDispatcher("home.jsp").forward(req, res);
	}
}
