package com.zen.services.service.util;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OptionalHandlingUtil {
    interface  IfPresentFunc<T> {
        T process();
    }
    public <T,U> U processOptional(Optional<T> opt, IfPresentFunc<U> func){
        U ifNotPresentVal = null;
        if(opt.isPresent()){
            return func.process();
        }else{
            return ifNotPresentVal;
        }

    }
}
