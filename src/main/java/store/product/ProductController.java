package store.product;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product", url = "http://product:8080")
public interface ProductController {

    @PostMapping("/product")
    ResponseEntity<ProductOut> create(
        @RequestHeader("id-account") String idAccount,
        @RequestBody ProductIn in
    );

    @GetMapping("/product/{id}")
    ResponseEntity<ProductOut> findById(
        @RequestHeader("id-account") String idAccount,
        @PathVariable("id") String id
    );

    @GetMapping("/product")
    ResponseEntity<List<ProductOut>> findAll(
        @RequestHeader("id-account") String idAccount
    );

    @DeleteMapping("/product/{id}")
    ResponseEntity<Void> delete(
        @RequestHeader("id-account") String idAccount,
        @PathVariable("id") String id
    );
}
