package restaurantordering.adapters.out.sns.converters

import com.fasterxml.jackson.databind.ObjectMapper
import restaurantordering.application.domain.OrderItem
import software.amazon.awssdk.services.sns.model.MessageAttributeValue

fun OrderItem.getMessageAttributes(orderId: String, clientId: String): Map<String, MessageAttributeValue> =
    mapOf(
        "clientId" to clientId.toMessageAttribute(),
        "orderId" to orderId.toMessageAttribute(),
        "itemId" to this.itemId.toMessageAttribute(),
        "price" to this.itemPrice.toString().toMessageAttribute(),
        "quantity" to this.quantity.toString().toMessageAttribute(),
        "kitchenArea" to this.kitchenAreaType.toString().toMessageAttribute()
    )

private fun String.toMessageAttribute() =
    MessageAttributeValue.builder().dataType("String").stringValue(this).build()

private fun <T> T.objectToMap(): Map<String, Any> {
    return convert()
}

private inline fun <T, reified R> T.convert(): R {
    val mapper = ObjectMapper()
    val value = mapper.writeValueAsString(this)
    return mapper.readValue(value, R::class.java)
}