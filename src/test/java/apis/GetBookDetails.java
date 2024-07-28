package apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojo.Docs;
import pojo.Movies;

public class GetBookDetails {
	private static final int STATUS_CODE_OK = 200;
	private static final int STATUS_CODE_UNAUTHORIZED = 401;
	private static final String BASE_URI = "https://the-one-api.dev";
	private static final String BEARER_TOKEN = "mNiH3IXLzRDQMkZerXXu";
	private Movies movie;
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = BASE_URI;
	}

	@Test
	public void testGetBookAPI() {
		String getBookResponse = given().when().get("/v2/book").then().statusCode(304).extract().response().asString();
		JsonPath js = new JsonPath(getBookResponse);
		int actualBookCount = js.getList("docs").size();
		int totalBookCount = js.getInt("total");
		Assert.assertEquals(totalBookCount, actualBookCount);
	}

	@Test
	public void testMovieAPI() {
		String getMovieResponse = given().when().get("/v2/movie").then().statusCode(STATUS_CODE_UNAUTHORIZED).extract()
				.response().asString();
		JsonPath js = new JsonPath(getMovieResponse);
		Assert.assertEquals(false, js.getBoolean("success"));
		Assert.assertEquals("Unauthorized.", js.getString("message"));

	}

	@Test
	public void testMovieAPIWithAuth() {

		Response getMovieResponse = given().header("Authorization", "Bearer " + BEARER_TOKEN).when().get("/v2/movie")
				.then().extract().response();

		movie = getMovieResponse.as(Movies.class);
		Assert.assertEquals(STATUS_CODE_OK, getMovieResponse.statusCode());
		Assert.assertEquals(movie.getTotal(), movie.getDocs().size());

	}

	@Test(description = "Get quote of movies", dependsOnMethods = "testMovieAPIWithAuth")

	public void getMovieQuotes() {

		List<Docs> dc = movie.getDocs();

		for (Docs movieList : dc) {
//			String movieId=movieList.get_id();
			testResponse(movieList.get_id());

		}
		softAssert.assertAll();
	}

	public void testResponse(String ID) {
		String movieId = ID;
		Map<String, String> pathParams = new HashMap<>();
		pathParams.put("ID", movieId);
		String response = given().header("Authorization", "Bearer " + BEARER_TOKEN).pathParams(pathParams).when()
				.get("/v2/movie/{ID}/quote").then().statusCode(STATUS_CODE_OK).extract().asString();

		JsonPath js1 = new JsonPath(response);
		int total = js1.getInt("total");
		int totalQuotes = js1.getList("docs").size();
		
		softAssert.assertEquals(total, totalQuotes,"Mismatch in total and number of quotes for movie ID: " + ID);
		Reporter.log("ID: "+ID+" Total records"+total+" Total Quotes"+totalQuotes);
		System.out.println("ID: "+ID+" Total records"+total+" Total Quotes"+totalQuotes);
	}

}
