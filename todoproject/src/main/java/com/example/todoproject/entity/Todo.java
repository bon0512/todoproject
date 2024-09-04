package com.example.todoproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long orderNumber;

    @Column
    private String content;

    @Column
    private String status;

    public Todo() {

    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
