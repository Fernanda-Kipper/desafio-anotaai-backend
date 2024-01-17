package com.fernandakipper.desafioanotaai.utils;

import com.fernandakipper.desafioanotaai.domain.category.Category;
import com.fernandakipper.desafioanotaai.domain.category.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class MockCategories {
    public static String TITLE = "titulo de teste";
    public static String DESCRIPTION = "descricao de teste";
    public static String OWNER_ID = "1111";
    public static String CATEGORY_ID = "2222";

    public static CategoryDTO mockCategoryDTO(){
        return new CategoryDTO(TITLE, DESCRIPTION, OWNER_ID);
    }

    public static Category mockCategoryEntity(){
        return new Category(mockCategoryDTO());
    }
    public static List<Category> mockCategoryList(){
        Category category = mockCategoryEntity();
        List<Category> listCategories = new ArrayList<>();
        listCategories.add(category);
        return listCategories;
    };
}
