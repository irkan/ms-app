CREATE USER microservice_user WITH PASSWORD 'microservice_user' CREATEDB;
CREATE DATABASE microservice
    WITH
    OWNER = microservice_user
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;