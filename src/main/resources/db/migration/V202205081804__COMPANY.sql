create table "public".company (
   company_id bigint primary key not null,
   "name" varchar(255) not null,
   "cnpj" char(18) not null,
   "phone" varchar(15) not null,
   "created_at" timestamp not null,
   "updated_at" timestamp,
   user_id bigint not null,
   CONSTRAINT fk_company_user FOREIGN KEY (user_id) REFERENCES "user"(user_id)
);

CREATE SEQUENCE company_seq START 1;