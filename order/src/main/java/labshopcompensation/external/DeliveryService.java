package labshopcompensation.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "delivery", url = "${api.url.delivery}")
public interface DeliveryService {
    @RequestMapping(method= RequestMethod.POST, path="/deliveries")
    public void removeDelivery(@RequestBody Delivery delivery);
}

