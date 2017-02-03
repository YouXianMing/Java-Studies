package com.Techcode;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.RootModel;
import com.google.gson.Gson;

import personal.YouXianMing.File.TextFile;
import personal.YouXianMing.SQL.AbsSQLManager;
import personal.YouXianMing.SQL.MySQLManager;
import personal.YouXianMing.SQL.SQLiteManager;
import personal.YouXianMing.SQL.AbsSQLManager.SQLManagerRunnableInterface;

public class Application {

	public static void main(String args[]) {

		testSQLite();
		testMySQL();
		testGSON();
	}

	public static void testSQLite() {

		// 创建数据库对象
		SQLiteManager manager = new SQLiteManager("SQLite.db");

		// 判断能否加载数据库类
		if (manager.loadDriverSuccess()) {

			// 开始连接数据库并将自动提交设置成关闭
			if (manager.startConnect() && manager.setAutoCommit(false)) {

				System.out.println("Connect SQLite success!");

				// 执行操作
				manager.commitAndExecute(new SQLManagerRunnableInterface() {

					@Override
					public void block(AbsSQLManager mySQLManager) {

						mySQLManager.executeUpdate(
								"CREATE TABLE IF NOT EXISTS UserInfoTable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, height REAL, ext BLOB);");
						mySQLManager.executeUpdate(
								"INSERT INTO UserInfoTable (name, age, height) VALUES ('YouXianMing', '18', '170.0');");
						ResultSet set = mySQLManager.executeQuery("SELECT * FROM UserInfoTable");

						if (set != null) {

							try {

								while (set.next()) {

									String name = set.getString("name");
									System.out.println(name);
								}

							} catch (SQLException e) {

								e.printStackTrace();
							}
						}
					}
				});

				// 断开连接数据库
				if (manager.closeConnect()) {

					System.out.println("Close connect SQLite success!");
				}
			}
		}
	}

	/**
	 * 测试MySQL
	 */
	public static void testMySQL() {

		String url = "jdbc:mysql://localhost:3306/MyDataBase"; // 确保有一个MySQL有一个数据库文件是MyDataBase
		String username = "root"; // 替换成你自己的,否则报错
		String password = "Yx********"; // 替换成你自己的,否则报错
		MySQLManager manager = new MySQLManager(username, password, url);

		// 数据库初始化
		if (manager.loadDriverSuccess()) {

			// // 开始连接数据库并将自动提交设置成关闭
			if (manager.startConnect() && manager.setAutoCommit(false)) {

				System.out.println("Connect MySQL success!");

				// 执行操作
				manager.commitAndExecute(new SQLManagerRunnableInterface() {

					@Override
					public void block(AbsSQLManager mySQLManager) {

						ResultSet set = mySQLManager.executeQuery("SELECT * FROM t_Student;");

						if (set != null) {

							try {

								while (set.next()) {

									String name = set.getString("studentName");
									System.out.println(name);
								}
							} catch (SQLException e) {

								e.printStackTrace();
							}
						}
					}
				});

				// 断开连接数据库
				if (manager.closeConnect()) {

					System.out.println("Close connect MySQL success!");
				}
			}
		}
	}

	public static void testGSON() {

		// 读取文件
		String jsonString = TextFile.withFilePath("./data/data.json");

		if (jsonString != null) {

			Gson gson = new Gson();
			RootModel model = gson.fromJson(jsonString, RootModel.class);
			System.out.println(model.getMessage());
			System.out.println(gson.toJson(model));
			
			new Gson();
		}
	}
}
