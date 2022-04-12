package cloud.cholewa.shop.commons;

import java.util.List;

public record ResultPage<T>(List<T> data, int pageNumber, long totalPages) {

}
