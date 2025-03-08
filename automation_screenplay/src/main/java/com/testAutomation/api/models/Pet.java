package com.testAutomation.api.models;

import lombok.Data;

import java.util.List;

@Data
public class Pet {
    private int id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}