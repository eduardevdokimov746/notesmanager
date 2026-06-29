--liquibase formatted sql
--changeset eduard:1 logicalFilePath:dev_data.sql
--comment Data for development

INSERT INTO users (id, login, password, created_at, updated_at) VALUES
    (1, 'admin', '123', '2026-06-29 13:39:30', '2026-06-29 13:39:30'),
    (2, 'user', '123', '2026-06-29 13:39:30', '2026-06-29 13:39:30');

INSERT INTO notes (id, user_id, title, is_picked, is_archive, created_at, updated_at, deleted_at) VALUES
    (1, 1, 'Список покупок', false, false, '2026-06-29 13:39:30', '2026-06-29 13:39:30', null),
    (2, 2, 'Задачи на сегодня', true, false, '2026-06-29 13:39:30', '2026-06-29 13:39:30', null),
    (3, 1, 'Поздравить друга с днем рождения', false, true, '2026-06-29 13:39:30', '2026-06-29 13:39:30', null);