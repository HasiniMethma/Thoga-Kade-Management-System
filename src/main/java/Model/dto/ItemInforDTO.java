package Model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemInforDTO {
    private String itemCode;
    private String description;
    private  String category;
    private int qtyOnHand;
    private double unitPrice;
}
