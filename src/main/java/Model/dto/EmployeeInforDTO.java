package Model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeInforDTO {
    private String id;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private Double salary;
    private String phone;
    private String address;
    private String joinedDate;
    private String status;
}
