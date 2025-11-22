package itpu.uz.alibek.service;

import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Footwear;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {

    @Test
    void shouldReturnApparelService() {
        ProductService<Apparel> service = ServiceFactory.getService(Apparel.class);
        assertNotNull(service);
    }

    @Test
    void shouldReturnFootwearService() {
        ProductService<Footwear> service = ServiceFactory.getService(Footwear.class);
        assertNotNull(service);
    }
}
