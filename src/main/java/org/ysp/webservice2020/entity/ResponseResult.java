package org.ysp.webservice2020.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pai
 * @date 2020/5/4
 */
@Accessors(chain = true)
@Data
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T obj;
}
