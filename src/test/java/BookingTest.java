
import io.restassured.response.Response;
import models.GetToken;
import models.create.CreateBooking;
import models.response.BookerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BookerService;


import static verification.RequestSpec.requestSpecification;
import static verification.ResponseSpec.statusCodeCreated;
import static verification.ResponseSpec.statusCodeOk;

public class BookingTest {

    BookerService bookerService = new BookerService();

    @Test(priority = 1)
    public void createTokenTest(){
        GetToken getToken = GetToken.builder().build();
        Response response = bookerService.createToken(getToken, requestSpecification());
        String token = response.path("token");
        System.out.println(token);

    }

    @Test(priority = 2)
    public void createBookingTest(){
        CreateBooking createBooking = CreateBooking.builder().build();
        Response response = bookerService.createBooking(createBooking, requestSpecification(), statusCodeOk());
        System.out.println(response.asPrettyString());

    }

    @Test(priority = 3)
    public void createAndDeleteBookingTest(){
        String token = bookerService.createTokenAndGetToken(requestSpecification());

        Integer bookingId = bookerService.createBookingAndGetId(requestSpecification());
        System.out.println(bookingId);

        Response response = bookerService.deleteBooking(bookingId, token, requestSpecification(), statusCodeCreated());
        System.out.println(response.statusCode());

        Assert.assertEquals(response.asPrettyString(), "Created");



    }
    @Test(priority = 4)
    public void assertRequestAndResponseData(){
        String firstname = "Hamza";
        String lastname = "Gök";
        CreateBooking createBooking = CreateBooking.builder()
                .firstname(firstname)
                .lastname(lastname)
                .build();
        BookerResponse bookerResponse = bookerService.createBooking(createBooking, requestSpecification(), statusCodeOk()).as(BookerResponse.class);
        Assert.assertEquals(bookerResponse.getBooking().getFirstname(), firstname);
        Assert.assertEquals(bookerResponse.getBooking().getLastname(), lastname);


    }
}
