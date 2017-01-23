package personal.YouXianMing.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManager extends AbsSQLManager {

	public SQLiteManager(String url) {

		this.url = String.format("jdbc:sqlite:%s", url);
	}

	@Override
	public boolean startConnect() {

		boolean success = true;

		try {

			this.connection = DriverManager.getConnection(this.url);

		} catch (SQLException e) {

			success = false;
			e.printStackTrace();
		}

		return success;
	}

	@Override
	public boolean loadDriverSuccess() {

		boolean result = true;

		try {

			Class.forName("org.sqlite.JDBC");

		} catch (ClassNotFoundException e) {

			result = false;
			e.printStackTrace();
		}

		return result;
	}
}
