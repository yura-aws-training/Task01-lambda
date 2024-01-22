package com.Task01;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.LambdaUrlConfig;
import com.syndicate.deployment.model.lambda.url.AuthType;
import com.syndicate.deployment.model.lambda.url.InvokeMode;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@LambdaHandler(lambdaName = "hello_world",
	roleName = "DemoLambda-role",
	isPublishVersion = true
	
)
@LambdaUrlConfig(
authType = AuthType.NONE,
invokeMode = InvokeMode.BUFFERED
)
public class Demolambda implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	private final Gson gson = new Gson();

	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
		System.out.println("Hello from lambda");
		Map<String, Object> resultMap = new HashMap<String, Object>();


	//	resultMap.put("statusCode", "200");
		Body body = new Body();
		body.statusCode = 200;
		body.message = "Hello from Lambda";

	//	resultMap.put("body", body);
	////	resultMap.put("statusCode","200");
	////	resultMap.put("message","Hello from Lambda");
	//	return resultMap;

	return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(gson.toJson(body));
	}
}

class Body {
	public int statusCode;
	public String message;
}



