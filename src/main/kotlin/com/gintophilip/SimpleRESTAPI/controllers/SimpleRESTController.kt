package com.gintophilip.SimpleRESTAPI.controllers

import com.gintophilip.SimpleRESTAPI.models.Task
import com.gintophilip.SimpleRESTAPI.repository.TaskRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class SimpleRESTController(var taskRepo: TaskRepository) {

    /*
    returns all tasks
     */
    @GetMapping("/getalltasks")
    fun getAllTasks(): MutableList<Task> {
        var allTasks = taskRepo.findAll()
        return allTasks
    }

    /*
    return single task
     */
    @GetMapping("/gettask/{id}")
    fun getSingleTask(@PathVariable id: Int): Optional<Task> {
        var singleTask = taskRepo.findById(id)
        return singleTask
    }

    /*
    delete a task
     */
    @DeleteMapping("/deletetask/{id}")
    fun deleteTask(@PathVariable id: Int): String {
        try {
            taskRepo.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            return "error when deleting Task"
        }
        return "Task deletion success"
    }

    /*
    update a task
     */
    @PutMapping("/updatetask/{id}")
    fun updateTask(@PathVariable id: Int, @RequestBody body: Task): Task {
        var task = taskRepo.findById(id)
        var updatedTask = task.get()
        updatedTask.taskName = body.taskName
        val result = taskRepo.save(updatedTask)
        return result
    }

    /*
    add a new task
     */
    @PostMapping("/addtask")
    fun addNewTask(@RequestBody task: Task): Task {
        var task = taskRepo.save(task)
        return task
    }
}