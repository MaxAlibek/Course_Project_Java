package itpu.uz.alibek;

import itpu.uz.alibek.controller.*;
import itpu.uz.alibek.service.*;
import itpu.uz.alibek.dao.*;

public class Main {

    public static void main(String[] args) {

        ProductDao dao = new ProductDaoImpl();
        ProductService service = new ProductServiceImpl(dao);
        ProductController<?> controller = new ProductControllerImpl(service);

        controller.listAll().forEach(System.out::println);
    }
}