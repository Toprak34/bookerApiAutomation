package models.create;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBooking{

	@Builder.Default
	private String firstname = "Fatih";

	@Builder.Default
	private String lastname = "Yılmaz";

	@Builder.Default
	private String additionalneeds = "Breakfast";

	@Builder.Default
	private Bookingdates bookingdates = Bookingdates.builder().build();

	@Builder.Default
	private int totalprice = 1234;

	@Builder.Default
	private boolean depositpaid = true;

}