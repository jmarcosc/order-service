package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/hal+json")
public class OrderController {

    List<Order> orders = new ArrayList<>();

    @GetMapping("/findById/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") String orderId){

        Order order = null;

        try {
            for (Order o: orders) {
                if(o.getOrderId().equals(orderId)) {
                    order = o;
                }
            }
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Order> postOrder(@RequestBody Order order){

        try {
            order.setOrderId(UUID.randomUUID().toString());
            orders.add(order);

            URI location = ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/{orderId}").
                    buildAndExpand(order.getOrderId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") String orderId, @RequestBody Order order){

        try {
            for (Order o: orders) {
                if(o.getOrderId().equals(orderId)) {
                    orders.remove(o);
                    orders.add(order);
                }
            }
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable("orderId") String orderId){

        try {
            orders.removeIf(order -> order.getOrderId().equals(orderId));
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
