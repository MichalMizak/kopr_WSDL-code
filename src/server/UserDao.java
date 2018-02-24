package server;

public interface UserDao {

	CreateUserResponse addUser(CreateUserRequest request);

	void delete(String uuid);
	
	int getCount();
}
