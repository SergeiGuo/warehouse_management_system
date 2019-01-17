package com.wms.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.provider.mapper.ProviderMapper;
import com.wms.provider.pojo.Provider;
import com.wms.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
@Service
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    public Provider queryUserById(){
        return providerMapper.selectById("1");
    }
}
