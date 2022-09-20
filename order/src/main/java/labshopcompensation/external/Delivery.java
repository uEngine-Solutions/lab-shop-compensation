package labshopcompensation.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long id;
    private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;
}


