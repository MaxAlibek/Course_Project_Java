
package itpu.uz.alibek.dao;

import itpu.uz.alibek.entity.Footwear;

public class FootwearCsvDAO extends AbstractCsvDAO<Footwear> {
    public FootwearCsvDAO(){ super("/footwear.csv"); }

    @Override
    protected Footwear parse(String[] p) throws IllegalArgumentException {
        // name;brand;price;color;euSize;type
        String name = p[0].trim();
        String brand = p[1].trim();
        double price = Double.parseDouble(p[2].trim());
        String color = p[3].trim();
        int size = Integer.parseInt(p[4].trim());
        String type = p[5].trim();
        return new Footwear(name, brand, price, color, size, type);
    }
}
