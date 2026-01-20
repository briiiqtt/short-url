//package dev.briiiqtt.shorturl.common;
//
//import org.springframework.http.HttpStatus;
//
//public record ApiResponse<Data>(
//        int status,
//        String message,
//        Data data
//) {
//
//    public static <T> ApiResponse<T> success(T data) {
//        return new ApiResponse<>(HttpStatus.OK.value(), "Success", data);
//    }
//
//    public static <T> ApiResponse<T> error(int status, String message) {
//        return new ApiResponse<>(status, message, null);
//    }
//}
