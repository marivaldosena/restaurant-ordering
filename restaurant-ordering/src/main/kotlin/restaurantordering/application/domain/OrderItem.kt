package restaurantordering.application.domain

import restaurantordering.application.domain.enums.KitchenAreaType

/**
 * The items in a given order.
 * I used Double for simplicity.
 * BigDecimal has more precision and should be encouraged.
*/
data class OrderItem(
    val itemId: String,
    val itemPrice: Double,
    val quantity: Int,
    val kitchenAreaType: KitchenAreaType
)