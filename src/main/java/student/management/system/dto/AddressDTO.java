package student.management.system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private String type;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
