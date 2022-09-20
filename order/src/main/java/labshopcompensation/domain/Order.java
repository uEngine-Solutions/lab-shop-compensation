package labshopcompensation.domain;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshopcompensation.OrderApplication;
=======
>>>>>>> origin/template
import labshopcompensation.domain.OrderPlaced;
import labshopcompensation.domain.OrderCancelled;
import labshopcompensation.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Double amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
        // Get request from Inventory
        labshopcompensation.external.Inventory inventory =
           OrderApplication.applicationContext.getBean(labshopcompensation.external.InventoryService.class)
           .getInventory(Long.valueOf(getProductId()));

        if(inventory.getStock() < getQty())
            throw new RuntimeException("Out of stock!");

    }
    @PreRemove
    public void onPreRemove(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        labshopcompensation.external.Delivery delivery = new labshopcompensation.external.Delivery();
        // mappings goes here
        OrderApplication.applicationContext.getBean(labshopcompensation.external.DeliveryService.class)
            .removeDelivery(delivery);


        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
