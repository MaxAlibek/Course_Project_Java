
package itpu.uz.alibek.dao;

import org.junit.jupiter.api.Test;
import itpu.uz.alibek.criteria.*;
import itpu.uz.alibek.entity.Apparel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApparelCsvDAOTest {

    @Test
    void shouldLoadAllApparel() throws Exception {
        var dao = new ApparelCsvDAO();
        List<Apparel> all = dao.findAll();
        assertEquals(4, all.size());
    }

    @Test
    void shouldFilterByCategorySizeAndPrice() throws Exception {
        var dao = new ApparelCsvDAO();
        var criteria = AllCriteria.of(
                new ApparelCriteria("L", "hoodie", null),
                new PriceRange(50, 60),
                new ColorEquals("Blue")
        );
        List<Apparel> res = dao.find(criteria);
        assertEquals(1, res.size());
        assertEquals("Warm Hoodie", res.get(0).getName());
    }
}
