package template.mock_demo.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class CustomerRepoTest {
    @Id
    private Integer id;

    @NotBlank
    String name;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date birth_date;
}
