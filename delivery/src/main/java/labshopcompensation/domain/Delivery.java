package labshopcompensation.domain;

import labshopcompensation.domain.DeliveryStarted;
import labshopcompensation.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Integer quantity;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }

<<<<<<< HEAD
    public static void addToDeliveryList(OrderPlaced orderPlaced) {
        /** Example 1:  new item  */
=======



    public static void addToDeliveryList(OrderPlaced orderPlaced){

        /** Example 1:  new item 
>>>>>>> origin/template
        Delivery delivery = new Delivery();

        delivery.setOrderId(orderPlaced.getId());
        delivery.setCustomerId(orderPlaced.getCustomerId());
        delivery.setQuantity(orderPlaced.getQty());
        delivery.setAddress(orderPlaced.getAddress());
        
        repository().save(delivery);

       

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void removeDelivery(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
