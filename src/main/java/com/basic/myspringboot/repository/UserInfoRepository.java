package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.UserInfo;
import org.springframework.data.repository.ListCrudRepository;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Integer> {
}
