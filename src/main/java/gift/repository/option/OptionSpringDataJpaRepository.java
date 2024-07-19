package gift.repository.option;

import gift.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

public interface OptionSpringDataJpaRepository extends JpaRepository<Option, Long> {
    List<Option> findByProductId(Long productId);

    Optional<Option> findOptionByName(String name);

    Long countOptionByProductId(Long ProductId);
=======
public interface OptionSpringDataJpaRepository extends JpaRepository<Option, Long> {
>>>>>>> a833893 (feat: Product 생성자 수정)
}
