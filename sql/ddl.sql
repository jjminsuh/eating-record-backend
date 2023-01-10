create table member (
    id varchar(50) primary key,
    height smallint,
    gender char(1) check(gender in ('F', 'M')),
    age smallint,
    weight smallint,
    num_meal smallint,
    goal varchar(4) check(goal in ('INC', 'DEC', 'KEEP')),
    total_kcal float default 0,
    total_carbohydrate float default 0,
    total_protein float default 0,
    total_fat float default 0,
    total_dietry_fibre float default 0,
    total_VitC float default 0,
    total_VitB1 float default 0,
    total_VitB2 float default 0,
    total_VitB12 float default 0,
    total_niacin float default 0,
    total_folic_acid float default 0,
    total_Ca float default 0,
    total_Na float default 0,
    total_Fe float default 0,
    total_Zn float default 0
)

create table record (
    id serial primary key,
    member_id varchar(50),
    date date,
    degree varchar(6) check(degree in ('OVER', 'ABOVE', 'PROPER')),
    total_kcal int default 0,
    foreign key (member_id) references member(id) on delete cascade
)

create table record_detail (
    record_id int,
    type varchar(9) check(type in ('BREAKFAST', 'LUNCH', 'DINNER', 'SNACK')),
    menu1 char(7),
    menu2 char(7),
    menu3 char(7),
    menu4 char(7),
    menu5 char(7),
    foreign key (record_id) references record(id) on delete cascade,
    foreign key (menu1) references food(food_id),
    foreign key (menu2) references food(food_id),
    foreign key (menu3) references food(food_id),
    foreign key (menu4) references food(food_id),
    foreign key (menu5) references food(food_id)
)

create table food (
    food_id char(7) primary key,
    food_name varchar(50),
    commercial char(1) check(commercial in ('O', 'X')),
    region_manufacturer varchar(20),
    food_type varchar(10),
    detail_type varchar(10),
    portion_size smallint,
    unit varchar(2) check(unit in ('g', 'mL')),
    kcal float default 0,
    carbohydrate float default 0,
    protein float default 0,
    fat float default 0,
    dietry_fibre float default 0,
    VitC float default 0,
    VitB1 float default 0,
    VitB2 float default 0,
    VitB12 float default 0,
    niacin float default 0,
    folic_acid float default 0,
    Ca float default 0,
    Na float default 0,
    Fe float default 0,
    Zn float default 0
)