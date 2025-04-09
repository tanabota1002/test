package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDao extends Dao {



	/**
	 * loginメソッド メールアドレスとパスワードで認証する

	 * @return 認証成功:教員クラスのインスタンス, 認証失敗:null
	 * @throws Exception
	 */
	public User login(String EmailAddress, String password) throws Exception {
		// 教員クラスのインスタンスを取得
		User user = get(EmailAddress);
		// 教員がnullまたはパスワードが一致しない場合
		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}


	public User get(String EmailAddress) throws Exception {
		// 教員インスタンスを初期化
		User user = new User();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from user where EmailAddress=?");
			// プリペアードステートメントにメールアドレスをバインド
			statement.setString(1, EmailAddress);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()) {
				// リザルトセットが存在する場合
				// 利用者インスタンスに検索結果をセット
				user.setEmailAddress(rSet.getString("EmailAddress"));
				user.setPassword(rSet.getString("password"));
				user.setUserID(rSet.getInt("userID"));

			} else {
				// リザルトセットが存在しない場合
				// 利用者インスタンスにnullをセット
				user = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return user;
	}


}
