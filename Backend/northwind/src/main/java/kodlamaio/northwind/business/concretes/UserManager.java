package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResults;
import kodlamaio.northwind.core.utilities.results.Results;
import kodlamaio.northwind.core.utilities.results.SuccessDataResults;
import kodlamaio.northwind.core.utilities.results.SuccessResults;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Results add(User user) {
		this.userDao.save(user);
		return new SuccessResults("Kullanıcı eklendi");
	}

	@Override
	public DataResults<User> findByEmail(String email) {
		return new SuccessDataResults<User>(this.userDao.findByEmail(email)
				,"Kullanıcı bulundu");
	}

}