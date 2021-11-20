package restaurantordering.adapters.`in`

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import restaurantordering.adapters.`in`.requests.NewOrderRequest
import restaurantordering.adapters.`in`.requests.OrderItemRequest
import restaurantordering.application.ports.`in`.PlaceOrderUseCase


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class OrderControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    private val placeOrderUseCase: PlaceOrderUseCase = mock()

    @Test
    internal fun `place order given a valid request`() {
        val request = NewOrderRequest(
            clientId = "clientId",
            pointOfSale = "MOBILE",
            items = listOf(
                OrderItemRequest(
                    itemId = "itemId",
                    itemPrice = 5.00,
                    quantity = 3,
                    kitchenAreaType = "BURGERS"
                )
            )
        )
        mockMvc.perform(
            post("/api/v1/orders")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("UTF-8")
                .content(mapper.writeValueAsString(request))
            ).andDo(print())
            .andExpect(status().is2xxSuccessful)
            .andExpect(jsonPath("\$.message").exists())
    }
}