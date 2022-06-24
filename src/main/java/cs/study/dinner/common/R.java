package cs.study.dinner.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    private Integer code;   //代码
    private String msg; //消息
    private T data; //数据
    private Map<String, Object> map = new HashMap<>();    //动态数据

    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.code = 1;
        r.data = data;
        return r;
    }

    public static <T>R<T> error(String msg){
        R<T> r = new R<>();
        r.code = 0;
        r.msg = msg;
        return r;
    }

    public R<T> add(String key, Object value){
        this.map.put(key, value);
        return this;
    }


}
