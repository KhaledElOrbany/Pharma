package eg.pharma.api.features.address.city;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
}
