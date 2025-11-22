package itpu.uz.alibek.service;

import itpu.uz.alibek.criteria.AllCriteria;
import itpu.uz.alibek.criteria.ColorEquals;
import itpu.uz.alibek.criteria.FootwearCriteria;
import itpu.uz.alibek.criteria.PriceRange;
import itpu.uz.alibek.dao.FootwearCsvDAO;
import itpu.uz.alibek.entity.Footwear;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootwearServiceTest {

    @Test
    void shouldLoadAllFootwearThroughService() throws Exception {
        ProductService<Footwear> service = new CsvProductService<>(new FootwearCsvDAO());

        List<Footwear> res = service.findAll();

        assertEquals(3, res.size());
        assertEquals("Runner One", res.get(0).getName());
    }

    @Test
    void shouldFilterByTypeSizeColorAndPriceThroughService() throws Exception {
        ProductService<Footwear> service = new CsvProductService<>(new FootwearCsvDAO());
        var criteria = AllCriteria.of(
                new FootwearCriteria(42, "sneakers"),
                new ColorEquals("White"),
                new PriceRange(100, 130)
        );

        List<Footwear> res = service.find(criteria);

        assertEquals(1, res.size());
        assertEquals("Runner One", res.get(0).getName());
    }

    @Test
    void shouldCalculateTotalCostForAllFootwear() throws Exception {
        ProductService<Footwear> service = new CsvProductService<>(new FootwearCsvDAO());

        double total = service.totalCost(null);

        assertEquals(129.00 + 189.00 + 79.00, total, 0.0001);
    }
}
