package com.app.taskapplication.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TaskCreateDTO {
    //@NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    //@Size(min = 5 , max=50, message = "Name size must be between 5 and 50 characters")
    private String name;
    //@NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    //@Size(min = 10, max = 255, message = "Name size must be between 10 and 255 characters")
    private String description;
    @NotNull(message = "Status is required")
    private Status status;

    @Override
    public String toString() {
        return "TaskCreateDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
