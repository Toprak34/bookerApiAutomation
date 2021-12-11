package verification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;


public class ResponseSpec {

    public static ResponseSpecification statusCodeOk() {
        return new ResponseSpecBuilder().build()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK);
    }

    public static ResponseSpecification statusCodeCreated() {
        return new ResponseSpecBuilder().build()
                .contentType(ContentType.TEXT)
                .statusCode(HttpStatus.SC_CREATED);
    }
}
