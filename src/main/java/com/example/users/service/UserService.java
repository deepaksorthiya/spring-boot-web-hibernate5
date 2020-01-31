package com.example.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.users.model.User;

public interface UserService {

	/**
	 * @param pageable
	 * @return
	 */
	Page<User> findAll(Pageable pageable);

	/**
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * @param userId
	 * @return
	 */
	Optional<User> findById(Long userId);

	/**
	 * @param userId
	 * @return
	 */
	boolean existsById(Long userId);

	/**
	 * @return
	 */
	long count();

	/**
	 * @param userId
	 */
	void deleteById(Long userId);

	/**
	 * @param user
	 */
	void delete(User user);

	/**
	 * @param users
	 */
	void deleteAll(Iterable<User> users);

	/**
	 * 
	 */
	void deleteAll();

	/**
	 * @param example
	 * @return
	 */
	Optional<User> findOne(Example<User> example);

	/**
	 * @param example
	 * @param pageable
	 * @return
	 */
	Page<User> findAll(Example<User> example, Pageable pageable);

	/**
	 * @param example
	 * @return
	 */
	long count(Example<User> example);

	/**
	 * @param example
	 * @return
	 */
	boolean exists(Example<User> example);

	/**
	 * @return
	 */
	List<User> findAll();

	/**
	 * @param sort
	 * @return
	 */
	List<User> findAll(Sort sort);

	/**
	 * @param userIds
	 * @return
	 */
	List<User> findAllById(Iterable<Long> userIds);

	/**
	 * @param users
	 * @return
	 */
	List<User> saveAll(Iterable<User> users);

	/**
	 * 
	 */
	void flush();

	/**
	 * @param user
	 * @return
	 */
	User saveAndFlush(User user);

	/**
	 * @param users
	 */
	void deleteInBatch(Iterable<User> users);

	/**
	 * 
	 */
	void deleteAllInBatch();

	/**
	 * @param id
	 * @return
	 */
	User getOne(Long userId);

	/**
	 * @param example
	 * @return
	 */
	List<User> findAll(Example<User> example);

	/**
	 * @param example
	 * @param sort
	 * @return
	 */
	List<User> findAll(Example<User> example, Sort sort);

}