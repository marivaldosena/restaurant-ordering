package restaurantordering.application.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.enums.PointOfSaleType
import restaurantordering.application.ports.`in`.PlaceOrderUseCase
import restaurantordering.application.ports.out.NewOrderPort

@Service
class PlaceOrderService(
    private val newOrderPort: NewOrderPort
) : PlaceOrderUseCase {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(order: NewOrder, pointOfSale: PointOfSaleType) {
        logger.info("PlaceOrderService.execute => sending new order ${order.orderId} to client ${order.clientId}")

        order.orderItems.forEach {
            newOrderPort.notify(
                order = order,
                item = it
            )
        }
    }
}