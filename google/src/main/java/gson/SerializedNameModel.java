package gson;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangyupeng
 * @date 2018/6/16
 */
@Getter
@Setter
@AllArgsConstructor
public class SerializedNameModel {
    private String name;
    private Integer age;

    /**
     * 很好的保留了前端、后台、Android/java各自的命名习惯
     */
    @SerializedName(value = "email", alternate = {"emailAddress", "email_address"})
    private String emailAddress;
}