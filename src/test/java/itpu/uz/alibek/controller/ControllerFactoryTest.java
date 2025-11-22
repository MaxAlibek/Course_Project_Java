package itpu.uz.alibek.controller;

import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Footwear;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFactoryTest {

    @Test
    void shouldCreateApparelController() {
        ProductController<Apparel> controller = ControllerFactory.createController(Apparel.class);
        assertNotNull(controller);
    }

    @Test
    void shouldCreateFootwearController() {
        ProductController<Footwear> controller = ControllerFactory.createController(Footwear.class);
        assertNotNull(controller);
    }
}
