package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;

@RestController
public class RelatedProductsController {
    @Autowired
    ProductCorrelationRepository repository;

    @RequestMapping("/products/{id}/related")
    public ProductCorrelation relatedProducts(@PathVariable("id") String id) {
        ProductCorrelation correlation = repository.findByProductId(id);

        Collections.sort(correlation.relatedProducts,
                (p1, p2) -> new Double(p2.getCorrelationScore()).compareTo(p1.getCorrelationScore()));

        return repository.findByProductId(id);
    }
}
