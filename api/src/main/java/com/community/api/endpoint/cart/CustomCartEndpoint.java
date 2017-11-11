package com.community.api.endpoint.cart;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broadleafcommerce.rest.api.endpoint.order.CartEndpoint;
import com.broadleafcommerce.rest.api.wrapper.OrderWrapper;

import javax.servlet.http.HttpServletRequest;


/**
 * This is a reference REST API endpoint for cart. This can be modified, used as is, or removed. 
 * The purpose is to provide an out of the box RESTful cart service implementation, but also 
 * to allow the implementor to have fine control over the actual API, URIs, and general JAX-RS annotations.
 * 
 * @author Kelly Tisdell
 *
 */
@RestController
@RequestMapping(value = "/cart",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CustomCartEndpoint extends CartEndpoint {

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public OrderWrapper findCartForCustomer(HttpServletRequest request) {
        try {
            return super.findCartForCustomer(request);
        } catch (Exception e) {
            // if we failed to find the cart, create a new one
            return createNewCartForCustomer(request);
        }
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public OrderWrapper createNewCartForCustomer(HttpServletRequest request) {
        return super.createNewCartForCustomer(request);
    }
}
