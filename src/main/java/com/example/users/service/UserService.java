package com.example.users.service;

import java.util.List;
import java.util.Optional;

import com.example.users.model.AppUser;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UserService {

	/**
	 * @param pageable
	 * @return
	 */
	Page<AppUser> findAll(Pageable pageable);

	/**
	 * @param appUser
	 * @return
	 */
	AppUser save(AppUser appUser);

	/**
	 * @param userId
	 * @return
	 */
	Optional<AppUser> findById(Long userId);

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
	 * @param appUser
	 */
	void delete(AppUser appUser);

	/**
	 * @param users
	 */
	void deleteAll(Iterable<AppUser> users);

	/**
	 * 
	 */
	void deleteAll();

	/**
	 * @param example
	 * @return
	 */
	Optional<AppUser> findOne(Example<AppUser> example);

	/**
	 * @param example
	 * @param pageable
	 * @return
	 */
	Page<AppUser> findAll(Example<AppUser> example, Pageable pageable);

	/**
	 * @param example
	 * @return
	 */
	long count(Example<AppUser> example);

	/**
	 * @param example
	 * @return
	 */
	boolean exists(Example<AppUser> example);

	/**
	 * @return
	 */
	List<AppUser> findAll();

	/**
	 * @param sort
	 * @return
	 */
	List<AppUser> findAll(Sort sort);

	/**
	 * @param userIds
	 * @return
	 */
	List<AppUser> findAllById(Iterable<Long> userIds);

	/**
	 * @param users
	 * @return
	 */
	List<AppUser> saveAll(Iterable<AppUser> users);

	/**
	 * 
	 */
	void flush();

	/**
	 * @param appUser
	 * @return
	 */
	AppUser saveAndFlush(AppUser appUser);

	/**
	 * @param users
	 */
	void deleteInBatch(Iterable<AppUser> users);

	/**
	 * 
	 */
	void deleteAllInBatch();

	/**
	 * @param userId
	 * @return
	 */
	AppUser getOne(Long userId);

	/**
	 * @param example
	 * @return
	 */
	List<AppUser> findAll(Example<AppUser> example);

	/**
	 * @param example
	 * @param sort
	 * @return
	 */
	List<AppUser> findAll(Example<AppUser> example, Sort sort);

}