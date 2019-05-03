package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByUsernameAndPassword(String username,String password);
	public List<User> findAllByUsername(String username);
	public List<User> findAllByBo(User bo);
}