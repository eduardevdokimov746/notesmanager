--liquibase formatted sql
--changeset eduard:1 logicalFilePath:create_body_unit_type_enum.sql

CREATE TYPE body_unit_type AS ENUM ('text', 'list', 'header-1', 'header-2', 'bold', 'underline', 'image', 'url');

--rollback drop type if exists body_unit_type;