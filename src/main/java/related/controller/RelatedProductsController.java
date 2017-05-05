package related.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import related.gemfire.ProductCorrelationRepository;
import related.model.ProductCorrelation;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class RelatedProductsController {
    @Autowired
    ProductCorrelationRepository repository;

    @RequestMapping("/products/{id}/related")
    public ProductCorrelation relatedProducts(@PathVariable("id") String id) {
        ProductCorrelation correlation = repository.findOne(id);
        correlation.relatedProducts.sort((p1, p2) -> new Double(p2.getCorrelationScore()).compareTo(p1.getCorrelationScore()));

        return correlation;
    }
}
