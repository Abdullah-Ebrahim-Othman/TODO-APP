package com.example.todos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PasswordUpdateRequest {

    @NotEmpty(message = "Old Password is Mandatory")
    @Size(min = 5, max = 30, message = "oldPassword Must be at least 5 characters long")
    private String oldPassword;

    @NotEmpty(message = "New Password is Mandatory")
    @Size(min = 5, max = 30, message = "newPassword Must be at least 5 characters long")
    private String newPassword;

    @NotEmpty(message = "Confirmed Password is Mandatory")
    @Size(min = 5, max = 30, message = "Confirmed Password Must be at least 5 characters long")
    private String newPassword2;

    public @NotEmpty(message = "Old Password is Mandatory") @Size(min = 5, max = 30, message = "oldPassword Must be at least 5 characters long") String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(@NotEmpty(message = "Old Password is Mandatory") @Size(min = 5, max = 30, message = "oldPassword Must be at least 5 characters long") String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public @NotEmpty(message = "New Password is Mandatory") @Size(min = 5, max = 30, message = "newPassword Must be at least 5 characters long") String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(@NotEmpty(message = "New Password is Mandatory") @Size(min = 5, max = 30, message = "newPassword Must be at least 5 characters long") String newPassword) {
        this.newPassword = newPassword;
    }

    public @NotEmpty(message = "Confirmed Password is Mandatory") @Size(min = 5, max = 30, message = "Confirmed Password Must be at least 5 characters long") String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(@NotEmpty(message = "Confirmed Password is Mandatory") @Size(min = 5, max = 30, message = "Confirmed Password Must be at least 5 characters long") String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
