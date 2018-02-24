package test.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import client.AjsPort;
import client.AjsService;
import client.CreateUserRequest;
import client.CreateUserResponse;
import server.Factory;
import server.UserDao;


/**
 * Client test and usage demonstration. Server must be running for this test to succeed.
 * @author Mikey
 *
 */
class ClientTest {

	@Test
	void test() {

		UserDao dao = Factory.INSTANCE.getUserDao();

		String name = "TESTUJEM";
		String surname = "AJS";

		AjsService service = new AjsService();
		AjsPort port = service.getAjsPort();

		CreateUserRequest request = new CreateUserRequest();
		request.setName(name);
		request.setSurname(surname);

		int beforeInsert = dao.getCount();
		System.out.println("Count before insert: " + beforeInsert);

		CreateUserResponse response = port.createUser(request);

		String uuid = response.getUuid();
		System.out.println("uuid: " + uuid);

		System.out.println("Count after insert: " + dao.getCount());

		dao.delete(uuid);

		int afterCleanup = dao.getCount();

		System.out.println("Count after cleanup: " + afterCleanup);

		if (afterCleanup == beforeInsert) {
			System.out.println("Cleanup successful");
		} else {
			fail("Cleanup unsuccessful");
		}
	}
}