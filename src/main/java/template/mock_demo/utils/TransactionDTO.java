package template.mock_demo.utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class TransactionDTO {
    @NotBlank(message = "Name must be filled!")
    private String product_name;

    @NotNull(message = "Price cannot be null!")
    private Integer price;

    @NotNull(message = "Qty cannot be null!")
    private Integer quantity;

    @NotNull(message = "Brand ID cannot be null!")
    private Integer customer_id;
}
