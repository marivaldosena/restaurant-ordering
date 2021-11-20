package restaurantordering

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestaurantOrderingApplication

fun main(args: Array<String>) {
    runApplication<RestaurantOrderingApplication>(*args)
}
