package com.todolist.todolist;

import com.todolist.todolist.domain.Todo;
import com.todolist.todolist.domain.TodoRepository;
import com.todolist.todolist.domain.User;
import com.todolist.todolist.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TodolistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
		logger.info("애플 실행");
	}

	private final UserRepository userRepository;
	private final TodoRepository todoRepository;

	public TodolistApplication(UserRepository userRepository, TodoRepository todoRepository) {
		this.userRepository = userRepository;
		this.todoRepository = todoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("김일", "1234", "user");
		User user2 = new User("김이", "5678", "admin");
		userRepository.saveAll(Arrays.asList(user1, user2));

		todoRepository.save(new Todo("SQLD", user1));
		todoRepository.save(new Todo("ADSP", user2));
	}
}
