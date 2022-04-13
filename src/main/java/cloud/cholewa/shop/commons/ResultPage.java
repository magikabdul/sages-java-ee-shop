package cloud.cholewa.shop.commons;

import java.util.List;

public record ResultPage<T>(List<T> data, int pageNumber, long totalPages) {

    public <R> ResultPage<R> with(List<R> data) {
        return new ResultPage<>(data, pageNumber, totalPages);
    }
}
