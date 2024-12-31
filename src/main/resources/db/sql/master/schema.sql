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


-- Add foreign key constraint for 'districtid' in 'city' table referencing 'districtid' in 'district' table
ALTER TABLE public.city
    ADD CONSTRAINT fk_city_district FOREIGN KEY (districtid)
    REFERENCES public.district (districtid)
    ON DELETE CASCADE;

-- Add foreign key constraint for 'state_id' in 'city' table referencing 'state_id' in 'state' table
ALTER TABLE public.city
    ADD CONSTRAINT fk_city_state FOREIGN KEY (state_id)
    REFERENCES public.state (state_id)
    ON DELETE CASCADE;

-- Add foreign key constraint for 'state_id' in 'district' table referencing 'state_id' in 'state' table
ALTER TABLE public.district
    ADD CONSTRAINT fk_district_state FOREIGN KEY (state_id)
    REFERENCES public.state (state_id)
    ON DELETE CASCADE;