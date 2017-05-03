package hello;

import org.springframework.data.repository.CrudRepository;

public interface ProductCorrelationRepository extends CrudRepository<ProductCorrelation, String> {
    ProductCorrelation findByProductId(String productId);
}