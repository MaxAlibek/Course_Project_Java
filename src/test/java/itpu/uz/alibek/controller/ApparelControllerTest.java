package itpu.uz.alibek.controller;

import itpu.uz.alibek.criteria.AllCriteria;
import itpu.uz.alibek.criteria.ApparelCriteria;
import itpu.uz.alibek.criteria.ColorEquals;
import itpu.uz.alibek.criteria.PriceRange;
import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.service.ProductService;
import itpu.uz.alibek.service.ServiceFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApparelControllerTest {

    @Test
    void shouldListAllApparelThroughController() throws Exception {
        ProductService<Apparel> service = ServiceFactory.getService(Apparel.class);
        ProductController<Apparel> controller = new ProductControllerImpl<>(service);

        List<Apparel> res = controller.listAll();

        assertEquals(4, res.size());
    }

    @Test
    void shouldFindApparelByCriteriaThroughController() throws Exception {
        ProductService<Apparel> service = ServiceFactory.getService(Apparel.class);
        ProductController<Apparel> controller = new ProductControllerImpl<>(service);
        var criteria = AllCriteria.of(
                new ApparelCriteria("L", "hoodie", null),
                new PriceRange(50, 60),
                new ColorEquals("Blue")
        );

        List<Apparel> res = controller.find(criteria);

        assertEquals(1, res.size());
        assertEquals("Warm Hoodie", res.get(0).getName());
    }

    @Test
    void shouldCalculateTotalCostThroughController() throws Exception {
        ProductService<Apparel> service = ServiceFactory.getService(Apparel.class);
        ProductController<Apparel> controller = new ProductControllerImpl<>(service);

        double total = controller.totalCost(null);

        assertEquals(9.99 + 59.90 + 79.00 + 29.90, total, 0.0001);
    }
}
