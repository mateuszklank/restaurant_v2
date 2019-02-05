package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	/*
	@Autowired
	private UserRepository userDao;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String firstname, String lastname) {
		String userId = "";
		try {
			User user = new User(firstname, lastname);
			userDao.save(user);
			userId = String.valueOf(user.getId_employee());
		}
		catch (Exception ex) {
			return "Błąd przy tworzeniu użytkownika: " + ex.toString();
		}
		return "Użytkownik o numerze id " + userId + " został pomyślnie utworzony!";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id_employee) {
		try {
			User user = new User(id_employee);
			userDao.delete(user);
		}
		catch (Exception ex) {
			return "Wystąpił błąd podczas usuwania użytkownika: " + ex.toString();
		}
		return "Użytkownik pomyślnie usunięty!";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id_employee, String firstname, String lastname) {
		try {
			Optional<User> userOptional = userDao.findById(id_employee);
			User user = userOptional.get();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			userDao.save(user);
		}
		catch (Exception ex) {
			return "Wystąpił błąd podczas aktualizacji danych użytkownika: " + ex.toString();
		}
		return "Dane użytkownika zostały pomyślnie zaktualizowane!";
	}
	*/
}