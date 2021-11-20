package restaurantordering.application.services

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import restaurantordering.application.domain.NewOrder
import restaurantordering.application.domain.enums.PointOfSaleType
import restaurantordering.application.ports.out.NewOrderPort
import restaurantordering.helpers.dummyObject

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PlaceOrderServiceTest {
    private val newOrderPort: NewOrderPort = mock()
    private val placeOrderService = PlaceOrderService(newOrderPort = newOrderPort)

    @Test
    internal fun `should place an order given a valid request`() {
        // Arrange
        val newOrder = dummyObject<NewOrder>()

        // Act
        placeOrderService.execute(order = newOrder, pointOfSale = PointOfSaleType.MOBILE)

        // Assert
        verify(newOrderPort, atLeastOnce()).notify(any(), any())
    }


}