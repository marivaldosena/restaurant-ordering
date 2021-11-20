package restaurantordering.adapters.out.sns

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import restaurantordering.adapters.out.sns.config.NewOrderEventProperties
import restaurantordering.adapters.out.sns.converters.getMessageAttributes
import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.OrderItem
import restaurantordering.application.ports.out.NewOrderPort
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model.PublishRequest

@Component
class NewOrderEventPublisher(
    private val snsClient: SnsClient,
    private val snsProperties: NewOrderEventProperties
) : NewOrderPort {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun notify(order: NewOrder, item: OrderItem) {
        logger.info("NewOrderEventPublisher.notify => publishing message in SNS")
        val publishRequest = PublishRequest.builder()
            .topicArn(snsProperties.topic)
            .message("New order ${order.orderId}")
            .messageAttributes(
                item.getMessageAttributes(orderId = order.orderId, clientId = order.clientId)
            )
    }
}