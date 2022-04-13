package cloud.cholewa.shop.commons;

public record Page(int number, int size) {

    public int getOffset() {
        return number + size;
    }
}
