package itpu.uz.alibek.service;

import itpu.uz.alibek.criteria.AllCriteria;
import itpu.uz.alibek.criteria.ApparelCriteria;
import itpu.uz.alibek.criteria.ColorEquals;
import itpu.uz.alibek.criteria.PriceRange;
import itpu.uz.alibek.dao.ApparelCsvDAO;
import itpu.uz.alibek.entity.Apparel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApparelServiceTest {

    @Test
    void shouldLoadAllApparelThroughService() throws Exception {
        ProductService<Apparel> service = new CsvProductService<>(new ApparelCsvDAO());

        List<Apparel> res = service.findAll();

        assertEquals(4, res.size());
        assertEquals("Basic Tee", res.get(0).getName());
    }

    @Test
    void shouldFilterByCategorySizePriceAndColorThroughService() throws Exception {
        ProductService<Apparel> service = new CsvProductService<>(new ApparelCsvDAO());
        var criteria = AllCriteria.of(
                new ApparelCriteria("L", "hoodie", null),
                new PriceRange(50, 60),
                new ColorEquals("Blue")
        );

        List<Apparel> res = service.find(criteria);

        assertEquals(1, res.size());
        assertEquals("Warm Hoodie", res.get(0).getName());
    }

    @Test
    void shouldCalculateTotalCostForAllApparel() throws Exception {
        ProductService<Apparel> service = new CsvProductService<>(new ApparelCsvDAO());

        double total = service.totalCost(null);

        assertEquals(9.99 + 59.90 + 79.00 + 29.90, total, 0.0001);
    }
}
