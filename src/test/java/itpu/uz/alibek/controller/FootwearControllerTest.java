package itpu.uz.alibek.controller;

import itpu.uz.alibek.criteria.AllCriteria;
import itpu.uz.alibek.criteria.ColorEquals;
import itpu.uz.alibek.criteria.FootwearCriteria;
import itpu.uz.alibek.criteria.PriceRange;
import itpu.uz.alibek.entity.Footwear;
import itpu.uz.alibek.service.ProductService;
import itpu.uz.alibek.service.ServiceFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootwearControllerTest {

    @Test
    void shouldListAllFootwearThroughController() throws Exception {
        ProductService<Footwear> service = ServiceFactory.getService(Footwear.class);
        ProductController<Footwear> controller = new ProductControllerImpl<>(service);

        List<Footwear> res = controller.listAll();

        assertEquals(3, res.size());
    }

    @Test
    void shouldFindFootwearByCriteriaThroughController() throws Exception {
        ProductService<Footwear> service = ServiceFactory.getService(Footwear.class);
        ProductController<Footwear> controller = new ProductControllerImpl<>(service);
        var criteria = AllCriteria.of(
                new FootwearCriteria(42, "sneakers"),
                new ColorEquals("White"),
                new PriceRange(100, 130)
        );

        List<Footwear> res = controller.find(criteria);

        assertEquals(1, res.size());
        assertEquals("Runner One", res.get(0).getName());
    }

    @Test
    void shouldCalculateTotalCostForFootwearThroughController() throws Exception {
        ProductService<Footwear> service = ServiceFactory.getService(Footwear.class);
        ProductController<Footwear> controller = new ProductControllerImpl<>(service);

        double total = controller.totalCost(null);

        assertEquals(129.00 + 189.00 + 79.00, total, 0.0001);
    }
}
