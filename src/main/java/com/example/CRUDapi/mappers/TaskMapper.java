package com.example.CRUDapi.mappers;

import com.example.CRUDapi.dto.TaskDto;
import com.example.CRUDapi.entities.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TaskMapper {

    @Autowired
    private ModelMapper mapper;

    public Task toEntity(TaskDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Task.class);
    }

    public TaskDto toDto(Task entity) {
      return Objects.isNull(entity) ? null : mapper.map(entity, TaskDto.class);
    }
}
