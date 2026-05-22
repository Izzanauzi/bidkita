package com.bidkita.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

    @Id
    protected String itemId;

    protected String title;

    protected String description;

    protected String condition;

    @Column(columnDefinition = "TEXT")
    protected String imageBase64;

    public Item() {
        this.itemId = UUID.randomUUID().toString();
    }

    public abstract String displayInfo();

    public abstract String getCategory();

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCondition() { return condition; }
    public String getImageBase64() { return imageBase64; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
}
