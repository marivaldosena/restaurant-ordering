package restaurantordering.application.ports.`in`

import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.enums.PointOfSaleType

interface PlaceOrderUseCase {
    fun execute(order: NewOrder, pointOfSale: PointOfSaleType)
}