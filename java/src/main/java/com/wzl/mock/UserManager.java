package com.wzl.mock;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public class UserManager {

    public AddressService addressService;
    public int getCityCode(String userName){
        int cityCode=0;
        if("nanjing".equals(addressService.findAddress(userName))) {
            cityCode = 1;
        }
        return cityCode;
    }
}
