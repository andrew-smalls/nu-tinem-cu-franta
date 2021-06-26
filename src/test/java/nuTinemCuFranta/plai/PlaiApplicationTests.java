package nuTinemCuFranta.plai;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class PlaiApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	// test methods go below
	@Test
	public void testCreateUser() {
		User user = new User();

		user.setFirstName("Andrei");
		user.setLastName("Andrei");
		user.setEmail("usertest1@gmail.com");
		user.setPassword("1223456789101111");
		user.setRole("Organization");

		User savedUser = repo.save(user);
		User existUser = entityManager.find(User.class, savedUser.getId());
		assert (user.getEmail()).equals(existUser.getEmail());
	}

}
