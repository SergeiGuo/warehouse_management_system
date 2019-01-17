package com.wms.provider.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.provider.pojo.Provider;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
public interface ProviderService extends IService<Provider> {
    public Provider queryUserById();
}
