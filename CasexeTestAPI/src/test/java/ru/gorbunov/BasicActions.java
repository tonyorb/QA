package ru.gorbunov;

import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicActions {	
	
	public String GetGuestToken() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("grant_type", "client_credentials");
        requestBody.put("scope", "guest:default");

        RequestSpecification request = RestAssured.given().log().method().log().uri().log().body();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        
        Response response = request
            .auth().preemptive().basic(Config.basicAuthUserName, "")
            .when().post(Config.url+"/v2/oauth2/token");	
        Assert.assertEquals("Код ответа не 200", 200, response.getStatusCode());
		ResponseLog(response);
		return response.jsonPath().getString("access_token");		
	}
	public Player RegisterANewRandomPlayer(String AccessToken){
		
		Player randomPlayer = new Player();
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", randomPlayer.userName);
        requestBody.put("password_change", randomPlayer.userPassword);
        requestBody.put("password_repeat", randomPlayer.userPassword);
        requestBody.put("email", randomPlayer.userEmail);
        RequestSpecification request = RestAssured.given().log().method().log().uri().log().body();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        
        Response response = request
            .auth().oauth2(AccessToken)
            .when().post(Config.url+"/v2/players");
        Assert.assertEquals("Код ответа не 201", 201, response.getStatusCode());
		PlayerInfoFormatCheck(response);
        randomPlayer.userId = response.jsonPath().getString("id");
		ResponseLog(response);
        return randomPlayer;
	}
	public String PlayerAuth(String username, String password) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("grant_type", "password");
        requestBody.put("username", username);
        requestBody.put("password", password);

        RequestSpecification request = RestAssured.given().log().method().log().uri().log().body();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        
        Response response = request
            .auth().preemptive().basic(Config.basicAuthUserName, "")
            .when().post(Config.url+"/v2/oauth2/token");	
        Assert.assertEquals("Код ответа не 200", 200, response.getStatusCode());
		ResponseLog(response);
		return response.jsonPath().getString("access_token");	
	}
	public void GetPlayerProfile(String userId, String AccessToken) {
		Response response = RestAssured.given().log().method().log().uri()
				.auth().oauth2(AccessToken)
	            .when().get(Config.url+"/v2/players/"+userId);	
		Assert.assertEquals("Код ответа не 200", 200, response.getStatusCode());
		PlayerInfoFormatCheck(response);
		ResponseLog(response);
	};
	public void GetAnotherPlayerProfile(String userId, String AccessToken) {
		Response response = RestAssured.given().log().method().log().uri()
				.auth().oauth2(AccessToken)
	            .when().get(Config.url+"/v2/players/"+userId);	
		ResponseLog(response);
		Assert.assertEquals("Код ответа не 404", 404, response.getStatusCode());
	};
	public String UserIdChange (String UserId) {
		int i = Integer.parseInt(UserId);
		i--;
		return Integer.toString(i);
	}
	public void ResponseLog(Response response) {
		System.out.println("RESPONSE:\n"+response.statusLine());
		response.prettyPrint();
	}
	public void PlayerInfoFormatCheck (Response response) {
        JSONObject responceBody = new JSONObject(response.getBody().asString());
        Assert.assertTrue("Формат ответа неверный", responceBody.has("id")&&
						        					responceBody.has("country_id")&&
						        					responceBody.has("timezone_id")&&
						        					responceBody.has("username")&&
						        					responceBody.has("email")&&
						        					responceBody.has("name")&&
						        					responceBody.has("surname")&&
						        					responceBody.has("gender")&&
						        					responceBody.has("phone_number")&&
						        					responceBody.has("birthdate")&&
						        					responceBody.has("bonuses_allowed")&&
						        					responceBody.has("is_verified"));		
	}
}
