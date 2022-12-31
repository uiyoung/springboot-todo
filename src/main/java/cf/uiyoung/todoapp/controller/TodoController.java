package cf.uiyoung.todoapp.controller;

import cf.uiyoung.todoapp.domain.Todo;
import cf.uiyoung.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo postTodo(@Valid @NotNull @RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping
    public Todo updateTodo(@Valid @NotNull @RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
