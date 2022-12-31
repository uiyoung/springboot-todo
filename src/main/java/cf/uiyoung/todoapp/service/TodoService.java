package cf.uiyoung.todoapp.service;

import cf.uiyoung.todoapp.domain.Todo;
import cf.uiyoung.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getAllTodos(){
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }

    @Transactional
    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

}
