package io.backend.user_verification.email;

public interface EmailSender {
    void send(String to, String email);
}
