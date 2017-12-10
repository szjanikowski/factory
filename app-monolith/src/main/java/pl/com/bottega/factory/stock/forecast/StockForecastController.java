package pl.com.bottega.factory.stock.forecast;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.com.bottega.factory.product.management.RefNoId;

@Controller
@RequestMapping("stock-forecasts")
@AllArgsConstructor
class StockForecastController {

    private final StockForecastQuery query;

    @RequestMapping(value = "search/refNos", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    ResponseEntity<StockForecast> get(@RequestParam String refNo) {
        return ResponseEntity.ok(query.get(new RefNoId(refNo)));
    }
}