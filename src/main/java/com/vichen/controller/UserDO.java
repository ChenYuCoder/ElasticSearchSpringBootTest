package com.vichen.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author chenyu
 * @date 2021/2/1
 */
@Entity
@Document(indexName = "user_index")
@Table(name = "elasticsearch_user")
public class UserDO {

  /**
   * 用户ID
   */
  @Id
  private Integer id;
  /**
   * 用户
   */
  private String name;
  /**
   * 性别
   */
  private int gender;
  /**
   * 手机号
   */
  private String phone;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "AccountDO{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", gender=" + gender +
      ", phone='" + phone + '\'' +
      '}';
  }
}
