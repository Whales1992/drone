FROM postgres:12.2-alpine
ENV POSTGRES_USER drone
ENV POSTGRES_PASSWORD drone
ENV POSTGRES_DB drone-db
ENV PGDATA /var/lib/postgresql/data
COPY init.sql /docker-entrypoint-initdb.d/