
package itpu.uz.alibek.dao;

import itpu.uz.alibek.entity.Apparel;

public class ApparelCsvDAO extends AbstractCsvDAO<Apparel> {
    public ApparelCsvDAO(){ super("/apparel.csv"); }

    @Override
    protected Apparel parse(String[] p) throws IllegalArgumentException {
        // name;brand;price;color;size;material;category
        String name = p[0].trim();
        String brand = p[1].trim();
        double price = Double.parseDouble(p[2].trim());
        String color = p[3].trim();
        String size = p[4].trim();
        String material = p[5].trim();
        String category = p[6].trim();
        return new Apparel(name, brand, price, color, size, material, category);
    }
}
