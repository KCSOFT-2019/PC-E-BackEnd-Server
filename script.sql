create table form
(
    id             int auto_increment
        primary key,
    user_id        bigint      not null,
    user_phone     bigint      not null,
    user_name      varchar(20) not null,
    user_number    bigint      null,
    user_position  varchar(50) null,
    description    text        null,
    type           varchar(30) null comment '维修类型',
    current_status varchar(20) null,
    picture_url    varchar(50) null
);

create table log
(
    id           bigint auto_increment
        primary key,
    form_id      bigint                              not null,
    user_id_from bigint                              not null,
    user_id_to   bigint                              not null,
    chat         varchar(50)                         null,
    gmt_create   timestamp default CURRENT_TIMESTAMP null
);

create table user
(
    id             bigint auto_increment comment '用户id'
        primary key,
    user_name      varchar(30) default '' not null comment '用户名',
    user_number    bigint                 not null comment '学号',
    user_password  varchar(30) default '' not null,
    user_authority int         default 0  null
);

create table user_form_merge
(
    user_id bigint not null,
    form_id bigint not null
);


