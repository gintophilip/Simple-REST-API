package com.gintophilip.SimpleRESTAPI.repository

import com.gintophilip.SimpleRESTAPI.models.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository:JpaRepository<Task,Int> {
}