DELETE FROM oauth_client_details;

INSERT INTO user (username, email, password, activated)
VALUES ('admin', 'admin@admin.com', '$2a$10$1XqtAJZ9EXiuCCK2gy6gTuUEyYFsB97g5op1AXxRHQibf2mNe4x0i', true);

INSERT INTO authority (name)
VALUES ('ROLE_USER'),
('ROLE_ADMIN');

INSERT INTO user_authority (username, authority)
VALUES ('admin', 'ROLE_USER');

INSERT INTO user_authority
(username, authority)
VALUES ('admin', 'ROLE_ADMIN');