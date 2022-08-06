package com.beesan.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.beesan.consumingwebservice.wsdl.GetPatientInfoRequest;
import com.beesan.consumingwebservice.wsdl.GetPatientInfoResponse;

public class PatientClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(PatientClient.class);

	public GetPatientInfoResponse getPatient(String id) {

		GetPatientInfoRequest request = new GetPatientInfoRequest();
		request.setID(id);

		log.info("Requesting Patient information for " + id);

		GetPatientInfoResponse response = (GetPatientInfoResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/patient", request,
				new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetPatientInfoRequest"));

		return response;
	}

}