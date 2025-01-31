package com.todo.myTodoManagement;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
      private static List<Todo> todos=new ArrayList<>();
      private static int todosCount=0;
      static {
    	  todos.add(new Todo(++todosCount,"Rohith","learning",LocalDate.now().plusYears(1),false));
    	  todos.add(new Todo(++todosCount,"Rohith","java learning",LocalDate.now().plusYears(3),false));
    	  todos.add(new Todo(++todosCount,"r","devops learning",LocalDate.now().plusMonths(1),false));
    	  todos.add(new Todo(++todosCount,"r","aws",LocalDate.now().plusDays(100),false));
      }
      public List<Todo> findByUsername(String username){
    	  
    	  Predicate<? super Todo> predicate=todo ->todo.getUsername().equalsIgnoreCase(username);
    	  return todos.stream().filter(predicate).toList();
      }
      public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
    	  Todo todo=new Todo(++todosCount,username,description,targetDate,done);
    	  todos.add(todo);
      }
      public void deleteById(int id) {
    	  
    	  Predicate<? super Todo> predicate=todo ->todo.getId()==id;
    	 if(todos.removeIf(predicate)) {
    		 --todosCount;
    	 }
    	 
      }
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		 Predicate<? super Todo> predicate=todo ->todo.getId()==id;
		 Todo todo =todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
	deleteById(todo.getId());
	todos.add(todo);
	}
}
