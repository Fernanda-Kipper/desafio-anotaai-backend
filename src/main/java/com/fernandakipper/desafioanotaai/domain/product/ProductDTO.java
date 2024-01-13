package com.fernandakipper.desafioanotaai.domain.product;

import jakarta.annotation.Nullable;

public record ProductDTO(String title, String description, String ownerId, Integer price, String categoryId) {
}
