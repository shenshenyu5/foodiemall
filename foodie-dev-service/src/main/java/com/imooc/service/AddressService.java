package com.imooc.service;

import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;

import java.util.List;

public interface AddressService {
    /**
     * 查询用户的所有收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> queryAll(String userId);

    /**
     * 新增用户收货地址
     * @param addressBO
     */
    public void addNewUserAddress(AddressBO addressBO);

    /**
     * 更新用户收货地址
     * @param addressBO
     */
    public void updateUserAddress(AddressBO addressBO);

    /**
     * 根据用户id和地址id，删除对应的记录
     * @param UserId
     * @param addressId
     */
    public void deleteUserAddress(String UserId,String addressId);

    /**
     * 修改默认收货地址
     * @param UserId
     * @param addressId
     */
    public void updateUserAddressToBeDefault(String UserId,String addressId);

    /**
     * 通过用户id查询相应的地址信息
     * @param userId
     * @return
     */
    public UserAddress queryUserAddress(String userId,String addressId);
}
