package server;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum Factory {
	INSTANCE;

	private JdbcTemplate jdbcTemplate;

	private UserDao userDao;

	private Factory() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("ajs");
		dataSource.setPassword("ajsajspinguin");
		dataSource.setURL("jdbc:mysql://localhost/ajs?serverTimezone=UTC");

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new MysqlUserDao(jdbcTemplate);
		}
		return userDao;
	}
}
