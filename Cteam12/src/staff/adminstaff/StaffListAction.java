package staff.adminstaff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class StaffListAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        Staff staff = (Staff) session.getAttribute("user");

        // パラメータ用の変数
        int staffID = 0;
        String staffname = "";
        String staffrole = "";

        // DAOの初期化
        StaffDao sDao = new StaffDao();
        Map<String, String> errors = new HashMap<>();

        // StaffIDをリクエストから取得してintに変換
        String staffIdStr = req.getParameter("f1");
        if (staffIdStr != null && !staffIdStr.isEmpty()) {
            try {
                staffID = Integer.parseInt(staffIdStr);
            } catch (NumberFormatException e) {
                errors.put("f1", "StaffIDには数値を入力してください");
            }
        }

        // 他のパラメータを取得
        staffname = req.getParameter("f2");
        staffrole = req.getParameter("f3");

        // フィルタリング処理
        List<Staff> staffs = sDao.filterStaff(staffID, staffname, staffrole);

        // リクエスト属性に設定
        req.setAttribute("f1", staffIdStr);
        req.setAttribute("f2", staffname);
        req.setAttribute("f3", staffrole);
        req.setAttribute("staffs", staffs);
        req.setAttribute("errors", errors);
        System.out.println("staffs: " + staffs);
        System.out.println("errors: " + errors);


        // JSPに遷移
        req.getRequestDispatcher("staff_list.jsp").forward(req, res);
    }
}
