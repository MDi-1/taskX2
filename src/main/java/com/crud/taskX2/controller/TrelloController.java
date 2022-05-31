package com.crud.taskX2.controller;

import com.crud.taskX2.domain.CreatedTrelloCard;
import com.crud.taskX2.domain.TrelloBoardDto;
import com.crud.taskX2.client.TrelloClient;
import com.crud.taskX2.domain.TrelloCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient client;

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = client.getTrelloBoards();
        trelloBoards.forEach(board -> {
            System.out.println(board.getId() + " - " + board.getName());
            System.out.println("]] This board contains lists: [[");
            board.getLists().forEach(list -> System.out.println(list.getName()+" - "+list.getId()+" - "+list.isClosed()));
        });
    }
    @PostMapping("createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto dto) {
        return client.createNewCard(dto);
    }
}