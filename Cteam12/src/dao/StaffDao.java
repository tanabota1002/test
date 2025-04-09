package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Staff;

public class StaffDao extends Dao {

    public Staff login(Integer staffId, String password) throws Exception {
        Staff staff = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                 "SELECT * FROM Staff WHERE StaffId = ? AND password = ?")) {

            statement.setInt(1, staffId);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    staff = new Staff();
                    staff.setStaffID(resultSet.getInt("staffId"));
                    staff.setStaffName(resultSet.getString("staffname"));
                    staff.setPassword(resultSet.getString("password"));
                    staff.setStaffRole(resultSet.getString("staffrole"));
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error in login: " + e.getMessage());
            throw new Exception("データベース操作中にエラーが発生しました。", e);
        }

        return staff;
    }

    public List<Staff> filterStaff(int staffId, String staffname, String staffrole) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Staff WHERE 1=1");

        if (staffId > 0) sql.append(" AND StaffId = ?");
        if (staffname != null && !staffname.isEmpty()) sql.append(" AND staffname LIKE ?");
        if (staffrole != null && !staffrole.isEmpty()) sql.append(" AND staffrole LIKE ?");

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {

            int index = 1;
            if (staffId > 0) statement.setInt(index++, staffId);
            if (staffname != null && !staffname.isEmpty()) statement.setString(index++, "%" + staffname + "%");
            if (staffrole != null && !staffrole.isEmpty()) statement.setString(index++, "%" + staffrole + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setStaffID(resultSet.getInt("staffId"));
                    staff.setStaffName(resultSet.getString("staffname"));
                    staff.setStaffRole(resultSet.getString("staffrole"));
                    staffList.add(staff);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error in filterStaff: " + e.getMessage());
            throw new Exception("データベース操作中にエラーが発生しました。", e);
        }

        return staffList;
    }
}
