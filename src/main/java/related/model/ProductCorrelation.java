package related.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.List;

@Region("correlation")
public class ProductCorrelation implements Serializable {
    @Id
    public String productId;
    public List<RelatedProduct> relatedProducts;

    @PersistenceConstructor
    public ProductCorrelation(String productId, List<RelatedProduct> relatedProducts) {
        this.productId = productId;
        this.relatedProducts = relatedProducts;
    }

    public String getProductId() { return  productId; }
    public void setProductId(String id) { this.productId = id; }

    public List<RelatedProduct> getRelatedProducts() { return relatedProducts; }
    public void setRelatedProducts(List<RelatedProduct> relatedProducts) { this.relatedProducts = relatedProducts; }
}

