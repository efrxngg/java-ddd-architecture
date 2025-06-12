package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.FindCustomerQuery;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.AsyncQueryBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CustomerFindAllOnListService {

    private final AsyncQueryBus asyncQueryBus;

    public List<CustomerResponse> findAllInList(List<CustomerId> list) {
        List<CompletableFuture<Response>> futures = list.stream()
                .map(this::toCompletableFuture)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join(); // Espera a que todos terminen

        // Si necesitas los resultados:
        return futures.stream()
                .map(CompletableFuture::join)
                .map(r -> (CustomerResponse) r)
                .toList();
    }

    private CompletableFuture<Response> toCompletableFuture(CustomerId customerId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return asyncQueryBus.ask(new FindCustomerQuery(customerId.value().toString())).get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}