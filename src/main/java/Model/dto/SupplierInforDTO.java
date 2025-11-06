package Model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SupplierInforDTO {
    private String id;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String phone;
    private String email;
}
