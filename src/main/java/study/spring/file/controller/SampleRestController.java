package study.spring.file.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import study.spring.file.pojo.UserDTO;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Sample Rest Controller", description = "Sample Rest Controller for CRUD Operations")
public class SampleRestController {

	private static final Logger LOGGER = LogManager.getLogger(SampleRestController.class);
	private static List<UserDTO> users = new ArrayList<UserDTO>();

	static {
		users.add(new UserDTO(1L, "Hari", "Latur"));
		users.add(new UserDTO(2L, "TheGeek", "Pune"));
	}

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Say Hello", description = "Hello Message from API")
	String sayHello() {

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");

		return "Hello World";
	}

	@GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get User", description = "Get User by a ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = UserDTO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "The User with given Id was not found.", content = {
					@Content(schema = @Schema()) }) })
	UserDTO getUser(@Parameter(description = "User ID") @PathVariable Long id) {
		if (users.isEmpty()) {
			LOGGER.warn("Users list is empty");
			return null;
		}
		Optional<UserDTO> user = users.stream().filter(f1 -> f1.getId().equals(id)).findFirst();
		return user == null ? null : user.get();
	}

	@GetMapping(path = "/users/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get All User", description = "Get All Users")
	List<UserDTO> findAllUsers() {
		return users;
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create User", description = "Create a new User")
	void createUser(@RequestBody UserDTO userDTO) {
		if (userDTO != null) {
			users.add(userDTO);
		} else {
			LOGGER.error("NULL User is not accepted.");
		}
	}

	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete User", description = "Delete User by a ID")
	void deleteById(@Parameter(description = "User ID") @PathVariable Long id) {
		users.removeIf(f1 -> f1.getId().equals(id));
	}

}
