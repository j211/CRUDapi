package com.example.CRUDapi.dto;

public class TaskDto {
        private int id;
        private String title;
        private String description;
        private int userId;

        public TaskDto(int id, String title, String description, int userId) {
                this.id = id;
                this.title = title;
                this.description = description;
                this.userId = userId;
        }

        public TaskDto() {
        }

        public int getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public String getDescription() {
                return description;
        }

        public int getUserId() {
                return userId;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }
}
