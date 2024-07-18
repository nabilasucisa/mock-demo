package template.mock_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String product_name;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}