package com.imooc.service.impl;

import com.imooc.mapper.UserAddressMapper;
import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;
import com.imooc.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
   @Autowired
    private UserAddressMapper userAddressMapper;

   @Autowired
   private Sid sid;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress ua = new UserAddress();
        ua.setUserId(userId);
        return userAddressMapper.select(ua);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {
        //1.判断当前用户是否存在地址，如果没有，则新增为默认地址
        Integer isDefault = 0 ;
        List<UserAddress> addressList = this.queryAll(addressBO.getUserId());
        if (addressList.isEmpty()||addressList == null || addressList.size()==0) {
            isDefault = 1;
        }
        //2.保存到数据库
        String addressId = sid.nextShort();
        UserAddress newUserAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,newUserAddress);
        newUserAddress.setId(addressId);
        newUserAddress.setIsDefault(isDefault);
        newUserAddress.setCreatedTime(new Date());
        newUserAddress.setUpdatedTime(new Date());
        userAddressMapper.insert(newUserAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();

        UserAddress updUserAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,updUserAddress);
        updUserAddress.setId(addressId);
        updUserAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(updUserAddress);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String UserId, String addressId) {
         UserAddress userAddress = new UserAddress();
         userAddress.setId(addressId);
         userAddress.setUserId(UserId);
         userAddressMapper.delete(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBeDefault(String UserId, String addressId) {
            //1.将默认地址设置为不默认
            UserAddress queryAddress = new UserAddress();
            queryAddress.setUserId(UserId);
            queryAddress.setIsDefault(1);
            List<UserAddress> list  =  userAddressMapper.select(queryAddress);
            for (UserAddress ua :list) {
                ua.setIsDefault(0);
                userAddressMapper.updateByPrimaryKey(queryAddress);
            }
            //2.将所选地址设置为默认
            UserAddress defaultAddress = new UserAddress();
            defaultAddress.setIsDefault(1);
            defaultAddress.setId(addressId);
            defaultAddress.setUserId(UserId);
            userAddressMapper.updateByPrimaryKeySelective(defaultAddress);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddress(String userId,String addressId) {
        UserAddress newUserAddress = new UserAddress();
        newUserAddress.setUserId(userId);
        newUserAddress.setId(addressId);


        return userAddressMapper.selectOne(newUserAddress);
    }
}
