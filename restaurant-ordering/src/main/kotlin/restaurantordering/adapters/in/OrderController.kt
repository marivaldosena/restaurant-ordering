package restaurantordering.adapters.`in`

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import restaurantordering.adapters.`in`.converters.getPointOfSale
import restaurantordering.adapters.`in`.converters.toModel
import restaurantordering.adapters.`in`.requests.NewOrderRequest
import restaurantordering.adapters.`in`.responses.PlaceOrderResponse
import restaurantordering.application.ports.`in`.PlaceOrderUseCase
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val placeOrderUseCase: PlaceOrderUseCase
) {

    @PostMapping
    fun placeOrder(
        @Valid @RequestBody request: NewOrderRequest
    ): ResponseEntity<PlaceOrderResponse> {
        val newOrder = request.toModel()
        placeOrderUseCase.execute(order = newOrder, request.getPointOfSale())
        val response = PlaceOrderResponse(message = "Order ${newOrder.orderId} will be delivered soon.")
        return ResponseEntity.ok(response);
    }

}