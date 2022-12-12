package com.api.test;

import org.testng.annotations.Test;

import com.vtiger.pages.APIpage;
import com.vtiger.tests.Basetest;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest. Matchers.*;
import org.json.simple.JSONObject;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITEST extends  Basetest{
	@Test
	public void Test_ListUser01()
	{
		String TCName = "Test_ListUser01";
		logger = extent.createTest(TCName);
		APIpage api=new APIpage(logger);
        String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
         Response resp=RestAssured.get(Endpoint);
         api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());
         api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

         String json=resp.body().asPrettyString();
         JsonPath jsonpath=new JsonPath(json);
         String page=jsonpath.getString("page");
         System.out.println(page);
          api.VarifyJsonResponce(TestData.get(TCName).get("page"), page);
          api.VarifyJsonResponce(TestData.get(TCName).get("email"), jsonpath.getString("data[0].email"));
           extent.flush();


/*
 System.out.println(resp.body().asPrettyString());  //get all 
 System.out.println(resp.getStatusCode()); //200
 System.out.println(resp.getStatusLine()); //HTTP/1.1 200 OK
 //RestAssured.get(Endpoint).then().assertThat().statusLine("HTTP/1.1 200 OK");
 RestAssured.get(Endpoint).then().assertThat().statusLine(TestData.get(TCName).get("StatusLine"));

 System.out.println();
 //validation for insid page "page": 1,
String json=resp.body().asPrettyString();
JsonPath jsonpath=new JsonPath(json);
int page=jsonpath.getInt("page");
System.out.println("page"+page);
System.out.println();
*/


//validation for insid page "per_page": 6,
/*String json2=resp.body().asPrettyString();
JsonPath jsonpath2=new JsonPath(json2);
int page2=jsonpath2.getInt("per_page");
System.out.println("per_page"+page2);

//validation for insid  "data": [
System.out.println(jsonpath2.getString("data[0].email"));
System.out.println(jsonpath2.getString("data[1].email"));
System.out.println(jsonpath2.getString("data[2].email"));
extent.flush();
*/

}
	@Test
	public void Test_SingleUser02()
	{
		String TCName ="Test_SingleUser02";
		logger = extent.createTest(TCName);
		APIpage api=new APIpage(logger);
        String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
         Response resp=RestAssured.get(Endpoint);
         api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());
         api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());

         String json=resp.body().asPrettyString();
         JsonPath jsonpath=new JsonPath(json);
         String id=jsonpath.getString("data.id");
         System.out.println(id+" id is here here");
          api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("data.id"));
          api.VarifyJsonResponce(TestData.get(TCName).get("email"), jsonpath.getString("data.email"));
          api.VarifyJsonResponce(TestData.get(TCName).get("first_name"), jsonpath.getString("data.first_name"));
          api.VarifyJsonResponce(TestData.get(TCName).get("last_name"), jsonpath.getString("data.last_name"));

          extent.flush();
}
	@Test
	public void Test_CreatUsers03()
	{
		String TCName ="Test_CreatUsers03";
		logger = extent.createTest(TCName);
		APIpage api=new APIpage(logger);
        String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
         Map<String,Object> map=new HashMap<String,Object>();
         map.put("name", TestData.get(TCName).get("name"));
         map.put("job", TestData.get(TCName).get("job"));
         JSONObject json=new JSONObject(map);
         RequestSpecification rs=RestAssured.given();
        rs.header("Content-Type","application/json");
        rs.body(json.toString());
        logger.info("Request="+json.toString());
        
        Response resp=rs.post(Endpoint);
        logger.info("Post Url"+Endpoint);
        String body=resp.getBody().asString();
        api.WriteRequestRsponceinReport(Endpoint, body);
        api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
        String jsn=resp.body().asPrettyString();
        JsonPath jsonpath=new JsonPath(jsn);
       // String id=jsonpath.getString("id");
       // System.out.println(id+" id is here here");
       // api.VarifyJsonResponce(TestData.get(TCName).get("id"), jsonpath.getString("id"));
        api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("name"));
        api.VarifyJsonResponce(TestData.get(TCName).get("job"), jsonpath.getString("job"));
         extent.flush();
}
	@Test
	public void Test_UpdateUsers04()
	{
		String TCName ="Test_UpdateUsers04";
		logger = extent.createTest(TCName);
		APIpage api=new APIpage(logger);
        String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
         Map<String,Object> map=new HashMap<String,Object>();
         map.put("name", TestData.get(TCName).get("name"));
         map.put("job", TestData.get(TCName).get("job"));
         JSONObject json=new JSONObject(map);
         RequestSpecification rs=RestAssured.given();
        rs.header("Content-Type","application/json");
        rs.body(json.toString());
        logger.info("Request="+json.toString());
        
        Response resp=rs.put(Endpoint);
        logger.info("put Url"+Endpoint);
        String body=resp.getBody().asString();
        api.WriteRequestRsponceinReport(Endpoint, body);
        api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
        String jsn=resp.body().asPrettyString();
        JsonPath jsonpath=new JsonPath(jsn);
      
        api.VarifyJsonResponce(TestData.get(TCName).get("name"), jsonpath.getString("name"));
        api.VarifyJsonResponce(TestData.get(TCName).get("job"), jsonpath.getString("job"));
         extent.flush();
}
	@Test
	public void Test_DeleteUser05()
	{
		String TCName ="Test_DeleteUser05";
		logger = extent.createTest(TCName);
		APIpage api=new APIpage(logger);
        String Endpoint=prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
         
        Response resp=RestAssured.delete(Endpoint);
         api.WriteRequestRsponceinReport(Endpoint, resp.body().asPrettyString());
         api.VarifyStatusLine(TestData.get(TCName).get("StatusLine"),resp.getStatusLine());
         System.out.println(resp.getStatusLine());
         String json=resp.body().asPrettyString();
         System.out.println(json);
      
         

          extent.flush();
}
	}
