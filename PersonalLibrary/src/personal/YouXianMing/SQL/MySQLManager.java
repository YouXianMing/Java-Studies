package personal.YouXianMing.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager extends AbsSQLManager {

	public MySQLManager(String userName, String password, String url) {

		this.userName = userName;
		this.password = password;
		this.url = url;
	}

	@Override
	public boolean startConnect() {

		boolean result = true;

		try {

			this.connection = DriverManager.getConnection(this.url, this.userName, this.password);

		} catch (SQLException e) {

			result = false;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean loadDriverSuccess() {

		boolean result = true;

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			result = false;
			e.printStackTrace();
		}

		return result;
	}
}
