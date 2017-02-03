package personal.YouXianMing.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import personal.YouXianMing.Debug.DebugMessage;

public abstract class AbsSQLManager {

	/**
	 * 用于执行代码块的接口
	 */
	public interface SQLManagerRunnableInterface {

		void block(AbsSQLManager mySQLManager);
	}

	/**
	 * 用户名
	 */
	public String userName = null;

	/**
	 * 用户密码
	 */
	public String password = null;

	/**
	 * 数据库地址
	 */
	public String url = null;

	/**
	 * A connection (session) with a specific database. SQL statements are
	 * executed and results are returned within the context of a connection.
	 */
	protected Connection connection = null;

	/**
	 * The object used for executing a static SQL statement and returning the
	 * results it produces.
	 */
	protected Statement statement = null;

	/**
	 * 加载Driver是否成功
	 * 
	 * @return 成功或者失败
	 */
	abstract public boolean loadDriverSuccess();

	/**
	 * 设置是否自动提交
	 * 
	 * @param autoCommit
	 *            是否自动提交
	 * @return 设置成功或者失败
	 */
	public boolean setAutoCommit(boolean autoCommit) {

		boolean success = true;

		if (this.connection != null) {

			try {

				this.connection.setAutoCommit(autoCommit);

			} catch (SQLException e) {

				success = false;
				e.printStackTrace();
			}

		} else {

			success = false;
			DebugMessage.output(DebugMessage.stack(), "The connection is null.");
		}

		return success;
	}

	/**
	 * 开始连接数据库(可以被重写)
	 * 
	 * @return 连接成功或者失败
	 */
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

	/**
	 * 断开连接
	 * 
	 * @return 成功或者失败
	 */
	public boolean closeConnect() {

		boolean result = true;

		if (this.connection != null) {

			try {

				this.connection.close();

			} catch (SQLException e) {

				result = false;
				e.printStackTrace();
			}

		} else {

			result = false;
			DebugMessage.output(DebugMessage.stack(), "The connection is null.");
		}

		return result;
	}

	/**
	 * 创建会话
	 * 
	 * @return 成功或者失败
	 */
	public boolean createStatement() {

		boolean result = true;

		if (this.connection != null) {

			try {

				this.statement = this.connection.createStatement();

			} catch (SQLException e) {

				result = false;
				e.printStackTrace();
			}

		} else {

			result = false;
			DebugMessage.output(DebugMessage.stack(), "The connection is null.");
		}

		return result;
	}

	/**
	 * 关闭会话
	 * 
	 * @return 成功或者失败
	 */
	public boolean closeStatement() {

		boolean result = true;

		if (this.statement != null) {

			try {

				this.statement.close();

			} catch (SQLException e) {

				result = false;
				e.printStackTrace();
			}

		} else {

			result = false;
			DebugMessage.output(DebugMessage.stack(), "The connection is null.");
		}

		return result;
	}

	/**
	 * 提交会话
	 * 
	 * @return 成功或者失败
	 */
	public boolean commitStatement() {

		boolean success = true;

		if (this.connection != null) {

			try {

				this.connection.commit();

			} catch (SQLException e) {

				success = false;
				e.printStackTrace();
			}

		} else {

			success = false;
			DebugMessage.output(DebugMessage.stack(), "The connection is null.");
		}

		return success;
	}

	/**
	 * 执行查询
	 * 
	 * @param sql
	 *            sql语句
	 * @return 成功或者失败
	 */
	public ResultSet executeQuery(String sql) {

		ResultSet set = null;

		if (this.statement != null) {

			try {

				set = this.statement.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return set;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param sql
	 *            sql语句
	 * @return 成功或者失败
	 */
	public boolean executeUpdate(String sql) {

		boolean executeSuccess = false;

		if (this.statement != null) {

			try {

				executeSuccess = this.statement.execute(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return executeSuccess;
	}

	/**
	 * 提交以及执行
	 * 
	 * @param block
	 *            执行用的接口block
	 */
	public void commitAndExecute(SQLManagerRunnableInterface block) {

		if (block != null) {

			if (this.createStatement()) {

				block.block(this);
				this.commitStatement();
			}

		} else {

			DebugMessage.output(DebugMessage.stack(), "The block is null.");
		}
	}
}
