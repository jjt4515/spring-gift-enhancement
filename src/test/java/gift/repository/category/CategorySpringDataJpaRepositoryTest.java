package gift.repository.category;

import gift.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategorySpringDataJpaRepositoryTest {

    @Autowired
    private CategorySpringDataJpaRepository categoryRepository;

    @Test
    public void testFindByName() {
        Category category = new Category("패션");
        categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findByName("패션");

        assertTrue(foundCategory.isPresent());
        assertEquals("패션", foundCategory.get().getName());
    }

    @Test
    public void testExistsByName() {
        Category category = new Category("패션");
        categoryRepository.save(category);

        boolean exists = categoryRepository.existsByName("패션");

        assertTrue(exists);
    }

    @Test
    public void testFindById() {
        Category category = new Category("패션");
        Category savedCategory = categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findById(savedCategory.getId());

        assertTrue(foundCategory.isPresent());
        assertEquals("패션", foundCategory.get().getName());
    }

    @Test
    public void testDelete() {
        Category category = new Category("패션");
        Category savedCategory = categoryRepository.save(category);

        categoryRepository.delete(savedCategory);

        Optional<Category> foundCategory = categoryRepository.findById(savedCategory.getId());

        assertFalse(foundCategory.isPresent());
    }
}
