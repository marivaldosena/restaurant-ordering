package restaurantordering.adapters.`in`.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewOrderRequest(
    @field:NotBlank
    val clientId: String,

    @field:[Valid Size(min = 1)]
    val items: List<OrderItemRequest>,

    /*
        It's recommended to validate an enumeration using a String and not the default type.
        A way to do this is using the hard-coded values or creating a method in the enumeration to
        return all valid entries. This way, the enumeration values may grow with no worries.
     */
    @field:[NotBlank Pattern(regexp = "CASH_REGISTER|VENDOR_MACHINE|MOBILE|WEBSITE")]
    val pointOfSale: String
)