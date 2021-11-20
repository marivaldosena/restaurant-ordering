package restaurantordering.adapters.`in`.converters

import restaurantordering.adapters.`in`.requests.NewOrderRequest
import restaurantordering.adapters.`in`.requests.OrderItemRequest
import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.OrderItem
import restaurantordering.application.domain.enums.KitchenAreaType
import restaurantordering.application.domain.enums.PointOfSaleType
import java.util.*

fun NewOrderRequest.toModel() =
    NewOrder(
        orderId = UUID.randomUUID().toString(),
        clientId = this.clientId,
        orderItems = this.items.map { it.toModel() }
    )

fun NewOrderRequest.getPointOfSale() =
    PointOfSaleType.valueOf(this.pointOfSale)

fun OrderItemRequest.toModel() =
    OrderItem(
        itemId = this.itemId,
        itemPrice = this.itemPrice,
        quantity = this.quantity,
        kitchenAreaType = KitchenAreaType.valueOf(this.kitchenAreaType)
    )

