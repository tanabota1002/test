package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import tool.Action;

public class UserInfoAction extends Action{

	public void execute(HttpServletRequest req , HttpServletResponse res) throws Exception{


		HttpSession session=req.getSession();
		User user =(User)session.getAttribute("user");



		//詳細情報取得処理記述



		//

		req.setAttribute("User",user);


		req.getRequestDispatcher("user_info.jsp").forward(req,res);

	}
}