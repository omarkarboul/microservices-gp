package fr.gopartner.personservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "carservice", url = "http://localhost:8085/car/")
public interface CarServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/retrieve-cars-by-person/{person-id}")
    List<Car> getCars(@PathVariable("person-id") int personId);

}
