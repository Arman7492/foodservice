-- Создание таблицы roles
INSERT INTO roles (id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name)
VALUES (2, 'ROLE_ADMIN');

-- Создание пользователей
INSERT INTO users (id, name, email, password, enabled)
VALUES (1, 'Admin User1', 'admin1@example.com', '{noop}admin123', true),
       (2, 'Admin User2', 'admin2@example.com', '{noop}admin123', true),
       (3, 'User1', 'user1@example.com', '{noop}user123', true),
       (4, 'User2', 'user2@example.com', '{noop}user123', true),
       (5, 'User3', 'user3@example.com', '{noop}user123', true);

-- Установка паролей и ролей
-- Пароли должны быть зашифрованы BCryptPasswordEncoder
-- Для примера пароль 'password'

-- Связь пользователей с ролями
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2); -- Admin1 - ROLE_ADMIN
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2); -- Admin2 - ROLE_ADMIN
INSERT INTO users_roles (user_id, role_id)
VALUES (3, 1); -- User1 - ROLE_USER
INSERT INTO users_roles (user_id, role_id)
VALUES (4, 1); -- User2 - ROLE_USER
INSERT INTO users_roles (user_id, role_id)
VALUES (5, 1); -- User3 - ROLE_USER
