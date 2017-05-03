package hello;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    ProductCorrelationRepository repository;

    final String product0 = "WH662";
    final String product1 = "FS145";
    final String product2 = "FB123";
    final String product3 = "RF123";
    final String product4 = "CH166";
    final String product5 = "SE995";
    final String product6 = "EX445";
    final String product7 = "FF223";
    final String product8 = "AB122";
    final String product9 = "PW667";

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        saveProduct0();
        saveProduct1();
        saveProduct2();
        saveProduct3();
        saveProduct4();
        saveProduct5();
        saveProduct6();
        saveProduct7();
        saveProduct8();
        saveProduct9();
    }

    private void saveProduct0() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product1, 0.87968));
        relatedProducts.add(new RelatedProduct(product4, 0.87943));
        relatedProducts.add(new RelatedProduct(product5, 0.83816));
        relatedProducts.add(new RelatedProduct(product7, 0.99827));
        relatedProducts.add(new RelatedProduct(product9, 0.82122));

        repository.save(new ProductCorrelation(product0, relatedProducts));
    }

    private void saveProduct1() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product0, 0.87968));
        relatedProducts.add(new RelatedProduct(product4, 0.84286));
        relatedProducts.add(new RelatedProduct(product9, 0.54889));

        repository.save(new ProductCorrelation(product1, relatedProducts));
    }


    private void saveProduct2() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product1, 0.51217));
        relatedProducts.add(new RelatedProduct(product3, 0.73811));
        relatedProducts.add(new RelatedProduct(product5, 0.63173));
        relatedProducts.add(new RelatedProduct(product7, 0.98786));
        relatedProducts.add(new RelatedProduct(product9, 0.55438));

        repository.save(new ProductCorrelation(product2, relatedProducts));
    }

    private void saveProduct3() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product1, 0.59412));
        relatedProducts.add(new RelatedProduct(product2, 0.73811));
        relatedProducts.add(new RelatedProduct(product4, 0.71059));
        relatedProducts.add(new RelatedProduct(product5, 0.89180));
        relatedProducts.add(new RelatedProduct(product6, 0.55290));
        relatedProducts.add(new RelatedProduct(product7, 0.76189));
        relatedProducts.add(new RelatedProduct(product9, 0.79597));

        repository.save(new ProductCorrelation(product3, relatedProducts));
    }

    private void saveProduct4() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product0, 0.87943));
        relatedProducts.add(new RelatedProduct(product1, 0.84286));
        relatedProducts.add(new RelatedProduct(product3, 0.71059));
        relatedProducts.add(new RelatedProduct(product5, 0.93218));
        relatedProducts.add(new RelatedProduct(product6, 0.68706));
        relatedProducts.add(new RelatedProduct(product7, 0.82405));
        relatedProducts.add(new RelatedProduct(product8, 0.87820));

        repository.save(new ProductCorrelation(product4, relatedProducts));
    }

    private void saveProduct5() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product0, 0.83816));
        relatedProducts.add(new RelatedProduct(product2, 0.63173));
        relatedProducts.add(new RelatedProduct(product3, 0.89180));
        relatedProducts.add(new RelatedProduct(product4, 0.93218));
        relatedProducts.add(new RelatedProduct(product7, 0.54321));
        relatedProducts.add(new RelatedProduct(product8, 0.98292));

        repository.save(new ProductCorrelation(product5, relatedProducts));
    }

    private void saveProduct6() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product3, 0.55290));
        relatedProducts.add(new RelatedProduct(product4, 0.68706));
        relatedProducts.add(new RelatedProduct(product7, 0.85331));
        relatedProducts.add(new RelatedProduct(product9, 0.50542));

        repository.save(new ProductCorrelation(product6, relatedProducts));
    }

    private void saveProduct7() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product0, 0.99827));
        relatedProducts.add(new RelatedProduct(product2, 0.98786));
        relatedProducts.add(new RelatedProduct(product3, 0.76189));
        relatedProducts.add(new RelatedProduct(product4, 0.82405));
        relatedProducts.add(new RelatedProduct(product5, 0.54321));
        relatedProducts.add(new RelatedProduct(product6, 0.85331));
        relatedProducts.add(new RelatedProduct(product8, 0.73034));
        relatedProducts.add(new RelatedProduct(product9, 0.52466));

        repository.save(new ProductCorrelation(product7, relatedProducts));
    }

    private void saveProduct8() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product4, 0.87820));
        relatedProducts.add(new RelatedProduct(product5, 0.98292));
        relatedProducts.add(new RelatedProduct(product7, 0.73034));
        relatedProducts.add(new RelatedProduct(product9, 0.91405));

        repository.save(new ProductCorrelation(product8, relatedProducts));
    }

    private void saveProduct9() {
        List<RelatedProduct> relatedProducts = new ArrayList<>();
        relatedProducts.add(new RelatedProduct(product0, 0.82122));
        relatedProducts.add(new RelatedProduct(product1, 0.54889));
        relatedProducts.add(new RelatedProduct(product2, 0.55438));
        relatedProducts.add(new RelatedProduct(product3, 0.79597));
        relatedProducts.add(new RelatedProduct(product6, 0.50542));
        relatedProducts.add(new RelatedProduct(product7, 0.52466));
        relatedProducts.add(new RelatedProduct(product8, 0.91405));

        repository.save(new ProductCorrelation(product9, relatedProducts));
    }
}
