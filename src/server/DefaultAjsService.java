package server;

import javax.jws.WebService;

@WebService(endpointInterface = "server.AjsPort", targetNamespace = "http://localhost:8080/ajs?wsdl", serviceName = "AjsService", portName = "AjsPort", wsdlLocation = "./ajs.wsdl")

public class DefaultAjsService {

	public CreateUserResponse createUser(CreateUserRequest request) {
		CreateUserResponse response = Factory.INSTANCE.getUserDao().addUser(request);

		return response;
	}

}
