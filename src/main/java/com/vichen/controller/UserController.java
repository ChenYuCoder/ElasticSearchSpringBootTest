package com.vichen.controller;

import com.vichen.elasticsearch.UserElasticSearchRepository;
import com.vichen.jpa.UserJpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyu
 * @date 2021/2/1
 */
@RestController
public class UserController {

  private final UserElasticSearchRepository userElasticSearchRepository;
  private final UserJpaRepository userJpaRepository;

  public UserController(
    UserElasticSearchRepository userElasticSearchRepository,
    UserJpaRepository userJpaRepository) {
    this.userElasticSearchRepository = userElasticSearchRepository;
    this.userJpaRepository = userJpaRepository;
  }

  @GetMapping("syncUser")
  public String syncUser() {
    List<UserDO> userList = userJpaRepository.findAll();
    userElasticSearchRepository.saveAll(userList);
    return "success: " + userList.size();
  }

  @GetMapping("findByPage")
  public Page<UserDO> findByPage(String name, int page) {
    return userElasticSearchRepository.findByName(name,
      PageRequest.of(page, 10));
  }

  @GetMapping("findByName")
  public List<UserDO> findByName(String name) {
    return userElasticSearchRepository.findByName(name);
  }

  @GetMapping("findByNameLike")
  public List<UserDO> findByNameLike(String name) {
    return userElasticSearchRepository.findByNameLike(name);
  }

  @GetMapping("deleteById")
  public String deleteById(int id) {
    userElasticSearchRepository.deleteById(id);
    return "success";
  }

}
