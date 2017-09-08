package com.thoughtclan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.thoughtclan.dto.PersonDTO;
import com.thoughtclan.entites.Address;
import com.thoughtclan.entites.Person;
import com.thoughtclan.service.TelephoneService;
import com.thoughtclan.validator.ToDoValidator;

@Controller
public class TelephoneController {

	@Autowired
	TelephoneService telephoneBean;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleBadRequestException(MethodArgumentNotValidException ex) {
		return "error";
	}

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.addValidators(new ToDoValidator());
	// }
	// @PostMapping("/addPerson")
	// public String addName(ModelMap model, @Valid@ModelAttribute(name =
	// "person")Person eObj, BindingResult result) {
	// if (result.hasErrors())
	// {
	// return "add";
	// }
	// else
	// {
	// myBean.addPerson(eObj.getName(),eObj.getPhoneno());
	// return "index";
	// }
	//
	// }
	// @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String add(ModelMap model,@Validated @RequestParam(value = "name",
	// defaultValue = "Guest") String name,
	// @RequestParam(value = "phoneno", defaultValue = "0") String phoneno) {
	// List<Person> persons;
	// if(phoneno.length()!=10) {
	// return "errorPhoneLength";
	//// }
	//// boolean check=(myBean.addPerson(name, phoneno));
	//// if(check) {
	//// persons = myBean.getAllPersons();
	//// model.addAttribute("person", persons);
	// return "addAddress";
	//
	//// else
	//// return "errorAdd";
	// }
	@RequestMapping("/add")
	public String add(Model map) {
		map.addAttribute("person", new Person());
		return "add";
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public String addAddress(ModelMap model,Person person,HttpServletRequest request) {

		List<String> addressTypeList = new ArrayList<String>();

		boolean check = (telephoneBean.addPerson(person.getName(), person.getPhoneno(),person.getSecondaryphoneno()));
		if (check) {
//			List<Address> addresses;

//			addresses = telephoneBean.getAllPersons();

			addressTypeList.add("Residential");
			addressTypeList.add("Office");
			addressTypeList.add("Permanent");
			model.addAttribute("addressTypeList", addressTypeList);
			Address aObj = new Address();
			
			aObj.setPerson(person);
			model.addAttribute("addressDetails", aObj);
			request.setAttribute("person", person);
			return "addAddress";
		} else
			return "errorAdd";
	}

	
	
	
	
	@RequestMapping(value = "/addressDetails", method = RequestMethod.POST)
	public String addressDetails(ModelMap model,
			@Validated @ModelAttribute(name = "addressDetails") Address addressDetails) {
		
	
	
		
		List<Address> addresses=new ArrayList<Address>();
		addresses.add(addressDetails);
		//addressDetails.getPerson().setAddress(addresses);
		
		System.out.println("name  is ................."+addressDetails.getPerson().getName());
		telephoneBean.addAddress(addressDetails, addressDetails.getPerson());
		model.addAttribute("personDetails", addressDetails.getPerson());
		model.addAttribute("addressdetails", addressDetails);

		return "index";
	}

	

	
	@RequestMapping("/deleteId")
	public String deletePerson(ModelMap model, @RequestParam(value = "id", defaultValue = "0") long id) {

		boolean flag = telephoneBean.delete(id);
		if (flag) {
			// persons = myBean.getAllPersons();
			// model.addAttribute("person", persons);
			return "index";

		} else
			return "error";
	}

	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	
	
	
	@RequestMapping("/searchId")
	public String searchId(ModelMap model, @RequestParam(value = "id", defaultValue = "0") long id) {

		Person person = new Person();

		person = telephoneBean.searchId(id);

		model.addAttribute("person", person);
		return "searchResultById";

	}

	@RequestMapping("/searchI")
	public String searchI() {
		return "searchI";
	}

	@RequestMapping("/searchName")
	public String searchName(ModelMap model, @RequestParam(value = "username", defaultValue = "guest") String name) {
		System.out.println(name);
		List<Person> person = new ArrayList<Person>();
		person = telephoneBean.searchName(name);

		model.addAttribute("person", person);
		return "searchResultByName";

	}

	@RequestMapping("/searchN")
	public String searchN() {
		return "searchN";
	}

	@RequestMapping("/searchPhone")
	public String searchPhone(ModelMap model, @RequestParam(value = "phoneno", defaultValue = "0") String phoneno) {
		System.out.println(phoneno);
		Person personSearched = new Person();
		personSearched = telephoneBean.searchPhone(phoneno);

		model.addAttribute("person", personSearched);
		return "searchResultByPhone";

	}

	@RequestMapping("/searchP")
	public String searchP() {
		return "searchP";
	}

	@RequestMapping("/editId")
	public String editId(ModelMap model, @RequestParam(value = "id", defaultValue = "0") int id) {

		Person person = telephoneBean.searchId(id);
		System.out.println("editID" + id);

		model.addAttribute("person", person);
		return "editId";

	}

	@RequestMapping("/editRequest")
	public String editRequest(ModelMap model, @RequestParam(value = "id", defaultValue = "0") String id,
			@RequestParam(value = "username", defaultValue = "guest") String name,
			@RequestParam(value = "phone", defaultValue = "0") String phoneno,
			@RequestParam(value = "secondaryphone", defaultValue = "0") String secondaryphoneno) {

		System.out.println("editrequest" + id);
		Person person = new Person();
		// person =
		long id1;
		id1 = (Long.parseLong(id));
		person.setId(id1);

		person.setName(name);
		person.setPhoneno(phoneno);
		person.setSecondaryphoneno(secondaryphoneno);

		telephoneBean.edit(person);
		List<Person> persons;
		persons = telephoneBean.getAllPersons();
		model.addAttribute("person", persons);
		return "index";

	}

	@RequestMapping("/edit")
	public String edit() {
		return "edit";
	}

	@GetMapping("/")
	public String welcome(ModelMap model) {
		List<Person> persons2;
		persons2 = telephoneBean.getAllPersons();
		model.addAttribute("person", persons2);
		return "index";
	}

	@Autowired
	private Converter<Person, PersonDTO> personConverter;

	@GetMapping("/rest/person")
	@ResponseBody
	public List<PersonDTO> welcomeP(ModelMap model) {
		List<Person> persons2;
		persons2 = telephoneBean.getAllPersons();
		model.addAttribute("person", persons2);

		List<PersonDTO> list = new ArrayList<PersonDTO>();

		for (Person p : persons2)
			list.add(personConverter.convert(p));

		return list;
	}

	@GetMapping("/rest/person2")
	@ResponseBody
	public List<Person> restPersons(ModelMap model) {
		List<Person> persons2;
		persons2 = telephoneBean.getAllPersons();
		model.addAttribute("person", persons2);

		return persons2;
	}

}
