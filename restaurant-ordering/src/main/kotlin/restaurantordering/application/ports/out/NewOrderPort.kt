package restaurantordering.application.ports.out

import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.OrderItem

interface NewOrderPort {
    fun notify(order: NewOrder, item: OrderItem)
}