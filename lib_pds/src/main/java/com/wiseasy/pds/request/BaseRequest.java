package com.wiseasy.pds.request;


import java.lang.reflect.ParameterizedType;

/**
 *
 * @author pupan
 * @param <T>
 */
public abstract class BaseRequest<T>{

    /**
     * Get the type of API response object
     * @return
     */
    public  Class<T> getResponseClass(){
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Get the method name of the API request interface
     * @return
     */
    public String getRequestMethod(){
        String className = this.getClass().getSimpleName();
        className = className.replace("Request", "");
        char[] chars = className.toCharArray();
        String method = "";
        for (char c : chars){
            if("".equals(method)){
                method += (String.valueOf(c)).toLowerCase();
            }else{
                if( c >='A' && c <= 'Z'){
                    method += "." + (String.valueOf(c)).toLowerCase();
                }else{
                    method += String.valueOf(c);
                }
            }
        }
        return method;
    }

}
