package com.crud.taskX2.domain;

import lombok.Data;

@Data
public class TrelloCardDto {

    private String name;
    private String description;
    private String pos;
    private String listId;
}