create table STUDENTS
(
    ID           bigint unsigned auto_increment,
    NAME         varchar(150)                         not null,
    DOB          datetime                             not null,
    ADDRESS      varchar(200)                         not null,
    CONTACT_NO   varchar(14)                          not null,
    CREATED_DATE timestamp  default CURRENT_TIMESTAMP null,
    STATUS       tinyint(1) default 1                 null,
    constraint ID
        unique (ID)
);

alter table STUDENTS
    add primary key (ID);

INSERT INTO STUDENTS(NAME, DOB, ADDRESS, CONTACT_NO) VALUES("Manjit Shakya", "1998-04-12","Lalitpur","9801231231");
INSERT INTO STUDENTS(NAME, DOB, ADDRESS, CONTACT_NO) VALUES("Sameer Maharjan", "1998-05-13","Bhaktapur","9801231232");