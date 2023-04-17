package gson;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyupeng
 * @date 2018/6/6
 */
@Data
public class LoginLog implements Serializable {

    private int loginLogId;

    private int userId;

    private String ip;

    private Date loginDate;
}