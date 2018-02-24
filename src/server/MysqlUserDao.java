package server;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlUserDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public MysqlUserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public CreateUserResponse addUser(CreateUserRequest request) {
		String name = request.getName();
		String surname = request.getSurname();

		CreateUserResponse response = new CreateUserResponse();

		String uuid = UUID.randomUUID().toString();
		response.setUuid(uuid);

		String sql = "INSERT into user values (?, ?, ?)";

		Object[] args = new Object[] { uuid, name, surname };

		jdbcTemplate.update(sql, args);

		return response;
	}

	@Override
	public void delete(String uuid) {
		String sql = "DELETE from user where uuid = ?";
		jdbcTemplate.update(sql, new Object[] { uuid });

	}
	
	@Override
	public int getCount() {
		String sql = "SELECT count(*) from user";
		return jdbcTemplate.queryForInt(sql);
	}
}
