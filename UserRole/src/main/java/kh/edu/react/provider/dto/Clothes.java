package kh.edu.react.provider.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    private int cId;
    private String cName;
    private String cCategory;
    private String cBrand;
    private String cColor;
    private String cSize;
    private String cMaterial;
    private int cPrice;
    private int cStock;
    private String cGender;
    private String cSeason;
    private String cRegisterDate;
}
