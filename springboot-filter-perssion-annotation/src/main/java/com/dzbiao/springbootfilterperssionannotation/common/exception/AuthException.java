package com.dzbiao.springbootfilterperssionannotation.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/22 12:14
 * @Description:
 */
@NoArgsConstructor
@Data
public class AuthException extends RuntimeException{

    private String code;

    private String message;


    public AuthException(String code, String message){
        this.code = code;
        this.message = message;
    }
}
