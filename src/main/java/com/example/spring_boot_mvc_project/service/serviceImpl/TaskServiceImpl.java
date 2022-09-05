package com.example.spring_boot_mvc_project.service.serviceImpl;

import com.example.spring_boot_mvc_project.model.Task;
import com.example.spring_boot_mvc_project.repository.TaskRepository;
import com.example.spring_boot_mvc_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveTask(Long lessonId, Task task) {
        taskRepository.saveTask(lessonId,task);
    }

    @Override
    public void updateTask(Long id,Task task) {
        taskRepository.updateTask(id,task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return taskRepository.getAllTasks(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
    }
}
