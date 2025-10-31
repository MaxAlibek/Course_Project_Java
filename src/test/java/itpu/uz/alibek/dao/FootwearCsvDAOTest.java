
package itpu.uz.alibek.dao;

import org.junit.jupiter.api.Test;
import itpu.uz.alibek.criteria.*;
import itpu.uz.alibek.entity.Footwear;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FootwearCsvDAOTest {

    @Test
    void shouldLoadAllFootwear() throws Exception {
        var dao = new FootwearCsvDAO();
        List<Footwear> all = dao.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void shouldFilterByTypeSizeColorAndPrice() throws Exception {
        var dao = new FootwearCsvDAO();
        var criteria = AllCriteria.of(
                new FootwearCriteria(42, "sneakers"),
                new ColorEquals("White"),
                new PriceRange(100, 130)
        );
        List<Footwear> res = dao.find(criteria);
        assertEquals(1, res.size());
        assertEquals("Runner One", res.get(0).getName());
    }
}
