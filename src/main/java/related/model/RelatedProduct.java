package related.model;

import java.io.Serializable;

public class RelatedProduct implements Serializable {
    public String productId;
    public double correlationScore;

    public RelatedProduct(String productId, double correlationScore) {
        this.productId = productId;
        this.correlationScore = correlationScore;
    }

    public String getProductId() { return  productId; }
    public void setProductId(String id) { this.productId = id; }

    public double getCorrelationScore() { return correlationScore; }
    public void setCorrelationScore(double correlationScore) { this.correlationScore = correlationScore; }
}
