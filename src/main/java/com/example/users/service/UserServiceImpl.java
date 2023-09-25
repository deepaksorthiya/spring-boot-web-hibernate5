package com.example.users.service;

import java.util.List;
import java.util.Optional;

import com.example.users.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.users.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<AppUser> findAll(Pageable pageable) {
		Page<AppUser> users = userRepository.findAll(pageable);
		return users;
	}

	/**
	 * @param appUser
	 * @return
	 */
	@Override
	public AppUser save(AppUser appUser) {
		return userRepository.save(appUser);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public Optional<AppUser> findById(Long userId) {
		return userRepository.findById(userId);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public boolean existsById(Long userId) {
		return userRepository.existsById(userId);
	}

	/**
	 * @return
	 */
	@Override
	public long count() {
		return userRepository.count();
	}

	/**
	 * @param userId
	 */
	@Override
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	/**
	 * @param appUser
	 */
	@Override
	public void delete(AppUser appUser) {
		userRepository.delete(appUser);
	}

	/**
	 * @param users
	 */
	@Override
	public void deleteAll(Iterable<AppUser> users) {
		userRepository.deleteAll(users);
	}

	/**
	 * 
	 */
	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public Optional<AppUser> findOne(Example<AppUser> example) {
		return userRepository.findOne(example);
	}

	/**
	 * @param example
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<AppUser> findAll(Example<AppUser> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public long count(Example<AppUser> example) {
		return userRepository.count(example);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public boolean exists(Example<AppUser> example) {
		return userRepository.exists(example);
	}

	/**
	 * @return
	 */
	@Override
	public List<AppUser> findAll() {
		return userRepository.findAll();
	}

	/**
	 * @param sort
	 * @return
	 */
	@Override
	public List<AppUser> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	/**
	 * @param userIds
	 * @return
	 */
	@Override
	public List<AppUser> findAllById(Iterable<Long> userIds) {
		return userRepository.findAllById(userIds);
	}

	/**
	 * @param users
	 * @return
	 */
	@Override
	public List<AppUser> saveAll(Iterable<AppUser> users) {
		return userRepository.saveAll(users);
	}

	/**
	 * 
	 */
	@Override
	public void flush() {
		userRepository.flush();
	}

	/**
	 * @param appUser
	 * @return
	 */
	@Override
	public AppUser saveAndFlush(AppUser appUser) {
		return userRepository.saveAndFlush(appUser);
	}

	/**
	 * @param users
	 */
	@Override
	public void deleteInBatch(Iterable<AppUser> users) {
		userRepository.deleteAll(users);
	}

	/**
	 * 
	 */
	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public AppUser getOne(Long userId) {
		return userRepository.getOne(userId);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public List<AppUser> findAll(Example<AppUser> example) {
		return userRepository.findAll(example);
	}

	/**
	 * @param example
	 * @param sort
	 * @return
	 */
	@Override
	public List<AppUser> findAll(Example<AppUser> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

}