package com.vichen.jpa;

import com.vichen.controller.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenyu
 * @date 2021/2/1
 */
@Repository
public interface UserJpaRepository extends JpaRepository<UserDO, Integer> {

}
