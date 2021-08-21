package profit.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserRegionTree implements Serializable{

    private String regionName;
    private String regionCode;
    private String parentRegionCode;
    private List<UserRegionTree> children = null;


}
