public class Item {
    private final int id;
    private int price;
    private String name;


    public Item(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
    public String getDisplayName() {
        return name;
    }


}
