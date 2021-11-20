package restaurantordering.adapters.`in`.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderItemRequest(
    @field:NotBlank
    val itemId: String,

    @field:DecimalMin(value = "0.01")
    val itemPrice: Double,

    @field:Min(1)
    val quantity: Int,

    /*
        It's recommended to validate an enumeration using a String and not the default type.
        A way to do this is using the hard-coded values or creating a method in the enumeration to
        return all valid entries. This way, the enumeration values may grow with no worries.
     */
    @field:[NotBlank Pattern(regexp = "ICE_CREAM|BREAKFAST|SALAD|BEVERAGE|BURGERS|FRIES")]
    val kitchenAreaType: String
)
