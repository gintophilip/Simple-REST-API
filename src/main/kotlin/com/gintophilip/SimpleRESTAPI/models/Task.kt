package com.gintophilip.SimpleRESTAPI.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Task(
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    var taskId:Int=0,
    var taskName: String=""
)