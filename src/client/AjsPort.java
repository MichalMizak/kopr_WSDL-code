
package client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AjsPort", targetNamespace = "http://localhost:8080/ajs?wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AjsPort {


    /**
     * 
     * @param parameters
     * @return
     *     returns client.CreateUserResponse
     */
    @WebMethod(action = "http://localhost:8080/ajs?wsdl/createUser")
    @WebResult(name = "createUserResponse", targetNamespace = "urn:X-kopr", partName = "parameters")
    public CreateUserResponse createUser(
        @WebParam(name = "createUserRequest", targetNamespace = "urn:X-kopr", partName = "parameters")
        CreateUserRequest parameters);

}