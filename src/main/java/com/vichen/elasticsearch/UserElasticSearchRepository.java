package com.vichen.elasticsearch;

import com.vichen.controller.UserDO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenyu
 * @date 2021/2/4
 */
@Repository
public interface UserElasticSearchRepository extends
  ElasticsearchRepository<UserDO, Integer> {

  /**
   * 通过用户名查询
   *
   * @param name 姓名
   * @return
   */
  List<UserDO> findByName(String name);

  /**
   * 通过用户名模糊查询
   *
   * @param name 姓名
   * @return
   */
  List<UserDO> findByNameLike(String name);

  /**
   * 分页用户查询
   *
   * @param name
   * @param pageable
   * @return
   */
  @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
  Page<UserDO> findByName(String name, Pageable pageable);

}
