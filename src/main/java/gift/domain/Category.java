package gift.domain;

import gift.dto.request.CategoryRequest;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column
    private String imageUrl;

    @Column
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public Category(CategoryRequest categoryRequest) {
        this.name = categoryRequest.getName();
        this.color = categoryRequest.getColor();
        this.imageUrl = categoryRequest.getImageUrl();
        this.description = categoryRequest.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void update(CategoryRequest categoryRequest){
        this.name = categoryRequest.getName();
        this.color = categoryRequest.getColor();
        this.imageUrl = categoryRequest.getImageUrl();
        this.description = categoryRequest.getDescription();
    }
}
