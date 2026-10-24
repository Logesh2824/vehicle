package com.example.vehicle.service;

import com.example.vehicle.repository.CategoryRepository;
import com.example.vehicle.dto.request.CategoryRequest;
import com.example.vehicle.dto.response.CategoryResponse;
import com.example.vehicle.entity.Category;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public CategoryResponse createCategory(CategoryRequest request){
        Category category=new Category(request.getName(),request.getDescription());

        Category savedCategory= categoryRepository.save(category);
        return mapToResponse(savedCategory);

    }

    public List<CategoryResponse> getAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    public CategoryResponse getCategoryById(Long id){
        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category with id"+id+"not found"));
        return mapToResponse(category);
    }
    private CategoryResponse mapToResponse(Category category){
        return new CategoryResponse(category.getId(),category.getName(),category.getDescription());
    }

}
