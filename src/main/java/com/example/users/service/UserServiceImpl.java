package com.example.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.global.exceptions.ResourceNotFoundException;
import com.example.users.model.User;
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
	public Page<User> findAll(Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);
		return users;
	}

	/**
	 * @param user
	 * @return
	 */
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public Optional<User> findById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user;
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
	 * @param user
	 */
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	/**
	 * @param users
	 */
	@Override
	public void deleteAll(Iterable<User> users) {
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
	public Optional<User> findOne(Example<User> example) {
		return userRepository.findOne(example);
	}

	/**
	 * @param example
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<User> findAll(Example<User> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public long count(Example<User> example) {
		return userRepository.count(example);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public boolean exists(Example<User> example) {
		return userRepository.exists(example);
	}

	/**
	 * @return
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * @param sort
	 * @return
	 */
	@Override
	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	/**
	 * @param userIds
	 * @return
	 */
	@Override
	public List<User> findAllById(Iterable<Long> userIds) {
		return userRepository.findAllById(userIds);
	}

	/**
	 * @param users
	 * @return
	 */
	@Override
	public List<User> saveAll(Iterable<User> users) {
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
	 * @param user
	 * @return
	 */
	@Override
	public User saveAndFlush(User user) {
		return userRepository.saveAndFlush(user);
	}

	/**
	 * @param users
	 */
	@Override
	public void deleteInBatch(Iterable<User> users) {
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
	 * @param id
	 * @return
	 */
	@Override
	public User getOne(Long userId) {
		return userRepository.getOne(userId);
	}

	/**
	 * @param example
	 * @return
	 */
	@Override
	public List<User> findAll(Example<User> example) {
		return userRepository.findAll(example);
	}

	/**
	 * @param example
	 * @param sort
	 * @return
	 */
	@Override
	public List<User> findAll(Example<User> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

}