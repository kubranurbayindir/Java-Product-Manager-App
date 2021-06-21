package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResults;
import kodlamaio.northwind.core.utilities.results.Results;

public interface UserService {
	Results add(User user);
	DataResults<User> findByEmail(String email);
}