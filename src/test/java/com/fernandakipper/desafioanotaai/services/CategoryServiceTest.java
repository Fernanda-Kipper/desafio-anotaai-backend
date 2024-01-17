package com.fernandakipper.desafioanotaai.services;

import com.fernandakipper.desafioanotaai.domain.category.Category;
import com.fernandakipper.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.fernandakipper.desafioanotaai.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fernandakipper.desafioanotaai.utils.MockCategories.*;
import static com.fernandakipper.desafioanotaai.utils.MockCategories.mockCategoryEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    @Mock
    CategoryRepository repository;

    @Autowired
    @InjectMocks
    CategoryService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    @DisplayName("should delete Category when exists")
    void deleteSuccess() {
        Category category = mockCategoryEntity();
        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.of(category));

        this.service.delete(CATEGORY_ID);

        Mockito.verify(repository, times(1)).delete(category);
    }

    @Test
    @DisplayName("should throw exception when Category not exists")
    void deleteError() {
        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> {
            this.service.delete(CATEGORY_ID);
        });
    }

    @Test
    @DisplayName("should return a Category List on getAll")
    void getAllSuccess() {
        when(repository.findAll()).thenReturn(mockCategoryList());

        List<Category> result = this.service.getAll();

        assertNotNull(result);
        assertEquals(result.get(0).getOwnerId(), OWNER_ID);
        assertEquals(result.get(0).getTitle(), TITLE);
        assertEquals(result.get(0).getDescription(), DESCRIPTION);
    }

    @Test
    void getById() {
    }
}