package restaurantordering.application.domain

data class NewOrder(
    val orderId: String,
    val clientId: String,
    val orderItems: List<OrderItem>
)