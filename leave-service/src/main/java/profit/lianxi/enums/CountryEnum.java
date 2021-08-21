package profit.lianxi.enums;

import lombok.Getter;

public enum CountryEnum {


    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");
    @Getter
    private Integer code;
    @Getter
    private String name;

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    public static CountryEnum foreach_enum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum:myArray
             ) {
            if (countryEnum.getCode()==index){
                return countryEnum;
            }
            
        }
        return null;
        
    }
}
/**
 * mysql dbname = CountryEnum
 *
 * table
 * one
 * id username  age birth useremail
 *
 *
 *
 *
 * */
