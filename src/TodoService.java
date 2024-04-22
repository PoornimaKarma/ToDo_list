package com.example.To.Do.App.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.To.Do.App.model.todo_list;
import com.example.To.Do.App.repository.listrepository;

import jakarta.persistence.Id;

@Service
public class TodoService {
	  @Autowired
	 listrepository repository;
    public  List<todo_list> getAlltodolist()
    {
	   ArrayList<todo_list> list = new ArrayList<todo_list>();
	   repository.findAll().forEach(todo_list ->list.add(todo_list));
	   
	   return list;
	 
     }
    public todo_list gettodolistbyid(long id)
    {
       return repository.findById(id).get();
    }

   public boolean updatelist(long id)
   {
	   todo_list tl = gettodolistbyid(id);
	   tl.setStatus("completed");
	   return SaveOrUpdatelist(tl);
   }
   public boolean SaveOrUpdatelist(todo_list todo)
   {
	   todo_list obj = repository.save(todo);
	   if(gettodolistbyid(obj.getId())!=null)
        { 
         	return true;
        }
	   return false;
   }
  public  boolean  deletetodolist (long id)
   {
	   repository.deleteById(id);
	   if(gettodolistbyid(id)==null)
	   {
		   return true;
	   }
	   return false;
   }
  
}
