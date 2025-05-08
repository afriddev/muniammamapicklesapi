package com.muniammamapicklesapi.muniammamapicklesapi.models.product;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductModel {

    private String productId;
    private String productName;
    private boolean isKgs = true;
    private boolean isMl = false;
    private double availability;
    private long price;
    private boolean isAvailable;
    private boolean isOutOfStock;
    private String editedBy;
    private List<String> imageUrls;
    private String title;
    private String description;
    private List<String> ingredients;
    private List<String> others;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

}
