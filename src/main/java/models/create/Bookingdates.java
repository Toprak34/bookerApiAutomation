package models.create;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bookingdates{

	@Builder.Default
	private String checkin = "2018-01-01";

	@Builder.Default
	private String checkout = "2019-01-01";
}