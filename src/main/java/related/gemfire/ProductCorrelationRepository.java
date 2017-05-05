package related.gemfire;

import org.springframework.data.gemfire.repository.GemfireRepository;
import related.model.ProductCorrelation;

public interface ProductCorrelationRepository extends GemfireRepository<ProductCorrelation, String> {}