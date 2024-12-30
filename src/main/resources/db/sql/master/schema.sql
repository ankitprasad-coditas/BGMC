CREATE TABLE public.city (
	id int4 NOT NULL,
	"name" varchar(100) NOT NULL,
	districtid int4 NULL,
	state_id int4 NULL,
	description text NOT NULL,
	status varchar(10) DEFAULT NULL::character varying NULL,
	CONSTRAINT city_pkey PRIMARY KEY (id)
);

CREATE TABLE public.district (
	districtid int4 NOT NULL,
	district_title varchar(100) NOT NULL,
	state_id int4 NULL,
	district_description text NOT NULL,
	district_status varchar(10) NOT NULL,
	CONSTRAINT district_pkey PRIMARY KEY (districtid)
);

CREATE TABLE public.state (
	state_id int4 NOT NULL,
	state_title varchar(100) NOT NULL,
	state_description text NOT NULL,
	status varchar(10) NOT NULL,
	CONSTRAINT state_pkey PRIMARY KEY (state_id)
);