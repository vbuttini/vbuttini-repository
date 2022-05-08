create table "public"."user" (
   "user_id" bigint primary key not null,
   email varchar(255) not null,
   "password" varchar(100) not null
);

CREATE SEQUENCE user_seq START 1;